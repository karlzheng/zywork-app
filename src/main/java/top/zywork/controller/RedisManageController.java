package top.zywork.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zywork.service.RedisManageService;
import top.zywork.vo.ResponseStatusVO;

import java.util.List;

/**
 * Redis管理控制器类<br/>
 *
 * 创建于2019-01-10<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/redis-manage")
public class RedisManageController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(RedisManageController.class);

    private RedisManageService redisManageService;

    /**
     * 获取key-value，包括失效时间
     * @param pattern
     * @param count
     * @return
     */
    @PostMapping("key-value")
    public ResponseStatusVO listKeys(String pattern, long count) {
        if (count <= 0) {
            return ResponseStatusVO.dataError("count必须大于0", null);
        }
        return ResponseStatusVO.ok("成功获取keys", redisManageService.listKeys(pattern, count));
    }

    /**
     * 获取键的总个数
     * @return
     */
    @GetMapping("keys-count")
    public ResponseStatusVO totalKeys() {
        return ResponseStatusVO.ok("获取Redis键的总个数", redisManageService.totalKeys());
    }

    /**
     * 获取指定key的值与失效时间
     * @param key
     * @return
     */
    @PostMapping("value")
    public ResponseStatusVO getValue(String key) {
        Object value = redisManageService.getValue(key);
        if (value == null) {
            return ResponseStatusVO.dataError("不存在的key", null);
        }
        return ResponseStatusVO.ok("成功获取Redis值", value);
    }

    /**
     * 根据key删除缓存
     * @param key
     * @return
     */
    @PostMapping("del-key")
    public ResponseStatusVO delKey(String key) {
        if (redisManageService.delKey(key)) {
            return ResponseStatusVO.ok("成功删除key为" + key + "的缓存", null);
        }
        return ResponseStatusVO.dataError("删除失败，可能缓存中不存在此key", null);
    }

    /**
     * 根据keys批量删除缓存
     * @param keys
     * @return
     */
    @PostMapping("del-keys")
    public ResponseStatusVO delKey(@RequestParam("keys") List<String> keys) {
       Long count = redisManageService.delKeys(keys);
       int size = keys.size();
       if (count > 0 && count < keys.size()) {
            return ResponseStatusVO.ok("成功删除" + count + "个缓存，" + (keys.size() - count) + "个未删除", null);
       }
       if (count == size) {
           return ResponseStatusVO.ok("成功删除所有指定缓存，共" + count + "个", null);
       }
       return ResponseStatusVO.dataError("全部删除失败", null);
    }

    /**
     * 获取Redis详细信息
     * @return
     */
    @GetMapping("info")
    public ResponseStatusVO info() {
        return ResponseStatusVO.ok("获取Redis详细信息", redisManageService.info());
    }

    @Autowired
    public void setRedisManageService(RedisManageService redisManageService) {
        this.redisManageService = redisManageService;
    }
}
