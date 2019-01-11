package top.zywork.service;

import top.zywork.dto.PagerDTO;

import java.util.List;
import java.util.Properties;

/**
 * Redis管理服务接口<br/>
 *
 * 创建于2019-01-10<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public interface RedisManageService {

    /**
     * 根据指定模式和搜索个数列出所有RedisManageVO，只包含key
     * @param pattern
     * @param count
     * @return
     */
    public PagerDTO listKeys(String pattern, long count);

    /**
     * 根据指定模式和搜索个数列出所有RedisManageVO
     * @param pattern
     * @param count
     * @return
     */
    PagerDTO listKeyValues(String pattern, long count);

    /**
     * 获取key的总个数
     * @return
     */
    Long totalKeys();

    /**
     * 根据key获取RedisManageVO
     * @param key
     * @return
     */
    Object getValue(String key);

    /**
     * 根据key删除缓存
     * @param key
     */
    boolean delKey(String key);

    /**
     * 根据key集合批量删除缓存
     * @param keys
     * @return
     */
    Long delKeys(List<String> keys);

    /**
     * 获取Redis详细信息
     * @return
     */
    Properties info();

}
