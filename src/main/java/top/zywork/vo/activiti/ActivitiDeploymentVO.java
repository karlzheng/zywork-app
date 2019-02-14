package top.zywork.vo.activiti;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Activiti的Deployment值对象<br/>
 * 创建于2019-02-14<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public class ActivitiDeploymentVO {

    private String id;
    private String tenantId;
    private String name;
    private String key;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deploymentTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Date getDeploymentTime() {
        return deploymentTime;
    }

    public void setDeploymentTime(Date deploymentTime) {
        this.deploymentTime = deploymentTime;
    }
}
