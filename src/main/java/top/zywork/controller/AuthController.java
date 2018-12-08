package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.security.JwtTokenRedisUtils;
import top.zywork.security.JwtUser;
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

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private JwtTokenRedisUtils jwtTokenRedisUtils;

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

    /**
     * 退出登录处理，只有登录过的用户才需要退出
     * @return
     */
    @GetMapping("logout")
    public ResponseStatusVO logout() {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
            jwtTokenRedisUtils.removeToken(jwtUser.getUserId() + "");
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "已安全退出", null);
        } else {
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "未登录，无需退出", null);
        }
        return statusVO;
    }

    @Autowired
    public void setJwtTokenRedisUtils(JwtTokenRedisUtils jwtTokenRedisUtils) {
        this.jwtTokenRedisUtils = jwtTokenRedisUtils;
    }
}
