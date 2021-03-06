package com.yucitms.service.impl.school;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.yucitms.orm.school.Department;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.school.DepartmentService;

/**
 * 院系
 * @author qiangzi
 *
 */
public class DepartmentServiceImpl extends BaseServiceImpl implements DepartmentService{

	@Override
	public ArrayList<Department> findDepartmentIdName() {
		return getDepartmentDAO().findDepartmentIdName();
	}
	
	}
