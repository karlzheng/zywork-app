package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * SysLogVO值对象类<br/>
 *
 * 创建于2018-12-25<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class SysLogVO extends BaseVO {

    private static final long serialVersionUID = -9223372036223858545L;

    // 日志编号
	private Long id;
	// 用户编号
	private Long userId;
	// 用户账号
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String userAccount;
	// 执行说明
	@Size(min = 0, max = 200, message = "必须小于200个字符")
	private String description;
	// User-Agent
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String userAgent;
	// 请求URL
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String requestUrl;
	// 请求方式
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String requestMethod;
	// 请求参数
	@Size(min = 0, max = 2000, message = "必须小于2000个字符")
	private String requestParams;
	// 响应编码
	private Integer responseCode;
	// 响应消息
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String responseMsg;
	// 完整类名
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String executeClass;
	// 方法名称
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String executeMethod;
	// 开始执行时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date executeTime;
	// 执行耗时(ms)
	private Long executeCostTime;
	// 是否异常
	private Byte hasException;
	// 异常消息
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String exceptionMsg;
	// IP地址
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String executeIp;
	// 版本号
	private Integer version;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public SysLogVO () {}

    public SysLogVO (Long id, Long userId, String userAccount, String description, String userAgent, String requestUrl, String requestMethod, String requestParams, Integer responseCode, String responseMsg, String executeClass, String executeMethod, Date executeTime, Long executeCostTime, Byte hasException, String exceptionMsg, String executeIp, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.userAccount = userAccount;
		this.description = description;
		this.userAgent = userAgent;
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
		this.version = version;
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

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
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
        return "SysLogVO {" +
                "id = " + id + 
				", userId = " + userId + 
				", userAccount = " + userAccount + 
				", description = " + description + 
				", userAgent = " + userAgent + 
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
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
