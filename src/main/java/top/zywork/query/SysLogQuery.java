package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * SysLogQuery查询对象类<br/>
 *
 * 创建于2018-12-18<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class SysLogQuery extends PageQuery {

    private static final long serialVersionUID = -9223372034753474023L;

    // 日志编号
	private Long id;
	// 日志编号（最小值）
	private Long idMin;
	// 日志编号（最大值）
	private Long idMax;
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
	// 用户账号
	private String userAccount;
	// 执行说明
	private String description;
	// User-Agent
	private String userAgent;
	// 请求URL
	private String requestUrl;
	// 请求方式
	private String requestMethod;
	// 请求参数
	private String requestParams;
	// 响应编码
	private Integer responseCode;
	// 响应编码（最小值）
	private Integer responseCodeMin;
	// 响应编码（最大值）
	private Integer responseCodeMax;
	// 响应消息
	private String responseMsg;
	// 完整类名
	private String executeClass;
	// 方法名称
	private String executeMethod;
	// 开始执行时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date executeTime;
	// 开始执行时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date executeTimeMin;
	// 开始执行时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date executeTimeMax;
	// 执行耗时(ms)
	private Long executeCostTime;
	// 执行耗时(ms)（最小值）
	private Long executeCostTimeMin;
	// 执行耗时(ms)（最大值）
	private Long executeCostTimeMax;
	// 是否异常
	private Byte hasException;
	// 是否异常（最小值）
	private Byte hasExceptionMin;
	// 是否异常（最大值）
	private Byte hasExceptionMax;
	// 异常消息
	private String exceptionMsg;
	// IP地址
	private String executeIp;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMax;
	// 是否激活
	private Byte isActive;
	// 是否激活（最小值）
	private Byte isActiveMin;
	// 是否激活（最大值）
	private Byte isActiveMax;
	
    public SysLogQuery () {}

    public SysLogQuery (Long id, Long idMin, Long idMax, Long userId, Long userIdMin, Long userIdMax, String userAccount, String description, String userAgent, String requestUrl, String requestMethod, String requestParams, Integer responseCode, Integer responseCodeMin, Integer responseCodeMax, String responseMsg, String executeClass, String executeMethod, Date executeTime, Date executeTimeMin, Date executeTimeMax, Long executeCostTime, Long executeCostTimeMin, Long executeCostTimeMax, Byte hasException, Byte hasExceptionMin, Byte hasExceptionMax, String exceptionMsg, String executeIp, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.userAccount = userAccount;
		this.description = description;
		this.userAgent = userAgent;
		this.requestUrl = requestUrl;
		this.requestMethod = requestMethod;
		this.requestParams = requestParams;
		this.responseCode = responseCode;
		this.responseCodeMin = responseCodeMin;
		this.responseCodeMax = responseCodeMax;
		this.responseMsg = responseMsg;
		this.executeClass = executeClass;
		this.executeMethod = executeMethod;
		this.executeTime = executeTime;
		this.executeTimeMin = executeTimeMin;
		this.executeTimeMax = executeTimeMax;
		this.executeCostTime = executeCostTime;
		this.executeCostTimeMin = executeCostTimeMin;
		this.executeCostTimeMax = executeCostTimeMax;
		this.hasException = hasException;
		this.hasExceptionMin = hasExceptionMin;
		this.hasExceptionMax = hasExceptionMax;
		this.exceptionMsg = exceptionMsg;
		this.executeIp = executeIp;
		this.createTime = createTime;
		this.createTimeMin = createTimeMin;
		this.createTimeMax = createTimeMax;
		this.updateTime = updateTime;
		this.updateTimeMin = updateTimeMin;
		this.updateTimeMax = updateTimeMax;
		this.isActive = isActive;
		this.isActiveMin = isActiveMin;
		this.isActiveMax = isActiveMax;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMin() {
		return idMin;
	}

	public void setIdMin(Long idMin) {
		this.idMin = idMin;
	}

	public Long getIdMax() {
		return idMax;
	}

	public void setIdMax(Long idMax) {
		this.idMax = idMax;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdMin() {
		return userIdMin;
	}

	public void setUserIdMin(Long userIdMin) {
		this.userIdMin = userIdMin;
	}

	public Long getUserIdMax() {
		return userIdMax;
	}

	public void setUserIdMax(Long userIdMax) {
		this.userIdMax = userIdMax;
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

	public Integer getResponseCodeMin() {
		return responseCodeMin;
	}

	public void setResponseCodeMin(Integer responseCodeMin) {
		this.responseCodeMin = responseCodeMin;
	}

	public Integer getResponseCodeMax() {
		return responseCodeMax;
	}

	public void setResponseCodeMax(Integer responseCodeMax) {
		this.responseCodeMax = responseCodeMax;
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

	public Date getExecuteTimeMin() {
		return executeTimeMin;
	}

	public void setExecuteTimeMin(Date executeTimeMin) {
		this.executeTimeMin = executeTimeMin;
	}

	public Date getExecuteTimeMax() {
		return executeTimeMax;
	}

	public void setExecuteTimeMax(Date executeTimeMax) {
		this.executeTimeMax = executeTimeMax;
	}

	public Long getExecuteCostTime() {
		return executeCostTime;
	}

	public void setExecuteCostTime(Long executeCostTime) {
		this.executeCostTime = executeCostTime;
	}

	public Long getExecuteCostTimeMin() {
		return executeCostTimeMin;
	}

	public void setExecuteCostTimeMin(Long executeCostTimeMin) {
		this.executeCostTimeMin = executeCostTimeMin;
	}

	public Long getExecuteCostTimeMax() {
		return executeCostTimeMax;
	}

	public void setExecuteCostTimeMax(Long executeCostTimeMax) {
		this.executeCostTimeMax = executeCostTimeMax;
	}

	public Byte getHasException() {
		return hasException;
	}

	public void setHasException(Byte hasException) {
		this.hasException = hasException;
	}

	public Byte getHasExceptionMin() {
		return hasExceptionMin;
	}

	public void setHasExceptionMin(Byte hasExceptionMin) {
		this.hasExceptionMin = hasExceptionMin;
	}

	public Byte getHasExceptionMax() {
		return hasExceptionMax;
	}

	public void setHasExceptionMax(Byte hasExceptionMax) {
		this.hasExceptionMax = hasExceptionMax;
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

	public Date getCreateTimeMin() {
		return createTimeMin;
	}

	public void setCreateTimeMin(Date createTimeMin) {
		this.createTimeMin = createTimeMin;
	}

	public Date getCreateTimeMax() {
		return createTimeMax;
	}

	public void setCreateTimeMax(Date createTimeMax) {
		this.createTimeMax = createTimeMax;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTimeMin() {
		return updateTimeMin;
	}

	public void setUpdateTimeMin(Date updateTimeMin) {
		this.updateTimeMin = updateTimeMin;
	}

	public Date getUpdateTimeMax() {
		return updateTimeMax;
	}

	public void setUpdateTimeMax(Date updateTimeMax) {
		this.updateTimeMax = updateTimeMax;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	public Byte getIsActiveMin() {
		return isActiveMin;
	}

	public void setIsActiveMin(Byte isActiveMin) {
		this.isActiveMin = isActiveMin;
	}

	public Byte getIsActiveMax() {
		return isActiveMax;
	}

	public void setIsActiveMax(Byte isActiveMax) {
		this.isActiveMax = isActiveMax;
	}

	
    @Override
    public String toString() {
        return "SysLogQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", userAccount = " + userAccount + 
				", description = " + description + 
				", userAgent = " + userAgent + 
				", requestUrl = " + requestUrl + 
				", requestMethod = " + requestMethod + 
				", requestParams = " + requestParams + 
				", responseCode = " + responseCode + 
				", responseCodeMin = " + responseCodeMin + 
				", responseCodeMax = " + responseCodeMax + 
				", responseMsg = " + responseMsg + 
				", executeClass = " + executeClass + 
				", executeMethod = " + executeMethod + 
				", executeTime = " + executeTime + 
				", executeTimeMin = " + executeTimeMin + 
				", executeTimeMax = " + executeTimeMax + 
				", executeCostTime = " + executeCostTime + 
				", executeCostTimeMin = " + executeCostTimeMin + 
				", executeCostTimeMax = " + executeCostTimeMax + 
				", hasException = " + hasException + 
				", hasExceptionMin = " + hasExceptionMin + 
				", hasExceptionMax = " + hasExceptionMax + 
				", exceptionMsg = " + exceptionMsg + 
				", executeIp = " + executeIp + 
				", createTime = " + createTime + 
				", createTimeMin = " + createTimeMin + 
				", createTimeMax = " + createTimeMax + 
				", updateTime = " + updateTime + 
				", updateTimeMin = " + updateTimeMin + 
				", updateTimeMax = " + updateTimeMax + 
				", isActive = " + isActive + 
				", isActiveMin = " + isActiveMin + 
				", isActiveMax = " + isActiveMax + 
				" }";
    }

}
