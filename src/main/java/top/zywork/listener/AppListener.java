package top.zywork.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * App监听器<br/>
 *
 * 创建于2018-10-26<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@WebListener
public class AppListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(AppListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("zywork-app应用启动……");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("zywork-app应用关闭……");
    }
}
