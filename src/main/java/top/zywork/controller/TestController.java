package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.zywork.annotation.SysLog;
import top.zywork.common.UploadUtils;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.enums.StorageProviderEnum;
import top.zywork.enums.UploadTypeEnum;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UploadService;
import top.zywork.vo.ResponseStatusVO;

@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private UploadService uploadService;

    @PostMapping("add")
    @SysLog(description = "用户添加")
    public ResponseStatusVO add() {
        return ResponseStatusVO.ok(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), null);
    }

    @PostMapping("edit")
    @SysLog(description = "用户编辑")
    public ResponseStatusVO edit() {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser != null) {
            logger.info("userId: {}, userName: {}", jwtUser.getUserId(), jwtUser.getUsername());
        }
        return ResponseStatusVO.ok(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), null);
    }

    @GetMapping("remove/{id}")
    @SysLog(description = "用户删除")
    public ResponseStatusVO remove(@PathVariable("id") String id) {
        return ResponseStatusVO.ok(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), null);
    }

    @PostMapping("upload")
    public ResponseStatusVO upload(MultipartFile file) {
        if (file == null) {
            return ResponseStatusVO.dataError("未上传文件", null);
        }
        UploadUtils.UploadOptions uploadOptions = new UploadUtils.UploadOptions("./upload", "test", "dbSaveUrl");
        uploadOptions.generateCompressSizes("200x200,300x300");
        return uploadService.uploadFile(StorageProviderEnum.LOCAL.getProvider(), file, UploadTypeEnum.IMAGE.getAllowedExts(), UploadTypeEnum.IMAGE.getMaxSize(), uploadOptions);
    }

    @Autowired
    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
    }
}