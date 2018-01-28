package com.yucitms.action.attendance;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yucitms.orm.attendance.ComputerRoom;
import com.yucitms.orm.school.ClassRoom;
import com.yucitms.orm.school.Department;
import com.yucitms.orm.school.Major;
import com.yucitms.orm.school.Student;
import com.yucitms.service.attendance.ComputerRoomService;
import com.yucitms.service.school.ClassRoomService;
import com.yucitms.service.school.DepartmentService;
import com.yucitms.service.school.MajorService;
import com.yucitms.service.school.StudentService;

public class LinkageToObtainAction extends ActionSupport {
	private HttpServletResponse response = ServletActionContext.getResponse();
	DepartmentService departmentService;
	MajorService majorService;
	ClassRoomService classRoomService;
	ComputerRoomService computerRoomService;
	StudentService studentService;
	private Integer departmentID;
	private Integer majorID;
	private Integer classID;

	/**
	 * 获取学院
	 */
	public String getDepartment() {
		ArrayList<Department> departmentList = departmentService
				.findDepartmentIdName();
		JSONArray jsonArray = JSONArray.fromObject(departmentList);
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取专业
	 */
	public String getMajor() {
		ArrayList<Major> majorList = majorService
				.findMajorIdNmaeByDepartmentID(departmentID);
		// JSONArray jsonArray = JSONArray.fromObject(majorList);

		String json = "";
		for (int i = 0; i < majorList.size(); i++) {
			Major major = majorList.get(i);
			String str = "{\"majorID\":" + major.getMajorID()
					+ ",\"majorName\":\"" + major.getMajorName() + "\"},";
			json += str;
		}
		String jsonstr = json.substring(0, json.length() - 1);
		jsonstr = "[" + jsonstr + "]";

		try {
			response.setContentType("text/html;charset=UTF-8");
			// response.getWriter().print(jsonArray.toString());
			response.getWriter().print(jsonstr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取班级
	 */
	public String getClassRoom() {
		ArrayList<ClassRoom> classRoomList = classRoomService
				.getClassRoomBymajorID(majorID);
		// JSONArray jsonArray = JSONArray.fromObject(ClassRoomList);
		String json = "";
		for (int i = 0; i < classRoomList.size(); i++) {
			ClassRoom classRoom = classRoomList.get(i);
			String str = "{\"classID\":" + classRoom.getClassRoomID()
					+ ",\"classRoomName\":\"" + classRoom.getClassRoomName()
					+ "\"},";
			json += str;
		}
		String jsonstr = json.substring(0, json.length() - 1);
		jsonstr = "[" + jsonstr + "]";
		try {
			response.setContentType("text/html;charset=UTF-8");
			// response.getWriter().print(jsonArray.toString());
			response.getWriter().print(jsonstr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取学生
	 */
	public String getStudent() {
		ArrayList<Student> studentList = studentService.findStudentByClassID(classID);
		String json = "";
		for (int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			String str = "{\"id\":" + student.getId()
					+ ",\"studentName\":\"" + student.getStudentName()
					+ "\"},";
			json += str;
		}
		String jsonstr = json.substring(0, json.length() - 1);
		jsonstr = "[" + jsonstr + "]";
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(jsonstr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取机房
	 */
	public String getComputerRoom() {
		ArrayList<ComputerRoom> computerRoomList = computerRoomService
				.findComputerRoomAll();
		// JSONArray jsonArray = JSONArray.fromObject(ClassRoomList);
		String json = "";
		for (int i = 0; i < computerRoomList.size(); i++) {
			ComputerRoom computerRoom = computerRoomList.get(i);
			String str = "{\"computerRoomID\":" + computerRoom.getComputerRoomID() + ",\"roomNo\":\""
					+ computerRoom.getRoomNo() + "\"},";
			json += str;
		}
		String jsonstr = json.substring(0, json.length() - 1);
		jsonstr = "[" + jsonstr + "]";
		try {
			response.setContentType("text/html;charset=UTF-8");
			// response.getWriter().print(jsonArray.toString());
			response.getWriter().print(jsonstr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public ClassRoomService getClassRoomService() {
		return classRoomService;
	}

	public void setClassRoomService(ClassRoomService classRoomService) {
		this.classRoomService = classRoomService;
	}

	public Integer getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}

	public Integer getMajorID() {
		return majorID;
	}

	public void setMajorID(Integer majorID) {
		this.majorID = majorID;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public ComputerRoomService getComputerRoomService() {
		return computerRoomService;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Integer getClassID() {
		return classID;
	}

	public void setClassID(Integer classID) {
		this.classID = classID;
	}

	public void setComputerRoomService(ComputerRoomService computerRoomService) {
		this.computerRoomService = computerRoomService;
	}

}
