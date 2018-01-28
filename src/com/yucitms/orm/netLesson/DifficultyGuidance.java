package com.yucitms.orm.netLesson;

import java.util.Date;

/**
 * 重难点
 * @author qiangzi
 *
 */
public class DifficultyGuidance implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String diffName;//方案名
	private String diffScheme;//解决方案内容
	private String diffRemark;
	private Date createDate;
	private String attachmentsPath;//附件地址
	private String oldFilePath;
	private ExcellentCourse course;//对应的精品课程
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDiffName() {
		return diffName;
	}
	public void setDiffName(String diffName) {
		this.diffName = diffName;
	}
	public String getDiffScheme() {
		return diffScheme;
	}
	public void setDiffScheme(String diffScheme) {
		this.diffScheme = diffScheme;
	}
	public String getDiffRemark() {
		return diffRemark;
	}
	public void setDiffRemark(String diffRemark) {
		this.diffRemark = diffRemark;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public ExcellentCourse getCourse() {
		return course;
	}
	public void setCourse(ExcellentCourse course) {
		this.course = course;
	}
	public String getAttachmentsPath() {
		return attachmentsPath;
	}
	public void setAttachmentsPath(String attachmentsPath) {
		this.attachmentsPath = attachmentsPath;
	}
	public String getOldFilePath() {
		return oldFilePath;
	}
	public void setOldFilePath(String oldFilePath) {
		this.oldFilePath = oldFilePath;
	}
	
}
