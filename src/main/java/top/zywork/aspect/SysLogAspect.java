package top.zywork.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.zywork.annotation.SysLog;
import top.zywork.common.IPUtils;
import top.zywork.common.ReflectUtils;
import top.zywork.common.UserAgentUtils;
import top.zywork.common.WebUtils;
import top.zywork.dto.SysLogDTO;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.SysLogService;
import top.zywork.vo.ResponseStatusVO;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统日志切面，在方法上使用@SysLog注解用于记录系统日志<br />
 * 创建于2017-12-19<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Component
@Aspect
public class SysLogAspect {

    private SysLogService sysLogService;

    private long startTime;

    @Pointcut("@annotation(top.zywork.annotation.SysLog)")
    public void methodAspect() {}

    @Before("methodAspect()")
    public void before(JoinPoint joinPoint) {
        startTime = System.currentTimeMillis();
    }

    @Around("methodAspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        ResponseStatusVO statusVO = null;
        if (result instanceof ResponseStatusVO) {
            statusVO = (ResponseStatusVO) result;
        }
        long endTime = System.currentTimeMillis();
        SysLogDTO sysLogDTO = createSysLogDTO(joinPoint, endTime - startTime);
        sysLogDTO.setExecuteTime(new Timestamp(endTime));
        sysLogDTO.setResponseCode(statusVO == null ? 0 : statusVO.getCode());
        sysLogDTO.setResponseMsg(statusVO == null ? "" : statusVO.getMessage());
        sysLogService.save(sysLogDTO);
        return result;
    }

    @AfterThrowing(pointcut = "methodAspect()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        long endTime = System.currentTimeMillis();
        SysLogDTO sysLogDTO = createSysLogDTO(joinPoint, endTime - startTime);
        sysLogDTO.setExecuteTime(new Timestamp(endTime));
        sysLogDTO.setHasException((byte) 1);
        sysLogDTO.setExceptionMsg(e.getMessage());
        sysLogService.save(sysLogDTO);
    }

    private SysLogDTO createSysLogDTO(JoinPoint joinPoint, long costTime) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        SysLog sysLog = signature.getMethod().getDeclaredAnnotation(SysLog.class);
        SysLogDTO sysLogDTO = new SysLogDTO();
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser != null) {
            sysLogDTO.setUserId(jwtUser.getUserId());
            sysLogDTO.setUserAccount(jwtUser.getUsername());
        }
        sysLogDTO.setDescription(sysLog.description());
        HttpServletRequest request = WebUtils.getServletRequest();
        sysLogDTO.setUserAgent(request.getHeader(UserAgentUtils.USER_AGENT));
        sysLogDTO.setRequestUrl(request.getRequestURL().toString());
        sysLogDTO.setRequestMethod(request.getMethod());
        if (sysLog.requestParams()) {
            Map<String, Object> requestParams = requestParams(joinPoint.getTarget().getClass(), signature.getName(), joinPoint.getArgs());
            sysLogDTO.setRequestParams(requestParams == null ? null : JSON.toJSONString(requestParams));
        }
        sysLogDTO.setExecuteClass(signature.getDeclaringTypeName());
        sysLogDTO.setExecuteMethod(signature.getName());
        sysLogDTO.setExecuteCostTime(costTime);
        sysLogDTO.setExecuteIp(IPUtils.getIP(request));
        return sysLogDTO;
    }

    private Map<String, Object> requestParams(Class<?> clazz, String methodName, Object[] argsArray) {
        String[] argsNames = ReflectUtils.getArgsNamesBySpring(clazz, methodName);
        if (argsNames == null) {
            return null;
        }
        int len = argsNames.length;
        Map<String, Object> requestParams = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            requestParams.put(argsNames[i], argsArray[i]);
        }
        return requestParams;
    }

    @Autowired
    public void setSysLogService(SysLogService sysLogService) {
        this.sysLogService = sysLogService;
    }
}