package com.yucitms.action.attendance;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yucitms.config.Config;
import com.yucitms.orm.attendance.AttendanceList;
import com.yucitms.orm.attendance.AttendanceMain;
import com.yucitms.orm.attendance.ComputerRoom;
import com.yucitms.orm.school.ClassRoom;
import com.yucitms.orm.school.Department;
import com.yucitms.orm.school.Major;
import com.yucitms.orm.school.Student;
import com.yucitms.service.attendance.AttendanceListService;
import com.yucitms.service.attendance.AttendanceMainService;
import com.yucitms.service.attendance.ComputerRoomService;
import com.yucitms.service.school.ClassRoomService;
import com.yucitms.service.school.MajorService;
import com.yucitms.service.school.StudentService;
import com.yucitms.util.DateUtil;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

public class AttendanceAction extends ActionSupport{
	private MajorService majorService;
	private ClassRoomService classRoomService;
	private ComputerRoomService computerRoomService;
	private StudentService studentService;
	private AttendanceMainService attendanceMainService;
	private AttendanceListService attendanceListService;
	
	private AttendanceMain attendanceMain;
	private Department department;
	private Major major;
	private ClassRoom classRoom;
	private ComputerRoom computerRoom;
	private Student student;
	private ArrayList<AttendanceMain> attendanceMainLIst;
	private DateUtil dateUtil;//时间工具类
	
	private String majorID="";//专业id
	private String startDate="";//起始日期
	private String endDate="";//结束日期
	private String signInState="";//签到状态
	private String messages="";
	private int pageNum;//第几页
	private String attendanceMainID;
	
	
	/**
	 * 新增考勤主表
	 */
	public String addAttendance(){
		classRoom = classRoomService.findClassRoomByID(classRoom.getClassRoomID());
		attendanceMain.setClassRoom(classRoom);
		computerRoom = computerRoomService.findComputerRoomByID(computerRoom.getComputerRoomID());
		attendanceMain.setComputerRoom(computerRoom);
		attendanceMainService.saveattendanceMain(attendanceMain);
//		attendanceMain.setDay(dateUtil.getYMD(date)attendanceMain.getDay());
		addAttendanceList(attendanceMain);
	
		messages = "添加成功";
//		queryAttendance();
		return "addAttendance";
		
	}

	
	/**
	 * 新增考勤列表
	 * @param classID
	 */
	public void addAttendanceList(AttendanceMain attendanceMain){
		ArrayList<Student> studentList = studentService.findStudentByClassID(attendanceMain.getClassRoom().getClassRoomID());
		ArrayList<AttendanceList> attendanceLists = new ArrayList<AttendanceList>();
		
		for(Student student:studentList){
			AttendanceList attendanceList = new AttendanceList();
			attendanceList.setStudent(student);
			attendanceList.setAttendanceMain(attendanceMain);
			attendanceLists.add(attendanceList);
		}
		
		attendanceListService.saveAttendanceLists(attendanceLists);
	}
	
	/**
	 * 查询考勤主表
	 * 三个关键字 起始时间 机房 班级/专业/学院
	 */
	public String queryAttendance(){
		HqlHelper hqlHelper = new HqlHelper(AttendanceMain.class, "am");
		String sql = queryAttendanceSql();
		hqlHelper.addSqlCondition(sql);
		PageBean pageBean=attendanceMainService.queryAttendance(pageNum,Config.EXCELLENTCOURSE_PageSize,hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "queryAttendance";
	}
	
	/**
	 * 考勤详细查询
	 * @return
	 */
	public String queryAttendanceList(){
		
		HqlHelper hqlHelper = new HqlHelper(AttendanceList.class, "al");
		String sql = queryAttendanceListSql();
		hqlHelper.addSqlCondition(sql);
		PageBean pageBean=attendanceMainService.queryAttendance(pageNum,Config.EXCELLENTCOURSE_PageSize,hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		
		return "queryAttendanceList";
	}
		/**
		 * 查看考勤详细列表
		 * @return
		 */
		public String viewAttendanceList(){
			
			HqlHelper hqlHelper = new HqlHelper(AttendanceList.class, "al");
			String sql = " WHERE attendanceMain.id='"+attendanceMainID+"'";
			hqlHelper.addSqlCondition(sql);
			PageBean pageBean=attendanceMainService.queryAttendance(pageNum,30,hqlHelper);
			ActionContext.getContext().getValueStack().push(pageBean);
			
			
			return "viewAttendanceList";
	}
		
		/**
		 * 删除考勤
		 */
		public String deleteAttendanceMain(){
			Integer integerAttendanceMainID=Integer.valueOf(attendanceMainID);
			attendanceListService.deleteAttendanceListsByAmid(integerAttendanceMainID);
			attendanceMainService.deleteByID(integerAttendanceMainID);
			
			
			return "deleteAttendanceMain";
		}
		
		
		
		
		
		
		
		
		
		
		
		
	/**
	 * 拼写查询考勤sql
	 * @return
	 */
	public String queryAttendanceSql(){
		String sql = "WHERE ";
		if(startDate == null || "".equals(startDate)){
			sql = sql + " DAY BETWEEN '2000-01-01' AND ";
		}else{
			sql = sql + " DAY BETWEEN '"+startDate+"' AND ";
		}
		if(endDate == null || "".equals(endDate)){
			sql = sql + "'2099-01-01' ";
		}else{
			sql = sql + endDate;
		}
		
		if(((classRoom==null?null:classRoom.getClassRoomID()) != null) && !"".equals(classRoom.getClassRoomID())&&(!classRoom.getClassRoomID().equals(0))){
			sql = sql + " and classRoom.classRoomID='"+classRoom.getClassRoomID()+"'";
		}else if((major==null?null:major.getMajorID()) != null && !"".equals(major.getMajorID())&&(!major.getMajorID().equals(0))){
			sql = sql + " and classRoom.major.majorID='"+major.getMajorID()+"'";
		}else if((department==null?null:department.getDepartmentID()) != null && !"".equals(department.getDepartmentID())){
			sql = sql + " and classRoom.major.department.departmentID='"+department.getDepartmentID()+"'";
		}
		
		if((computerRoom==null?null:computerRoom.getComputerRoomID()) != null && !"".equals(computerRoom.getComputerRoomID())&&(!computerRoom.getComputerRoomID().equals(0))){
			sql = sql + " and computerRoom.computerRoomID = '"+computerRoom.getComputerRoomID()+"'";
		}
		return sql;
	}
	
	/**
	 * 拼写查询考勤详细sql
	 * @return
	 */
	public String queryAttendanceListSql(){
		String sql = "WHERE ";
		if(startDate == null || "".equals(startDate)){
			sql = sql + " attendanceMain.day BETWEEN '2000-01-01' AND ";
		}else{
			sql = sql + " attendanceMain.day BETWEEN '"+startDate+"' AND ";
		}
		if(endDate == null || "".equals(endDate)){
			sql = sql + "'2099-01-01' ";
		}else{
			sql = sql + endDate;
		}
		
		if(((student==null?null:student.getId()) != null) && !"".equals(student.getId())&&(!student.getId().equals(0))){
			sql = sql + " and student.id='"+student.getId()+"'";
		}else if(((classRoom==null?null:classRoom.getClassRoomID()) != null) && !"".equals(classRoom.getClassRoomID())&&(!classRoom.getClassRoomID().equals(0))){
			sql = sql + " and student.classRoom.classRoomID='"+classRoom.getClassRoomID()+"'";
		}else if((major==null?null:major.getMajorID()) != null && !"".equals(major.getMajorID())&&(!major.getMajorID().equals(0))){
			sql = sql + " and student.classRoom.major.majorID='"+major.getMajorID()+"'";
		}else if((department==null?null:department.getDepartmentID()) != null && !"".equals(department.getDepartmentID())){
			sql = sql + " and student.classRoom.major.department.departmentID='"+department.getDepartmentID()+"'";
		}
		
		if((signInState==null?null:signInState) != null && !"".equals(signInState)&&(!signInState.equals("0"))){
			sql = sql + " and signInTrue = '"+signInState+"'";
		}
		if((computerRoom==null?null:computerRoom.getComputerRoomID()) != null && !"".equals(computerRoom.getComputerRoomID())&&(!computerRoom.getComputerRoomID().equals(0))){
			sql = sql + " and attendanceMain.computerRoom.computerRoomID = '"+computerRoom.getComputerRoomID()+"'";
		}
		return sql;
	}
	

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
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


	public String getMajorID() {
		return majorID;
	}


	public void setMajorID(String majorID) {
		this.majorID = majorID;
	}

	public ClassRoom getClassRoom() {
		return classRoom;
	}


	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public ClassRoomService getClassRoomService() {
		return classRoomService;
	}

	public void setClassRoomService(ClassRoomService classRoomService) {
		this.classRoomService = classRoomService;
	}

	public ComputerRoomService getComputerRoomService() {
		return computerRoomService;
	}

	public void setComputerRoomService(ComputerRoomService computerRoomService) {
		this.computerRoomService = computerRoomService;
	}

	public ComputerRoom getComputerRoom() {
		return computerRoom;
	}

	public void setComputerRoom(ComputerRoom computerRoom) {
		this.computerRoom = computerRoom;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public AttendanceListService getAttendanceListService() {
		return attendanceListService;
	}
	public void setAttendanceListService(AttendanceListService attendanceListService) {
		this.attendanceListService = attendanceListService;
	}

	public AttendanceMainService getAttendanceMainService() {
		return attendanceMainService;
	}

	public String getAttendanceMainID() {
		return attendanceMainID;
	}

	public void setAttendanceMainID(String attendanceMainID) {
		this.attendanceMainID = attendanceMainID;
	}


	public DateUtil getDateUtil() {
		return dateUtil;
	}


	public void setDateUtil(DateUtil dateUtil) {
		this.dateUtil = dateUtil;
	}


	public void setAttendanceMainService(AttendanceMainService attendanceMainService) {
		this.attendanceMainService = attendanceMainService;
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

	public ArrayList<AttendanceMain> getAttendanceMainLIst() {
		return attendanceMainLIst;
	}

	public String getSignInState() {
		return signInState;
	}


	public void setSignInState(String signInState) {
		this.signInState = signInState;
	}


	public void setAttendanceMainLIst(ArrayList<AttendanceMain> attendanceMainLIst) {
		this.attendanceMainLIst = attendanceMainLIst;
	}


	public String getMessages() {
		return messages;
	}


	public void setMessages(String messages) {
		this.messages = messages;
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	
	
}
