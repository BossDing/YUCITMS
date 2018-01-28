package com.yucitms.service.impl.school;

import java.util.ArrayList;

import com.yucitms.orm.school.Major;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.school.MajorService;

public class MajorServiceImpl extends BaseServiceImpl implements MajorService{

	@Override
	public ArrayList<Major> findMajorIdNmaeByDepartmentID(Integer departmentID) {
		return getMajorDao().findMajorIdNmaeByDepartmentID(departmentID);
	}

	@Override
	public Major findMajorByID(Integer majorIDInteger) {
		return getMajorDao().findMajorByID(majorIDInteger);
	}

}
