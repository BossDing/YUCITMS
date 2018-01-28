package com.yucitms.dao.school;

import java.util.ArrayList;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.school.Student;
/**
 * 课程 学生
 * @author woxiaxiangyang
 *
 */
public interface StudentDao extends BaseDao<Student> {
	public Student login(String username,String password);

	public ArrayList<Student> findStudentByClassID(Integer classID);
}
