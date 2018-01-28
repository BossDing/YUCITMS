package com.yucitms.service.impl.school;

import java.util.ArrayList;

import com.yucitms.orm.school.Student;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.school.StudentService;

public class StudentServiceImpl extends BaseServiceImpl implements StudentService{

	@Override
	public Student login(String username, String password) {
		return getStudentDao().login(username, password);
	}

	@Override
	public ArrayList<Student> findStudentByClassID(Integer classID) {
		return getStudentDao().findStudentByClassID(classID);
	}

}
