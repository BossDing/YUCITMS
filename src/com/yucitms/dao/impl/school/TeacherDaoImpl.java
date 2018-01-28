package com.yucitms.dao.impl.school;

import com.yucitms.dao.BaseDaoImpl;
import com.yucitms.dao.school.TeacherDao;
import com.yucitms.orm.school.Teacher;
/**
 * 教师
 * @author woxiaxiangyang
 *
 */
public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDao{

	@Override
	public Teacher login(String loginName, String loginPas) {
		String HQL="From Teacher where loginName=? AND loginPas=?";
		Teacher teacher=(Teacher) getSession().createQuery(HQL).setString(0, loginName).setString(1, loginPas).uniqueResult();
		return teacher;
	}

}
