package top.zywork.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import top.zywork.annotation.SysLog;
import top.zywork.common.IPUtils;
import top.zywork.common.WebUtils;
import top.zywork.dto.SysLogDTO;
import top.zywork.security.JwtUser;
import top.zywork.service.SysLogService;
import top.zywork.vo.ResponseStatusVO;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

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
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        SysLogDTO sysLogDTO = createSysLogDTO(signature, endTime - startTime);
        sysLogDTO.setRequestParams(JSON.toJSONString(joinPoint.getArgs()));
        sysLogDTO.setExecuteTime(new Timestamp(endTime));
        sysLogDTO.setResponseCode(statusVO == null ? 0 : statusVO.getCode());
        sysLogDTO.setResponseMsg(statusVO == null ? "" : statusVO.getMessage());
        sysLogService.save(sysLogDTO);
        return result;
    }

    @AfterThrowing(pointcut = "methodAspect()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        long endTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        SysLogDTO sysLogDTO = createSysLogDTO(signature, endTime - startTime);
        sysLogDTO.setRequestParams(JSON.toJSONString(joinPoint.getArgs()));
        sysLogDTO.setExecuteTime(new Timestamp(endTime));
        sysLogDTO.setHasException((byte) 1);
        sysLogDTO.setExceptionMsg(e.getMessage());
        sysLogService.save(sysLogDTO);
    }

    private SysLogDTO createSysLogDTO(MethodSignature signature, long costTime) {
        SysLog sysLog = signature.getMethod().getDeclaredAnnotation(SysLog.class);
        SysLogDTO sysLogDTO = new SysLogDTO();
        JwtUser jwtUser = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        sysLogDTO.setUserId(jwtUser.getUserId());
        sysLogDTO.setUserAccount(jwtUser.getUsername());
        sysLogDTO.setDescription(sysLog.description());
        HttpServletRequest request = WebUtils.getServletRequest();
        sysLogDTO.setRequestUrl(request.getRequestURL().toString());
        sysLogDTO.setRequestMethod(request.getMethod());
        sysLogDTO.setExecuteClass(signature.getDeclaringTypeName());
        sysLogDTO.setExecuteMethod(signature.getName());
        sysLogDTO.setExecuteCostTime(costTime);
        sysLogDTO.setExecuteIp(IPUtils.getIP(request));
        return sysLogDTO;
    }

    @Autowired
    public void setSysLogService(SysLogService sysLogService) {
        this.sysLogService = sysLogService;
    }
}