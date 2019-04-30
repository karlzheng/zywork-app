package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserUserMessageDO数据对象实体类<br/>
 *
 * 创建于2019-01-24<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserUserMessageDO extends BaseDO {

    private static final long serialVersionUID = -9223372036149689989L;

    //t_user表的字段对应的属性
	// 用户编号
	private Long userId;
	// 手机号
	private String userPhone;
	// 用户邮箱
	private String userEmail;
	//t_message表的字段对应的属性
	// 消息编号
	private Long messageId;
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
	// 创建时间
	private Date userMessageCreateTime;
	// 更新时间
	private Date userMessageUpdateTime;
	
    public UserUserMessageDO() {}

    public UserUserMessageDO(Long userId, String userPhone, String userEmail, Long messageId, String messageTitle, String messageSummary, String messageContent, String messageMessageType, Byte userMessageIsRead, Date userMessageCreateTime, Date userMessageUpdateTime) {
        this.userId = userId;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.messageId = messageId;
		this.messageTitle = messageTitle;
		this.messageSummary = messageSummary;
		this.messageContent = messageContent;
		this.messageMessageType = messageMessageType;
		this.userMessageIsRead = userMessageIsRead;
		this.userMessageCreateTime = userMessageCreateTime;
		this.userMessageUpdateTime = userMessageUpdateTime;
		
    }

    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Date getUserMessageCreateTime() {
		return userMessageCreateTime;
	}

	public void setUserMessageCreateTime(Date userMessageCreateTime) {
		this.userMessageCreateTime = userMessageCreateTime;
	}

	public Date getUserMessageUpdateTime() {
		return userMessageUpdateTime;
	}

	public void setUserMessageUpdateTime(Date userMessageUpdateTime) {
		this.userMessageUpdateTime = userMessageUpdateTime;
	}

	
    @Override
    public String toString() {
        return "UserUserMessageDO {" +
                "userId = " + userId + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", messageId = " + messageId + 
				", messageTitle = " + messageTitle + 
				", messageSummary = " + messageSummary + 
				", messageContent = " + messageContent + 
				", messageMessageType = " + messageMessageType + 
				", userMessageIsRead = " + userMessageIsRead + 
				", userMessageCreateTime = " + userMessageCreateTime + 
				", userMessageUpdateTime = " + userMessageUpdateTime + 
				" }";
    }

}
