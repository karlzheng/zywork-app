package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.zywork.common.BeanUtils;
import top.zywork.common.BindingResultUtils;
import top.zywork.common.StringUtils;
import top.zywork.dto.PagerDTO;
import top.zywork.dto.PermissionDTO;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.exception.ServiceException;
import top.zywork.query.PermissionQuery;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.PermissionService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.PagerVO;
import top.zywork.vo.PermissionVO;

import java.util.List;

/**
 * PermissionController控制器类<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/permission")
public class PermissionController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(PermissionController.class);

    private PermissionService permissionService;

    @PostMapping("admin/save")
    public ResponseStatusVO save(@RequestBody @Validated PermissionVO permissionVO, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                permissionService.save(BeanUtils.copy(permissionVO, PermissionDTO.class));
                statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "添加成功", null);
            } catch (ServiceException e) {
                logger.error("添加失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "添加失败", null);
            }
        }
        return statusVO;
    }

    @PostMapping("admin/batch-save")
    public ResponseStatusVO saveBatch(@RequestBody @Validated List<PermissionVO> permissionVOList, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                permissionService.saveBatch(BeanUtils.copyListObj(permissionVOList, PermissionDTO.class));
                statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "批量添加成功", null);
            } catch (ServiceException e) {
                logger.error("添加失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "批量添加失败", null);
            }
        }
        return statusVO;
    }

    @GetMapping("admin/remove/{id}")
    public ResponseStatusVO removeById(@PathVariable("id") Long id) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            permissionService.removeById(id);
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "删除成功", null);
        } catch (ServiceException e) {
            logger.error("删除失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "删除失败", null);
        }
        return statusVO;
    }

    @PostMapping("admin/batch-remove")
    public ResponseStatusVO removeByIds(@RequestBody String[] ids) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            permissionService.removeByIds(StringUtils.strArrayToLongArray(ids));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "批量删除成功", null);
        } catch (ServiceException e) {
            logger.error("批量删除失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "批量删除失败", null);
        }
        return statusVO;
    }

    @PostMapping("admin/update")
    public ResponseStatusVO update(@RequestBody @Validated PermissionVO permissionVO, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                int updateRows = permissionService.update(BeanUtils.copy(permissionVO, PermissionDTO.class));
                if (updateRows == 1) {
                    statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "更新成功", null);
                } else {
                    statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "数据版本号有问题，在此更新前数据已被更新", null);
                }
            } catch (ServiceException e) {
                logger.error("更新失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "更新失败", null);
            }
        }
        return statusVO;
    }

    @PostMapping("admin/batch-update")
    public ResponseStatusVO updateBatch(@RequestBody @Validated List<PermissionVO> permissionVOList, BindingResult bindingResult) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (bindingResult.hasErrors()) {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), BindingResultUtils.errorString(bindingResult), null);
        } else {
            try {
                permissionService.updateBatch(BeanUtils.copyListObj(permissionVOList, PermissionDTO.class));
                statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "批量更新成功", null);
            } catch (ServiceException e) {
                logger.error("批量更新失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "批量更新失败", null);
            }
        }
        return statusVO;
    }

    @PostMapping("admin/active")
    public ResponseStatusVO active(@RequestBody PermissionVO permissionVO) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            permissionService.update(BeanUtils.copy(permissionVO, PermissionDTO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "激活或冻结成功", null);
        } catch (ServiceException e) {
            logger.error("激活或冻结失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "激活或冻结失败", null);
        }
        return statusVO;
    }

    @PostMapping("admin/batch-active")
    public ResponseStatusVO activeBatch(@RequestBody @Validated List<PermissionVO> permissionVOList) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            permissionService.updateBatch(BeanUtils.copyListObj(permissionVOList, PermissionDTO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "批量激活或冻结成功", null);
        } catch (ServiceException e) {
            logger.error("批量激活或冻结失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "批量激活或冻结失败", null);
        }
        return statusVO;
    }

    @GetMapping("admin/one/{id}")
    public ResponseStatusVO getById(@PathVariable("id") Long id) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        PermissionVO permissionVO = new PermissionVO();
        try {
            Object obj = permissionService.getById(id);
            if (obj != null) {
                permissionVO = BeanUtils.copy(obj, PermissionVO.class);
            }
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", permissionVO);
        } catch (ServiceException e) {
            logger.error("返回单个对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    @GetMapping("admin/all")
    public ResponseStatusVO listAll() {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            PagerDTO pagerDTO = permissionService.listAll();
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), PermissionVO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回所有对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    /**
     * 获取用户的所有权限
     * @return
     */
    @GetMapping("user/all")
    public ResponseStatusVO userListAll() {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser != null) {
            try {
                PagerDTO pagerDTO = permissionService.listByUserId(jwtUser.getUserId());
                PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
                pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), PermissionVO.class));
                statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", pagerVO);
            } catch (ServiceException e) {
                logger.error("返回所有对象JSON数据失败：{}", e.getMessage());
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
            }
        } else {
            statusVO.okStatus(ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(), ResponseStatusEnum.AUTHENTICATION_ERROR.getMessage(), null);
        }
        return statusVO;
    }

    @PostMapping("admin/pager-cond")
    public ResponseStatusVO listPageByCondition(@RequestBody PermissionQuery permissionQuery) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        try {
            PagerDTO pagerDTO = permissionService.listPageByCondition(permissionQuery);
            PagerVO pagerVO = BeanUtils.copy(pagerDTO, PagerVO.class);
            pagerVO.setRows(BeanUtils.copyList(pagerDTO.getRows(), PermissionVO.class));
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "查询成功", pagerVO);
        } catch (ServiceException e) {
            logger.error("返回指定条件的分页对象JSON数据失败：{}", e.getMessage());
            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "查询失败", null);
        }
        return statusVO;
    }

    @Autowired
    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }
}
