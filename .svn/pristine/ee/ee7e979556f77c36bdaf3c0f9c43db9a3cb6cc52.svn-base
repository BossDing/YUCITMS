package com.yucitms.service.attendance;

import java.util.ArrayList;
import java.util.Date;

import com.yucitms.orm.attendance.AttendanceMain;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;
/**
 * 考勤主表
 * @author woxiaxiangyang
 *
 */
public interface AttendanceMainService extends BaseService{

	void saveattendanceMain(AttendanceMain attendanceMain);


	PageBean queryAttendance(int i, int j, HqlHelper hqlHelper);


	ArrayList<AttendanceMain> findAttendanceMainsByClassDate(Integer classId,
			Date date);

	/**
	 * 通过ID删除
	 * @param integerAttendanceMainID
	 */
	void deleteByID(Integer integerAttendanceMainID);

}
