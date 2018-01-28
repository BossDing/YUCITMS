package com.yucitms.orm.school;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Student implements java.io.Serializable{
	private Integer id;
	private String studentName;//姓名
	private String studentCode;//学号
	private String sex;//
	private  int age;//
	private String loginName;//登录名
	private String loginPas;//密码
	private Date createDate;//入学时间
	private ClassRoom classRoom;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPas() {
		return loginPas;
	}
	public void setLoginPas(String loginPas) {
		this.loginPas = loginPas;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public ClassRoom getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}
	
}
