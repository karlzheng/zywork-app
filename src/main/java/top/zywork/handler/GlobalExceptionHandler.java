package top.zywork.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.vo.ResponseStatusVO;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理，返回系统错误json<br/>
 *
 * 创建于2018-12-08<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseStatusVO allExceptionHandler(HttpServletRequest request, Exception exception) {
        logger.error("全局异常, 请求地址：{}， 错误消息：{}", request.getRequestURL(), exception.getMessage());
        ResponseStatusVO statusVO = new ResponseStatusVO();
        statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), ResponseStatusEnum.ERROR.getMessage(), null);
        return statusVO;
    }

}