package com.yucitms.orm.netLesson;

import java.util.Date;

/**
 * 视频
 * @author qiangzi
 *
 */
public class ExcellentVideo implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String videoName;
	private double videoSize;
	private String videoPath;
	private String videoImgPath;
	private Date createDate;
	private ExcellentCourse course;//所属课程
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public double getVideoSize() {
		return videoSize;
	}
	public void setVideoSize(double videoSize) {
		this.videoSize = videoSize;
	}
	public String getVideoPath() {
		return videoPath;
	}
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	public ExcellentCourse getCourse() {
		return course;
	}
	public void setCourse(ExcellentCourse course) {
		this.course = course;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getVideoImgPath() {
		return videoImgPath;
	}
	public void setVideoImgPath(String videoImgPath) {
		this.videoImgPath = videoImgPath;
	}
	
}
