package top.zywork.dos;

/**
 * 系统配置DO对象，用于获取系统配置信息<br/>
 *
 * 创建于2018-12-17<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public class SysConfigQueryDO {

    private Long id;
    private String name;
    private String value;
    private String comment;

    public SysConfigQueryDO() {}

    public SysConfigQueryDO(Long id, String name, String value, String comment) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
