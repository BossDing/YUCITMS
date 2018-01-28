package com.yucitms.service.impl.attendance;

import java.util.ArrayList;

import com.yucitms.orm.attendance.AttendanceList;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.attendance.AttendanceListService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;
/**
 * 考勤列表
 * @author woxiaxiangyang
 *
 */
public class AttendanceListServiceImpl extends BaseServiceImpl implements AttendanceListService{

	@Override
	public void saveAttendanceLists(ArrayList<AttendanceList> attendanceLists) {
		getAttendanceListDao().saveAll(attendanceLists);
		
	}

	@Override
	public ArrayList<AttendanceList> getAttendanceByStudentID(Integer id) {
		return getAttendanceListDao().getAttendanceByStudentID(id);
	}

	@Override
	public PageBean getAttendance(int i, int j, HqlHelper hqlHelper) {
		return getAttendanceListDao().getPageBean(i, j, hqlHelper);
	}

	@Override
	public AttendanceList findAttendanceListByAmidStudent(Integer id,
			Integer id2) {
		return  getAttendanceListDao().findAttendanceListByAmidStudent(id,id2);
	}

	/**
	 * 更新
	 */
	@Override
	public void update(AttendanceList attendancelist) {
		getAttendanceListDao().update(attendancelist);
	}
	/**
	 * 删除LIst
	 */
	@Override
	public void deleteAttendanceListsByAmid(Integer integerAttendanceMainID) {
		getAttendanceListDao().deleteByOtherID("attendanceMain.id", integerAttendanceMainID);
		
	}

}
