package com.yucitms.dao.attendance;

import java.util.ArrayList;
import java.util.Date;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.attendance.AttendanceMain;
/**
 * 考勤主表
 * @author woxiaxiangyang
 *
 */
public interface AttendanceMainDao extends BaseDao<AttendanceMain>{

	ArrayList<AttendanceMain> findAttendanceMainsByClassDate(Integer classId,
			Date date);

	
}
