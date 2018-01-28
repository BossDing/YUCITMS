package com.yucitms.dao.impl.school;

import java.util.ArrayList;

import com.yucitms.dao.BaseDaoImpl;
import com.yucitms.dao.school.MajorDao;
import com.yucitms.orm.school.ClassRoom;
import com.yucitms.orm.school.Major;
/**
 * 专业
 * @author woxiaxiangyang
 *
 */
public class MajorDaoImpl extends BaseDaoImpl<Major> implements MajorDao{

	@Override
	public ArrayList<Major> findMajorIdNmaeByDepartmentID(Integer departmentID) {
//		String HQL="select new Major(id,majorName,department) From Major where department =?";
//		ArrayList<Major> majorList = (ArrayList<Major>) getSession().createQuery(HQL).setInteger(0, departmentID).list();
//	ArrayList<Major> majorFinalList =new ArrayList<Major>();
//		for(Major m:majorList){
//			Major major = new Major();
//			major.setMajorID(m.getMajorID());
//			major.setMajorName(m.getMajorName());
//			major.setDepartmentID(departmentID);
//			major.setDepartment(null);
//			majorFinalList.add(major);
//		}
//		return majorFinalList;
		String HQL="select new Major(id,majorName) From Major where department =?";
		ArrayList<Major> majorList = (ArrayList<Major>) getSession().createQuery(HQL).setInteger(0, departmentID).list();
		return majorList;
	}

	@Override
	public Major findMajorByID(Integer majorIDInteger) {
		String HQL="From Major where majorID =?";
		Major major = (Major) getSession().createQuery(HQL).setInteger(0, majorIDInteger).uniqueResult();
		return major;
	}

}
