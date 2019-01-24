package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserMessageQuery查询对象类<br/>
 *
 * 创建于2019-01-24<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserMessageQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036722495777L;

    //t_user表的字段对应的属性
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
	// 手机号
	private String userPhone;
	// 用户邮箱
	private String userEmail;
	//t_message表的字段对应的属性
	// 消息编号
	private Long messageId;
	// 消息编号（最小值）
	private Long messageIdMin;
	// 消息编号（最大值）
	private Long messageIdMax;
	// 消息标题
	private String messageTitle;
	// 消息摘要
	private String messageSummary;
	// 消息内容
	private String messageContent;
	// 消息类型
	private String messageMessageType;
	//t_user_message表的字段对应的属性
	// 是否已读
	private Byte userMessageIsRead;
	// 是否已读（最小值）
	private Byte userMessageIsReadMin;
	// 是否已读（最大值）
	private Byte userMessageIsReadMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userMessageCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userMessageCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userMessageCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userMessageUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userMessageUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userMessageUpdateTimeMax;
	
    public UserMessageQuery () {}

    public UserMessageQuery (Long userId, Long userIdMin, Long userIdMax, String userPhone, String userEmail, Long messageId, Long messageIdMin, Long messageIdMax, String messageTitle, String messageSummary, String messageContent, String messageMessageType, Byte userMessageIsRead, Byte userMessageIsReadMin, Byte userMessageIsReadMax, Date userMessageCreateTime, Date userMessageCreateTimeMin, Date userMessageCreateTimeMax, Date userMessageUpdateTime, Date userMessageUpdateTimeMin, Date userMessageUpdateTimeMax) {
        this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.messageId = messageId;
		this.messageIdMin = messageIdMin;
		this.messageIdMax = messageIdMax;
		this.messageTitle = messageTitle;
		this.messageSummary = messageSummary;
		this.messageContent = messageContent;
		this.messageMessageType = messageMessageType;
		this.userMessageIsRead = userMessageIsRead;
		this.userMessageIsReadMin = userMessageIsReadMin;
		this.userMessageIsReadMax = userMessageIsReadMax;
		this.userMessageCreateTime = userMessageCreateTime;
		this.userMessageCreateTimeMin = userMessageCreateTimeMin;
		this.userMessageCreateTimeMax = userMessageCreateTimeMax;
		this.userMessageUpdateTime = userMessageUpdateTime;
		this.userMessageUpdateTimeMin = userMessageUpdateTimeMin;
		this.userMessageUpdateTimeMax = userMessageUpdateTimeMax;
		
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

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public Long getMessageIdMin() {
		return messageIdMin;
	}

	public void setMessageIdMin(Long messageIdMin) {
		this.messageIdMin = messageIdMin;
	}

	public Long getMessageIdMax() {
		return messageIdMax;
	}

	public void setMessageIdMax(Long messageIdMax) {
		this.messageIdMax = messageIdMax;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageSummary() {
		return messageSummary;
	}

	public void setMessageSummary(String messageSummary) {
		this.messageSummary = messageSummary;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageMessageType() {
		return messageMessageType;
	}

	public void setMessageMessageType(String messageMessageType) {
		this.messageMessageType = messageMessageType;
	}

	public Byte getUserMessageIsRead() {
		return userMessageIsRead;
	}

	public void setUserMessageIsRead(Byte userMessageIsRead) {
		this.userMessageIsRead = userMessageIsRead;
	}

	public Byte getUserMessageIsReadMin() {
		return userMessageIsReadMin;
	}

	public void setUserMessageIsReadMin(Byte userMessageIsReadMin) {
		this.userMessageIsReadMin = userMessageIsReadMin;
	}

	public Byte getUserMessageIsReadMax() {
		return userMessageIsReadMax;
	}

	public void setUserMessageIsReadMax(Byte userMessageIsReadMax) {
		this.userMessageIsReadMax = userMessageIsReadMax;
	}

	public Date getUserMessageCreateTime() {
		return userMessageCreateTime;
	}

	public void setUserMessageCreateTime(Date userMessageCreateTime) {
		this.userMessageCreateTime = userMessageCreateTime;
	}

	public Date getUserMessageCreateTimeMin() {
		return userMessageCreateTimeMin;
	}

	public void setUserMessageCreateTimeMin(Date userMessageCreateTimeMin) {
		this.userMessageCreateTimeMin = userMessageCreateTimeMin;
	}

	public Date getUserMessageCreateTimeMax() {
		return userMessageCreateTimeMax;
	}

	public void setUserMessageCreateTimeMax(Date userMessageCreateTimeMax) {
		this.userMessageCreateTimeMax = userMessageCreateTimeMax;
	}

	public Date getUserMessageUpdateTime() {
		return userMessageUpdateTime;
	}

	public void setUserMessageUpdateTime(Date userMessageUpdateTime) {
		this.userMessageUpdateTime = userMessageUpdateTime;
	}

	public Date getUserMessageUpdateTimeMin() {
		return userMessageUpdateTimeMin;
	}

	public void setUserMessageUpdateTimeMin(Date userMessageUpdateTimeMin) {
		this.userMessageUpdateTimeMin = userMessageUpdateTimeMin;
	}

	public Date getUserMessageUpdateTimeMax() {
		return userMessageUpdateTimeMax;
	}

	public void setUserMessageUpdateTimeMax(Date userMessageUpdateTimeMax) {
		this.userMessageUpdateTimeMax = userMessageUpdateTimeMax;
	}

	
    @Override
    public String toString() {
        return "UserMessageQuery {" +
                "userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", messageId = " + messageId + 
				", messageIdMin = " + messageIdMin + 
				", messageIdMax = " + messageIdMax + 
				", messageTitle = " + messageTitle + 
				", messageSummary = " + messageSummary + 
				", messageContent = " + messageContent + 
				", messageMessageType = " + messageMessageType + 
				", userMessageIsRead = " + userMessageIsRead + 
				", userMessageIsReadMin = " + userMessageIsReadMin + 
				", userMessageIsReadMax = " + userMessageIsReadMax + 
				", userMessageCreateTime = " + userMessageCreateTime + 
				", userMessageCreateTimeMin = " + userMessageCreateTimeMin + 
				", userMessageCreateTimeMax = " + userMessageCreateTimeMax + 
				", userMessageUpdateTime = " + userMessageUpdateTime + 
				", userMessageUpdateTimeMin = " + userMessageUpdateTimeMin + 
				", userMessageUpdateTimeMax = " + userMessageUpdateTimeMax + 
				" }";
    }

}
