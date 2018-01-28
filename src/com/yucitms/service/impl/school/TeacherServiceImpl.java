package com.yucitms.service.impl.school;

import com.yucitms.orm.school.Teacher;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.school.TeacherService;

public class TeacherServiceImpl extends BaseServiceImpl implements TeacherService{

	@Override
	public Teacher login(String loginName, String loginPas) {
		return getTeacherDao().login(loginName, loginPas);
	}
	
}
