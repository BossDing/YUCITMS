package com.yucitms.service.impl.attendance;

import java.util.ArrayList;
import java.util.Date;

import com.yucitms.orm.attendance.AttendanceMain;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.attendance.AttendanceMainService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;
/**
 * 考勤主表
 * @author woxiaxiangyang
 *
 */
public class AttendanceMainServiceImpl extends BaseServiceImpl implements AttendanceMainService{

	@Override
	public void saveattendanceMain(AttendanceMain attendanceMain) {
		getAttendanceMainDao().save(attendanceMain);
		
	}

	/**
	 * 查询attendancemain
	 */
	@Override
	public PageBean queryAttendance(int i, int j, HqlHelper hqlHelper) {
		return getAttendanceMainDao().getPageBean(i, j, hqlHelper);
	}


	@Override
	public ArrayList<AttendanceMain> findAttendanceMainsByClassDate(
			Integer classId, Date date) {
		
		return getAttendanceMainDao().findAttendanceMainsByClassDate(classId,date);
	}


	@Override
	public void deleteByID(Integer integerAttendanceMainID) {
		getAttendanceMainDao().delete(integerAttendanceMainID);
	}

}
