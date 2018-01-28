package com.yucitms.orm.netLesson;

import java.util.Date;

/**
 * 实训案例			
 * @author qiangzi
 *
 */
public class ExperimentCase implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Date createDate;
	private String filePath;
	private ExcellentCourse course;//对应的精品课程
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
