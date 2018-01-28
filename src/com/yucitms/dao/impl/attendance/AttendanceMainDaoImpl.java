package com.yucitms.dao.impl.attendance;

import java.util.ArrayList;
import java.util.Date;

import com.yucitms.dao.BaseDaoImpl;
import com.yucitms.dao.attendance.AttendanceMainDao;
import com.yucitms.orm.attendance.AttendanceMain;
import com.yucitms.orm.school.Student;
/**
 * 考勤主表
 * @author woxiaxiangyang
 *
 */
public class AttendanceMainDaoImpl extends BaseDaoImpl<AttendanceMain> implements AttendanceMainDao{

	@Override
	public ArrayList<AttendanceMain> findAttendanceMainsByClassDate(
			Integer classId, Date date) {

		String HQL=" From AttendanceMain where classRoom.classRoomID =? and day=?";
		ArrayList<AttendanceMain> attendanceMainList = (ArrayList<AttendanceMain>) getSession().createQuery(HQL).setInteger(0, classId).setDate(1, date).list();
		
		return attendanceMainList;
	}


}
