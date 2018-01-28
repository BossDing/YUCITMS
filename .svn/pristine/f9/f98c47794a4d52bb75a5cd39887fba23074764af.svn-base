package com.yucitms.service.attendance;

import java.util.ArrayList;

import com.yucitms.orm.attendance.AttendanceList;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;
/**
 * 考勤列表
 * @author woxiaxiangyang
 *
 */
public interface AttendanceListService extends BaseService{

	void saveAttendanceLists(ArrayList<AttendanceList> attendanceLists);

	ArrayList<AttendanceList> getAttendanceByStudentID(Integer id);

	PageBean getAttendance(int i, int j, HqlHelper hqlHelper);

	AttendanceList findAttendanceListByAmidStudent(Integer id, Integer id2);

	void update(AttendanceList attendancelist);

	void deleteAttendanceListsByAmid(Integer integerAttendanceMainID);

}
