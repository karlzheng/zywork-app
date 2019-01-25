package top.zywork.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@WebFilter(filterName="xssFilter", urlPatterns="/*")
public class XssFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(XssFilter.class);

    @Override
    public void init(FilterConfig config) throws ServletException {
        logger.info("XSSFilter init......");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        XssHttpServletRequestWrapper xssHttpServletRequestWrapper = new XssHttpServletRequestWrapper((HttpServletRequest)request);
        chain.doFilter(xssHttpServletRequestWrapper, response);
    }

    @Override
    public void destroy() {
        logger.info("XSSFilter destroy......");
    }

}