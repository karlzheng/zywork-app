package top.zywork.dao;

import org.springframework.stereotype.Repository;
import top.zywork.dos.SysConfigQueryDO;

/**
 * 系统配置DAO对象，用于获取系统配置信息<br/>
 *
 * 创建于2018-12-17<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Repository
public interface SysConfigQueryDAO {

    /**
     * 根据配置名称查询配置对象
     * @param name
     * @return
     */
    SysConfigQueryDO getByName(String name);

}
