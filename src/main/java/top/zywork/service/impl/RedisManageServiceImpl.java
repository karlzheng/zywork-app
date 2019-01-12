package top.zywork.service.impl;

import io.jsonwebtoken.lang.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisServerCommands;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;
import top.zywork.dto.PagerDTO;
import top.zywork.service.RedisManageService;
import top.zywork.vo.RedisManageVO;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis管理服务接口实现类<br/>
 *
 * 创建于2019-01-10<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service
public class RedisManageServiceImpl implements RedisManageService {

    private RedisTemplate<String, Object> redisTemplate;

    @Override
    @SuppressWarnings({"unchecked"})
    public PagerDTO listKeys(String pattern, long count) {
        Cursor<byte[]> cursor = redisTemplate.executeWithStickyConnection(redisConnection -> redisConnection.scan(ScanOptions.scanOptions().match(pattern).count(count).build()));
        PagerDTO pagerDTO = new PagerDTO();
        if (cursor == null) {
            pagerDTO.setRows(null);
            return pagerDTO;
        }
        Set<Object> keyValues = new HashSet<>();
        long c = 0;
        while (cursor.hasNext()) {
            RedisManageVO redisManageVO = new RedisManageVO();
            redisManageVO.setKey(new String(cursor.next()));
            keyValues.add(redisManageVO);
            c++;
        }
        pagerDTO.setTotal(c);
        pagerDTO.setRows(Collections.arrayToList(keyValues.toArray()));
        return pagerDTO;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public PagerDTO listKeyValues(String pattern, long count) {
        Cursor<byte[]> cursor = redisTemplate.executeWithStickyConnection(redisConnection -> redisConnection.scan(ScanOptions.scanOptions().match(pattern).count(count).build()));
        PagerDTO pagerDTO = new PagerDTO();
        if (cursor == null) {
            pagerDTO.setRows(null);
            return pagerDTO;
        }
        Set<Object> keyValues = new HashSet<>();
        long c = 0;
        while (cursor.hasNext()) {
            keyValues.add(getValue(new String(cursor.next())));
            c++;
        }
        pagerDTO.setTotal(c);
        pagerDTO.setRows(Collections.arrayToList(keyValues.toArray()));
        return pagerDTO;
    }

    @Override
    public Long totalKeys() {
        return redisTemplate.execute(RedisServerCommands::dbSize);
    }

    @Override
    public Object getValue(String key) {
        Boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey != null && hasKey) {
            RedisManageVO redisManageVO = new RedisManageVO();
            redisManageVO.setKey(key);
            ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
            redisManageVO.setValue(valueOperations.get(key));
            redisManageVO.setSize(valueOperations.size(key));
            redisManageVO.setExpire(redisTemplate.getExpire(key, TimeUnit.MILLISECONDS));
            return redisManageVO;
        }
        return null;
    }

    @Override
    public boolean delKey(String key) {
        Boolean deleted = redisTemplate.delete(key);
        return deleted != null && deleted;
    }

    @Override
    public Long delKeys(List<String> keys) {
        return redisTemplate.delete(keys);
    }

    @Override
    public Properties info() {
        return redisTemplate.execute((RedisCallback<Properties>) RedisServerCommands::info);
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
