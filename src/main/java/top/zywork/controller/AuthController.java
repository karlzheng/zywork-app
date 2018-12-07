package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.vo.ResponseStatusVO;

/**
 * SpringSecurity的用户认证控制器<br/>
 *
 * 创建于2018-12-03<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    /**
     * login处理
     */
    @PostMapping("login")
    public void login(String username, String password) {}

    /**
     * 未认证处理
     * @return
     */
    @GetMapping("require")
    public ResponseStatusVO require() {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        statusVO.errorStatus(ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(),
                ResponseStatusEnum.AUTHENTICATION_ERROR.getMessage(), null);
        return statusVO;
    }
}
