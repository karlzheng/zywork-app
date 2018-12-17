package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.zywork.common.IOUtils;
import top.zywork.dao.SysConfigQueryDAO;
import top.zywork.dos.SysConfigQueryDO;
import top.zywork.service.SysConfigQueryService;

/**
 * 系统配置Service实现类，用于获取系统配置信息<br/>
 *
 * 创建于2018-12-17<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Service
public class SysConfigQueryServiceImpl implements SysConfigQueryService {

    private SysConfigQueryDAO sysConfigQueryDAO;

    @Override
    @Cacheable(value = "sys_config", key = "#name", unless="#result == null")
    public <T> T getByName(String name, Class<T> tClass) {
        T t = null;
        SysConfigQueryDO sysConfigQueryDO = sysConfigQueryDAO.getByName(name);
        if (sysConfigQueryDO != null) {
            t = IOUtils.readJsonStrToObject(sysConfigQueryDO.getValue(), tClass);
        }
        return t;
    }

    @Autowired
    public void setSysConfigQueryDAO(SysConfigQueryDAO sysConfigQueryDAO) {
        this.sysConfigQueryDAO = sysConfigQueryDAO;
    }

}
