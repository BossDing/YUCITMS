package com.yucitms.dao.attendance;

import java.util.ArrayList;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.attendance.AttendanceList;
/**
 * 考勤列表
 * @author woxiaxiangyang
 *
 */
public interface AttendanceListDao extends BaseDao<AttendanceList>{

	ArrayList<AttendanceList> getAttendanceByStudentID(Integer id);

	AttendanceList findAttendanceListByAmidStudent(Integer id, Integer id2);

//	void saveAttendanceLists(ArrayList<AttendanceList> attendanceLists);

}
