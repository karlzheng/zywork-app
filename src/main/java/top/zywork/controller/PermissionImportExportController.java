package top.zywork.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.zywork.annotation.SysLog;
import top.zywork.common.IOUtils;
import top.zywork.enums.ContentTypeEnum;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.security.RolePermissionRedisUtils;
import top.zywork.service.PermissionImportExportService;
import top.zywork.service.RoleService;
import top.zywork.vo.PermissionImportExportVO;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.RoleVO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 权限导入导出控制器类<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/permission-import-export")
public class PermissionImportExportController {

    private static final Logger logger = LoggerFactory.getLogger(PermissionImportExportController.class);

    private RoleService roleService;

    private PermissionImportExportService permissionImportExportService;

    private RolePermissionRedisUtils rolePermissionRedisUtils;

    @PostMapping("import-role")
    @SysLog(description = "导入角色", requestParams = false)
    @SuppressWarnings({"unchecked"})
    public ResponseStatusVO importRoles(MultipartFile file) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (file != null) {
            try {
                List roleVOList = IOUtils.readJsonInputStreamToList(file.getInputStream(), RoleVO.class);
                if (roleVOList.size() > 0) {
                    roleService.saveBatch(roleVOList);
                    statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "成功导入角色信息", null);
                } else {
                    statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "JSON文件内没有角色信息", null);
                }
            } catch (IOException e) {
                logger.error("read json from input stream error: {}", e.getMessage());
                statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "JSON文件错误", null);
            }
        } else {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "未上传文件", null);
        }
        return statusVO;
    }

    @PostMapping("import-permission")
    @SysLog(description = "导入权限配置", requestParams = false)
    public ResponseStatusVO importPermissions(MultipartFile file) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (file != null) {
            try {
                List<PermissionImportExportVO> permissionImportExportVOList = IOUtils.readJsonInputStreamToList(file.getInputStream(), PermissionImportExportVO.class);
                permissionImportExportService.importPermissions(permissionImportExportVOList);
                rolePermissionRedisUtils.del();
                statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "成功导入权限配置信息", null);
            } catch (IOException e) {
                logger.error("read json from input stream error: {}", e.getMessage());
                statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "JSON文件错误", null);
            }
        } else {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "未上传文件", null);
        }
        return statusVO;
    }

    @GetMapping("export-permission")
    @SysLog(description = "导出权限配置", requestParams = false)
    public void exportPermissions(HttpServletResponse response) {
        List<PermissionImportExportVO> permissionImportExportVOList = permissionImportExportService.exportPermissions();
        String jsonString = JSON.toJSONString(permissionImportExportVOList);
        response.setContentType(ContentTypeEnum.TEXT_PLAIN.getValue());
        response.addHeader("Content-Disposition", "attachment;fileName=permissions.json");
        try {
            PrintWriter writer = response.getWriter();
            writer.write(jsonString);
        } catch (IOException e) {
            logger.error("writer permissions json file error: {}", e.getMessage());
        }
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setPermissionImportExportService(PermissionImportExportService permissionImportExportService) {
        this.permissionImportExportService = permissionImportExportService;
    }

    @Autowired
    public void setRolePermissionRedisUtils(RolePermissionRedisUtils rolePermissionRedisUtils) {
        this.rolePermissionRedisUtils = rolePermissionRedisUtils;
    }
}