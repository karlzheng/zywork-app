package top.zywork.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import top.zywork.security.RolePermissionRedisUtils;
import top.zywork.service.SchedulerService;

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

    private RolePermissionRedisUtils rolePermissionRedisUtils;

    private SchedulerService schedulerService;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("zywork-app应用启动……");
        logger.info("开始删除缓存的角色权限信息……");
        rolePermissionRedisUtils.del();
        logger.info("已删除缓存的角色权限信息……");
        logger.info("开始启动自动启动的作业……");
        schedulerService.startAutoJobs();
        logger.info("已启动自动启动的作业……");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("zywork-app应用关闭……");
    }

    @Autowired
    public void setRolePermissionRedisUtils(RolePermissionRedisUtils rolePermissionRedisUtils) {
        this.rolePermissionRedisUtils = rolePermissionRedisUtils;
    }

    @Autowired
    public void setSchedulerService(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }
}
