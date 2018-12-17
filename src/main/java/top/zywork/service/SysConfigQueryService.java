package top.zywork.service;

/**
 * 系统配置Service接口，用于获取系统配置信息<br/>
 *
 * 创建于2018-12-17<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public interface SysConfigQueryService {

    /**
     * 根据配置名称查询配置信息，配置信息封装成对应的JavaBean，并进行redis缓存
     * @param name 配置名
     * @param tClass 配置JSON值对应的JavaBean
     * @param <T>
     * @return
     */
    <T> T getByName(String name, Class<T> tClass);

}
