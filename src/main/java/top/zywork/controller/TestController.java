package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.zywork.annotation.SysLog;
import top.zywork.common.UploadUtils;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.enums.UploadTypeEnum;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.vo.ResponseStatusVO;

@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @PostMapping("add")
    @SysLog(description = "用户添加")
    public ResponseStatusVO add() {
        return new ResponseStatusVO(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), null);
    }

    @PostMapping("edit")
    @SysLog(description = "用户编辑")
    public ResponseStatusVO edit() {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser != null) {
            logger.info("userId: {}, userName: {}", jwtUser.getUserId(), jwtUser.getUsername());
        }
        return new ResponseStatusVO(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), null);
    }

    @GetMapping("remove/{id}")
    @SysLog(description = "用户删除")
    public ResponseStatusVO remove(@PathVariable("id") String id) {
        return new ResponseStatusVO(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), null);
    }

    @PostMapping("upload")
    public ResponseStatusVO upload(MultipartFile file) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (file != null) {
//            statusVO = UploadUtils.uploadImg(file, UploadTypeEnum.IMAGE.getAllowedExts(), UploadTypeEnum.IMAGE.getMaxSize(),
//                "/Users/Wangzhenyu/Desktop", "uploads/image", new float[]{0.8f, 0.5f});
            statusVO = UploadUtils.uploadImg(file, UploadTypeEnum.IMAGE.getAllowedExts(), UploadTypeEnum.IMAGE.getMaxSize(),
                    "/Users/Wangzhenyu/Desktop", "uploads/image", new int[][]{{200, 100}, {400, 260}});
        } else {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "未上传文件", null);
        }
        return statusVO;
    }

}