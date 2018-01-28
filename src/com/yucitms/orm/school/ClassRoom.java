package com.yucitms.orm.school;

import java.util.HashSet;
import java.util.Set;

/**
 * 班级
 * @author qiangzi
 *
 */
public class ClassRoom implements java.io.Serializable{
	private Integer classRoomID;
	private String classRoomName;//班级名称
	private Major major;//所属专业
	private Integer majorID;//所属专业id
	private Set<Student> students = new HashSet<Student>();//学生
	private Set<Course> courses = new HashSet<Course>();
	
	public ClassRoom() {};
	
	public ClassRoom(Integer classRoomID, String classRoomName) {
		this.classRoomID = classRoomID;
		this.classRoomName = classRoomName;
	}

	public Integer getClassRoomID() {
		return classRoomID;
	}
	public void setClassRoomID(Integer classRoomID) {
		this.classRoomID = classRoomID;
	}
	public String getClassRoomName() {
		return classRoomName;
	}
	public void setClassRoomName(String classRoomName) {
		this.classRoomName = classRoomName;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public Integer getMajorID() {
		return major.getMajorID();
	}
	public void setMajorID(Integer majorID) {
		this.majorID = majorID;
	}
	
}
