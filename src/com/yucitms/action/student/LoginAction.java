package com.yucitms.action.student;

import com.yucitms.action.BaseAction;
import com.yucitms.orm.school.Student;

public class LoginAction extends BaseAction<Student>{
	public String loginpage(){
		return "loginpage";
	}
	
}
