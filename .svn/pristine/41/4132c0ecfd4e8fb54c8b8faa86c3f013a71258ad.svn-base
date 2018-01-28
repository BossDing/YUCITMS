package com.yucitms.test;

import java.util.ArrayList;

import com.yucitms.orm.school.ClassRoom;
import com.yucitms.service.school.ClassRoomService;

public class Demo {
private static ClassRoomService classRoomService;
	/**
	 * @param args
	 */
	public static void main(String[] args) {


		ArrayList<ClassRoom> classRoomList= classRoomService.getClassRoomBymajorID(10001);
		String json="";
		for(int i=0;i<classRoomList.size();i++){
			ClassRoom classRoom = classRoomList.get(i);
			 String str="{\"classID\":"+classRoom.getClassRoomID()+",\"classRoomName\":\""+classRoom.getClassRoomName()+"\"},";
			 json+=str;
		}
		String jsonstr=json.substring(0, json.length()-1);
		jsonstr="["+jsonstr+"]";
		
		System.out.println(jsonstr);

	}

}
