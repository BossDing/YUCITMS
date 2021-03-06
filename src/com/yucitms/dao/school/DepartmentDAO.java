package com.yucitms.dao.school;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.school.Department;

/**
 * 院系
 * @author qiangzi
 *
 */
public interface DepartmentDAO extends BaseDao<Department>{

	ArrayList<Department> findDepartmentIdName();
	
}
