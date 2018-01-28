package com.yucitms.orm.netLesson;

import java.util.Date;

public class ImgCarousel implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String  imgExplain;
	private String imgPath;
	private String remark;
	private Date createDate;
	private ExcellentCourse course;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImgExplain() {
		return imgExplain;
	}
	public void setImgExplain(String imgExplain) {
		this.imgExplain = imgExplain;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	
}
