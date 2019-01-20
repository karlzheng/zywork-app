package top.zywork.vo;

/**
 * RoleExportVO值对象类<br/>
 *
 * 创建于2019-01-20<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class RoleExportVO extends BaseVO {

    private static final long serialVersionUID = -9223372036357875481L;

	private String title;
	private String description;
	private Byte isDefault;

    public RoleExportVO() {}

    public RoleExportVO(String title, String description, Byte isDefault) {
		this.title = title;
		this.description = description;
		this.isDefault = isDefault;

    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Byte isDefault) {
		this.isDefault = isDefault;
	}

}
