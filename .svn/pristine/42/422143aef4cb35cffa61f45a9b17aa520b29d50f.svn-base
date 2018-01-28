package com.yucitms.orm.school;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 专业
 * @author qiangzi
 *
 */
public class Major implements java.io.Serializable{
	private Integer majorID;
	private String majorName;//专业
	private Department department;//学院
	private Integer departmentID;//学院ID
	private String majorContent;
	private Date createDate;
	private Set<ClassRoom> rooms = new HashSet<ClassRoom>();//班级
	
	public Major(){};
	//构造方法
	public Major(Integer majorID, String majorName) {
		this.majorID = majorID;
		this.majorName = majorName;
	}
	
	public Integer getMajorID() {
		return majorID;
	}
	public void setMajorID(Integer majorID) {
		this.majorID = majorID;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getMajorContent() {
		return majorContent;
	}
	public void setMajorContent(String majorContent) {
		this.majorContent = majorContent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Set<ClassRoom> getRooms() {
		return rooms;
	}
	public void setRooms(Set<ClassRoom> rooms) {
		this.rooms = rooms;
	}
	public Integer getDepartmentID() {
		return department.getDepartmentID();
	}
	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}
	
}
