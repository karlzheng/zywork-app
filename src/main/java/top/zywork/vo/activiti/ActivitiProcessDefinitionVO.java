package top.zywork.vo.activiti;

import java.util.Map;

/**
 * Activiti的ProcessDefinition值对象<br/>
 * 创建于2019-02-14<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public class ActivitiProcessDefinitionVO {

    private String id;
    private String key;
    private String name;
    private Integer version;
    private String deploymentId;
    private String tenantId;
    private String description;
    private String resourceName;
    private String diagramResourceName;
    private String category;
    private Boolean hasStartFormKey;
    private Integer revision;
    private Map<String, Object> variables;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getDiagramResourceName() {
        return diagramResourceName;
    }

    public void setDiagramResourceName(String diagramResourceName) {
        this.diagramResourceName = diagramResourceName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getHasStartFormKey() {
        return hasStartFormKey;
    }

    public void setHasStartFormKey(Boolean hasStartFormKey) {
        this.hasStartFormKey = hasStartFormKey;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }
}
