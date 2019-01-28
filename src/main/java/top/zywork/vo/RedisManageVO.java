package top.zywork.vo;

import java.util.Objects;

/**
 * RedisManageVO值对象类<br/>
 *
 * 创建于2019-01-10<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class RedisManageVO {

    private String key;
    private Object value;
    private Long size;
    private Long expire;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RedisManageVO that = (RedisManageVO) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
