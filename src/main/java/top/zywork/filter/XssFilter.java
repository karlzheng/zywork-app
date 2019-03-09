package top.zywork.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import top.zywork.common.StringUtils;
import top.zywork.wrapper.XssHttpServletRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * XSSFilter过滤器类<br/>
 *
 * 创建于2019-01-25<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Component(value = "myXssFilter")
@WebFilter(filterName="xssFilter", urlPatterns="/*")
public class XssFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(XssFilter.class);

    @Value("${xssFilter.ignoreUrls}")
    private String[] ignoreUrls;

    @Override
    public void init(FilterConfig config) throws ServletException {
        logger.info("XSSFilter过滤器启动......");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (StringUtils.isInArray(ignoreUrls, httpServletRequest.getRequestURI())) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(new XssHttpServletRequestWrapper(httpServletRequest), response);
        }
    }

    @Override
    public void destroy() {
        logger.info("XSSFilter过滤器销毁......");
    }

}