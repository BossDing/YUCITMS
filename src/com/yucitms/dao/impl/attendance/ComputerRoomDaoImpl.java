package com.yucitms.dao.impl.attendance;

import java.util.ArrayList;

import com.yucitms.dao.BaseDaoImpl;
import com.yucitms.dao.attendance.ComputerRoomDao;
import com.yucitms.orm.attendance.ComputerRoom;
import com.yucitms.orm.school.ClassRoom;
import com.yucitms.orm.school.Major;
/**
 * 机房
 * @author woxiaxiangyang
 *
 */
public class ComputerRoomDaoImpl extends BaseDaoImpl<ComputerRoom> implements ComputerRoomDao{

	@Override
	public ArrayList<ComputerRoom> findComputerRoomAll() {
		String HQL="From ComputerRoom";
		ArrayList<ComputerRoom> computerRoomList = (ArrayList<ComputerRoom>) getSession().createQuery(HQL).list();
		return computerRoomList;
	}
	public ComputerRoom findComputerRoomByID(Integer id) {
		String HQL="From ComputerRoom where id=?";
		ComputerRoom computerRoom = (ComputerRoom) getSession().createQuery(HQL).setInteger(0, id).uniqueResult();
		return computerRoom;
	}

}
