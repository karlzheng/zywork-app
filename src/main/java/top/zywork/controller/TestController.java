package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import top.zywork.security.JwtUser;

@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("add")
    public String add() {
        return "add";
    }

    @GetMapping("edit")
    public String edit() {
        JwtUser jwtUser = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        logger.info("userId: {}, userName: {}", jwtUser.getUserId(), jwtUser.getUsername());
        return "edit";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id") String id) {
        return "remove";
    }

}