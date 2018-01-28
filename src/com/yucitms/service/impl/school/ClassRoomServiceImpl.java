package com.yucitms.service.impl.school;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.yucitms.orm.school.ClassRoom;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.school.ClassRoomService;

/**
 * 班级
 * @author qiangzi
 *
 */
public class ClassRoomServiceImpl extends BaseServiceImpl implements ClassRoomService{

	@Override
	public ArrayList<ClassRoom> findClassRoomIdNameByMajorID(Integer majorID) {
		return getClassRoomDAO().findClassRoomIdNameByMajorID(majorID);
	}
	public ArrayList<ClassRoom> getClassRoomBymajorID(Integer majorID) {
		return getClassRoomDAO().findClassRoomIdNameByMajorID(majorID);
	}
	
	public ClassRoom findClassRoomByID(Integer classRoomID) {
		return getClassRoomDAO().findClassRoomByID(classRoomID);
	}
	
}
