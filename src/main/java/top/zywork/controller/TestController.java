package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import top.zywork.annotation.SysLog;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.security.JwtUser;
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
        JwtUser jwtUser = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        logger.info("userId: {}, userName: {}", jwtUser.getUserId(), jwtUser.getUsername());
        return new ResponseStatusVO(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), null);
    }

    @GetMapping("remove/{id}")
    @SysLog(description = "用户删除")
    public ResponseStatusVO remove(@PathVariable("id") String id) {
        return new ResponseStatusVO(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), null);
    }

}