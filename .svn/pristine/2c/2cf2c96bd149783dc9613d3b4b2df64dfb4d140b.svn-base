package com.yucitms.dao.impl.attendance;

import java.util.ArrayList;

import com.yucitms.dao.BaseDaoImpl;
import com.yucitms.dao.attendance.AttendanceListDao;
import com.yucitms.orm.attendance.AttendanceList;
import com.yucitms.orm.school.Student;
/**
 * 考勤列表
 * @author woxiaxiangyang
 *
 */
public class AttendanceListDaoImpl extends BaseDaoImpl<AttendanceList> implements AttendanceListDao{

	@Override
	public ArrayList<AttendanceList> getAttendanceByStudentID(Integer id) {
		String HQL=" From AttendanceList where student.id =?";
		ArrayList<AttendanceList> attendanceLists = (ArrayList<AttendanceList>) getSession().createQuery(HQL).setInteger(0, id).list();
		return attendanceLists;
	}

	@Override
	public AttendanceList findAttendanceListByAmidStudent(Integer id,
			Integer id2) {
		String HQL=" From AttendanceList where  attendanceMain.id=? and student.id =?";
		AttendanceList attendanceList = (AttendanceList) getSession().createQuery(HQL).setInteger(0, id).setInteger(1, id2).uniqueResult();
		
		return attendanceList;
	}

//	/**
//	 * 保存attendanceLists
//	 */
//	@Override
//	public void saveAttendanceLists(ArrayList<AttendanceList> attendanceLists) {
//		getSession().save(attendanceLists);
//		
//	}

}
