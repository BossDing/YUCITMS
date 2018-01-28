package com.yucitms.orm.attendance;

import java.util.HashSet;
import java.util.Set;

/**
 * 机房
 * @author woxiaxiangyang
 *
 */
public class ComputerRoom implements java.io.Serializable{
	private Integer computerRoomID;
	private String ipSection;//ip段
	private String roomNo;//房间号
	private String address;//房间地址
	
	
	
	public Integer getComputerRoomID() {
		return computerRoomID;
	}
	public void setComputerRoomID(Integer computerRoomID) {
		this.computerRoomID = computerRoomID;
	}
	public String getIpSection() {
		return ipSection;
	}
	public void setIpSection(String ipSection) {
		this.ipSection = ipSection;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
