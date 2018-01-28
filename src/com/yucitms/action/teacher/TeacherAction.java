package com.yucitms.action.teacher;

import java.io.File;

import com.opensymphony.xwork2.ActionContext;
import com.yucitms.action.BaseAction;
import com.yucitms.orm.school.Teacher;

public class TeacherAction extends BaseAction<Teacher>{
	private Teacher teacher;
	
	
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
		
		teacher=teacherService.login(model.getLoginName(), model.getLoginPas());
		if(teacher==null){
			addFieldError("error", "用户名或密码错误，请重试！");
			System.out.println("------------");
		}
	}
	public String login(){
		System.out.println("成功");
		ActionContext.getContext().getSession().put("teacher", teacher);
		return "login";
	}
	public String outline(){
		ActionContext.getContext().getSession().remove("teacher");
		return "loginpage";
		
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "login";
	}
}
