package com.yucitms.dao.impl.school;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.yucitms.dao.BaseDao;
import com.yucitms.dao.BaseDaoImpl;
import com.yucitms.dao.school.ClassRoomDAO;
import com.yucitms.orm.school.ClassRoom;
import com.yucitms.orm.school.Major;

/**
 * 班级
 * @author qiangzi
 *
 */
public class ClassRoomDAOImpl extends BaseDaoImpl<ClassRoom> implements ClassRoomDAO{

	@Override
	public ArrayList<ClassRoom> findClassRoomIdNameByMajorID(Integer majorID) {
		String HQL="select new ClassRoom(id,classRoomName) From ClassRoom where major_ID=?";
		ArrayList<ClassRoom> classRoomList = (ArrayList<ClassRoom>) getSession().createQuery(HQL).setInteger(0, majorID).list();
		return classRoomList;
	}
	
	public ArrayList<ClassRoom> getClassRoomBymajorID(Integer majorID) {
		String HQL="From ClassRoom where major_ID=?";
		ArrayList<ClassRoom> classRoomList = (ArrayList<ClassRoom>) getSession().createQuery(HQL).setInteger(0, majorID).list();
		return classRoomList;
	}
	public ClassRoom findClassRoomByID(Integer classRoomID) {
		String HQL="From ClassRoom where classRoomID=?";
		ClassRoom classRoom = (ClassRoom) getSession().createQuery(HQL).setInteger(0, classRoomID).uniqueResult();
		return classRoom;
	}
}
