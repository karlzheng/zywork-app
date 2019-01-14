package top.zywork.dos;

/**
 * 用户提现DO类，包含提现用户编号及提现金额<br/>
 *
 * 创建于2018-12-23<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public class UserWithdrawDO {

    private Long id;
    private Long userId;
    private Long amount;
    private Byte withdrawStatus;
    private Integer version;

    public UserWithdrawDO() {}

    public UserWithdrawDO(Long id, Long userId, Long amount, Byte withdrawStatus, Integer version) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.withdrawStatus = withdrawStatus;
        this.version = version;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Byte getWithdrawStatus() {
        return withdrawStatus;
    }

    public void setWithdrawStatus(Byte withdrawStatus) {
        this.withdrawStatus = withdrawStatus;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
