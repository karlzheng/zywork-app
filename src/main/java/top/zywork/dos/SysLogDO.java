package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * SysLogDO数据对象实体类<br/>
 *
 * 创建于2018-12-18<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class SysLogDO extends BaseDO {

    private static final long serialVersionUID = -9223372035856554121L;

    // 日志编号
	private Long id;
	// 用户编号
	private Long userId;
	// 用户账号
	private String userAccount;
	// 执行说明
	private String description;
	// 请求URL
	private String requestUrl;
	// 请求方式
	private String requestMethod;
	// 请求参数
	private String requestParams;
	// 响应编码
	private Integer responseCode;
	// 响应消息
	private String responseMsg;
	// 完整类名
	private String executeClass;
	// 方法名称
	private String executeMethod;
	// 开始执行时间
	private Date executeTime;
	// 执行耗时(ms)
	private Long executeCostTime;
	// 是否异常
	private Byte hasException;
	// 异常消息
	private String exceptionMsg;
	// IP地址
	private String executeIp;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public SysLogDO () {}

    public SysLogDO (Long id, Long userId, String userAccount, String description, String requestUrl, String requestMethod, String requestParams, Integer responseCode, String responseMsg, String executeClass, String executeMethod, Date executeTime, Long executeCostTime, Byte hasException, String exceptionMsg, String executeIp, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.userAccount = userAccount;
		this.description = description;
		this.requestUrl = requestUrl;
		this.requestMethod = requestMethod;
		this.requestParams = requestParams;
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
		this.executeClass = executeClass;
		this.executeMethod = executeMethod;
		this.executeTime = executeTime;
		this.executeCostTime = executeCostTime;
		this.hasException = hasException;
		this.exceptionMsg = exceptionMsg;
		this.executeIp = executeIp;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isActive = isActive;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getRequestParams() {
		return requestParams;
	}

	public void setRequestParams(String requestParams) {
		this.requestParams = requestParams;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public String getExecuteClass() {
		return executeClass;
	}

	public void setExecuteClass(String executeClass) {
		this.executeClass = executeClass;
	}

	public String getExecuteMethod() {
		return executeMethod;
	}

	public void setExecuteMethod(String executeMethod) {
		this.executeMethod = executeMethod;
	}

	public Date getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(Date executeTime) {
		this.executeTime = executeTime;
	}

	public Long getExecuteCostTime() {
		return executeCostTime;
	}

	public void setExecuteCostTime(Long executeCostTime) {
		this.executeCostTime = executeCostTime;
	}

	public Byte getHasException() {
		return hasException;
	}

	public void setHasException(Byte hasException) {
		this.hasException = hasException;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getExecuteIp() {
		return executeIp;
	}

	public void setExecuteIp(String executeIp) {
		this.executeIp = executeIp;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	
    @Override
    public String toString() {
        return "SysLogDO {" +
                "id = " + id + 
				", userId = " + userId + 
				", userAccount = " + userAccount + 
				", description = " + description + 
				", requestUrl = " + requestUrl + 
				", requestMethod = " + requestMethod + 
				", requestParams = " + requestParams + 
				", responseCode = " + responseCode + 
				", responseMsg = " + responseMsg + 
				", executeClass = " + executeClass + 
				", executeMethod = " + executeMethod + 
				", executeTime = " + executeTime + 
				", executeCostTime = " + executeCostTime + 
				", hasException = " + hasException + 
				", exceptionMsg = " + exceptionMsg + 
				", executeIp = " + executeIp + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
