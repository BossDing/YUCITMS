package com.yucitms.service.impl.attendance;

import java.util.ArrayList;

import com.yucitms.orm.attendance.ComputerRoom;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.attendance.ComputerRoomService;
/**
 * 机房
 * @author woxiaxiangyang
 *
 */
public class ComputerRoomServiceImpl extends BaseServiceImpl implements ComputerRoomService{

	@Override
	public ArrayList<ComputerRoom> findComputerRoomAll() {
		return getComputerRoomDao().findComputerRoomAll();
	}

	@Override
	public ComputerRoom findComputerRoomByID(Integer id) {
		return getComputerRoomDao().findComputerRoomByID(id);
	}

}
