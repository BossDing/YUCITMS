package com.yucitms.orm.attendance;
/**
 * 考勤主表
 */

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.yucitms.orm.school.ClassRoom;


public class AttendanceMain implements java.io.Serializable{
	private Integer id;
	private java.sql.Date day;//日期
	private Date startTime;//签到开始时间
	private Date endTime;//签到结束时间
	private ClassRoom classRoom;//班级
	private String remark;//备注

	
	private ComputerRoom computerRoom;//机房
	
	private Set<AttendanceList> attendanceLists = new HashSet<AttendanceList>();//考勤列表
	
	public  AttendanceMain(){
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public java.sql.Date getDay() {
		return day;
	}
	public void setDay(java.sql.Date day) {
		this.day = day;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public ClassRoom getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}

	public ComputerRoom getComputerRoom() {
		return computerRoom;
	}
	public void setComputerRoom(ComputerRoom computerRoom) {
		this.computerRoom = computerRoom;
	}
	public Set<AttendanceList> getAttendanceLists() {
		return attendanceLists;
	}
	public void setAttendanceLists(Set<AttendanceList> attendanceLists) {
		this.attendanceLists = attendanceLists;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	

	
	
}
