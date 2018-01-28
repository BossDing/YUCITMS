package com.yucitms.orm.school;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 院系
 * @author qiangzi
 *
 */
public class Department implements java.io.Serializable{
	private Integer departmentID;
	private String departmentName;//院系名称
	private String departmentContent;
	private Date createDate;
	private Set<Major> majors = new HashSet<Major>();//专业
	
	public Integer getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentContent() {
		return departmentContent;
	}
	public void setDepartmentContent(String departmentContent) {
		this.departmentContent = departmentContent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Set<Major> getMajors() {
		return majors;
	}
	public void setMajors(Set<Major> majors) {
		this.majors = majors;
	}
	public Department(){
		
	}
	public Department(Integer departmentID, String departmentName) {
		this.departmentID = departmentID;
		this.departmentName = departmentName;
	}
	public Department(String departmentName, String departmentContent) {
		super();
		this.departmentName = departmentName;
		this.departmentContent = departmentContent;
	}
	
	}
