package com.yucitms.action.student;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.yucitms.action.BaseAction;
import com.yucitms.orm.attendance.AttendanceList;
import com.yucitms.orm.attendance.AttendanceMain;
import com.yucitms.orm.attendance.ComputerRoom;
import com.yucitms.orm.school.Student;
import com.yucitms.util.DateUtil;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.IpUtil;
import com.yucitms.util.PageBean;

public class StudentAction extends BaseAction<Student>{
	private Student student;
	private AttendanceList attendancelist;
	private AttendanceMain attendanceMain;
	private String startDate="";//起始日期
	private String endDate="";//结束日期
	private String signInstate="";//签到状态
	private ComputerRoom computerRoom;
	
	public String left(){
		return "left";
	}
	public String top(){
		return "top";
	}
	public String main(){
		return "main";
	}
	
	public void validateLogin(){
		
		student=studentService.login(model.getLoginName(), model.getLoginPas());
		if(student==null){
			addFieldError("error", "用户名或密码错误，请重试！");
			System.out.println("------------");
		}
	}
	public String login(){
		System.out.println("成功");
		ActionContext.getContext().getSession().put("student", student);
		return "login";
	}
	public String outline(){
		ActionContext.getContext().getSession().remove("student");
		return "loginpage";
		
	}
	
	/**
	 * 我的考勤
	 * @return
	 */
	public String getMyAttendance(){
		student = (Student)ActionContext.getContext().getSession().get("student");
		HqlHelper hqlHelper = new HqlHelper(AttendanceList.class, "at");
		hqlHelper.addWhereCondition("student.id=?", student.getId());
		hqlHelper.addOrderByProperty("attendanceMain.day", false);
		PageBean pageBean=attendanceListService.getAttendance(1,20,hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		Date date=new Date();
		getAttendanceList(date);
		return "getMyAttendance";
	}
	/**
	 * 查询我的考勤
	 * @return
	 */
	public String queryMyAttendance(){
		
		HqlHelper hqlHelper = new HqlHelper(AttendanceList.class, "at");
		String sql = queryMyAttendanceSql();
		hqlHelper.addSqlCondition(sql);
		PageBean pageBean=attendanceListService.getAttendance(1,20,hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "queryMyAttendance";
	}
	
	/**
	 * 签到
	 * @return
	 */
	public String signIn(){
		Date date=new Date();
		AttendanceList attendanceList = getAttendanceList(date);
			if(attendancelist!=null){
				attendancelist.setSignInTrue("signInTrue");
				attendancelist.setSignInTime(date);
				attendanceListService.update(attendancelist);
				signInstate="signInTrue";
			}
		getMyAttendance();
		return "getMyAttendance";
	}
	/**
	 * 获取本AttendanceList
	 * @return
	 */
public AttendanceList getAttendanceList(Date date){
	//班级 日期 机房(IP) 
			student = (Student)ActionContext.getContext().getSession().get("student");
			Integer classId = student.getClassRoom().getClassRoomID();
			IpUtil ipUtil = new IpUtil();
			
			ArrayList<AttendanceMain> attendanceMains=attendanceMainService.findAttendanceMainsByClassDate(classId,date);
			AttendanceMain am =new AttendanceMain();
			if(attendanceMains!=null&&attendanceMains.size()>0){
				for(AttendanceMain attendanceMain:attendanceMains){
					if(ipUtil.ipExistsInRange(attendanceMain.getComputerRoom().getIpSection())){
						am=attendanceMain;
						break;
					}
				}
				attendancelist=attendanceListService.findAttendanceListByAmidStudent(am.getId(),student.getId());
			}
			if(attendancelist!=null&&attendancelist.getSignInTrue()!=null){
				signInstate=attendancelist.getSignInTrue();
			}
			return attendancelist;
}
	/**
	 * 拼sql查询我的考勤
	 * @return
	 */
	public String queryMyAttendanceSql(){
		student = (Student)ActionContext.getContext().getSession().get("student");
		String sql ="";
		
		if(startDate == null || "".equals(startDate)){
			sql = sql + " where attendanceMain.day BETWEEN '2000-01-01' AND '";
		}else{
			sql = sql + " where attendanceMain.day BETWEEN '"+startDate+"' AND '";
		}
		if(endDate == null || "".equals(endDate)){
			sql = sql + "2099-01-01' ";
		}else{
			sql = sql + endDate+"'";
		}
		if((signInstate==null?null:signInstate) != null && !"".equals(signInstate)&&(!signInstate.equals("0"))){
			sql = sql + " and signInTrue = '"+signInstate+"'";
		}
		if((computerRoom==null?null:computerRoom.getComputerRoomID()) != null && !"".equals(computerRoom.getComputerRoomID())&&(!computerRoom.getComputerRoomID().equals(0))){
			sql = sql + " and attendanceMain.computerRoom.computerRoomID = '"+computerRoom.getComputerRoomID()+"'";
		}
		sql = sql+" and  student.id='"+student.getId()+"' order by attendanceMain.day desc" ;
		return sql;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public AttendanceList getAttendancelist() {
		return attendancelist;
	}
	public void setAttendancelist(AttendanceList attendancelist) {
		this.attendancelist = attendancelist;
	}
	public AttendanceMain getAttendanceMain() {
		return attendanceMain;
	}
	public void setAttendanceMain(AttendanceMain attendanceMain) {
		this.attendanceMain = attendanceMain;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getSignInstate() {
		return signInstate;
	}
	public void setSignInstate(String signInstate) {
		this.signInstate = signInstate;
	}
	public ComputerRoom getComputerRoom() {
		return computerRoom;
	}
	public void setComputerRoom(ComputerRoom computerRoom) {
		this.computerRoom = computerRoom;
	}
	
}
