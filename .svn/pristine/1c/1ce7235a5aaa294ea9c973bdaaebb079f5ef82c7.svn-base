package com.yucitms.dao.impl.school;

import java.util.ArrayList;

import com.yucitms.dao.BaseDaoImpl;
import com.yucitms.dao.school.StudentDao;
import com.yucitms.orm.school.Major;
import com.yucitms.orm.school.Student;
/**
 * 学生
 * @author woxiaxiangyang
 *
 */
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao{

	@Override
	public Student login(String username, String password) {
		String HQL="From Student where loginName=? AND loginPas=?";
		Student student=(Student) getSession().createQuery(HQL).setString(0, username).setString(1, password).uniqueResult();
		return student;
	}

	@Override
	public ArrayList<Student> findStudentByClassID(Integer classID) {
		String HQL=" From Student where classRoom.classRoomID =?";
		ArrayList<Student> studentList = (ArrayList<Student>) getSession().createQuery(HQL).setInteger(0, classID).list();
		return studentList;
	}

}
