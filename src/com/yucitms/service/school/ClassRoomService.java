package com.yucitms.service.school;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.yucitms.orm.school.ClassRoom;
import com.yucitms.service.BaseService;

/**
 * 班级
 * @author qiangzi
 *
 */
public interface ClassRoomService extends BaseService{

	ArrayList<ClassRoom> findClassRoomIdNameByMajorID(Integer majorID);
	ArrayList<ClassRoom> getClassRoomBymajorID(Integer majorID);
	ClassRoom findClassRoomByID(Integer classRoomID);
	
}
