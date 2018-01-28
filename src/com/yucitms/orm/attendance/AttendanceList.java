package com.yucitms.orm.attendance;
/**
 * 考勤列表
 */
import java.util.Date;

import com.yucitms.orm.school.Student;

public class AttendanceList implements java.io.Serializable{
	private Integer id;
	private String signInTrue;//签到与否
	private Date signInTime;//签到时间
	
	private Student student;//学生
	private AttendanceMain attendanceMain;//考勤主表
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getSignInTrue() {
		return signInTrue;
	}

	public void setSignInTrue(String signInTrue) {
		this.signInTrue = signInTrue;
	}

	public Date getSignInTime() {
		return signInTime;
	}

	public void setSignInTime(Date signInTime) {
		this.signInTime = signInTime;
	}

	public AttendanceMain getAttendanceMain() {
		return attendanceMain;
	}

	public void setAttendanceMain(AttendanceMain attendanceMain) {
		this.attendanceMain = attendanceMain;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
}
