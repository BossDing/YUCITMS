package com.yucitms.dao.impl.school;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;

import com.yucitms.dao.BaseDao;
import com.yucitms.dao.BaseDaoImpl;
import com.yucitms.dao.school.DepartmentDAO;
import com.yucitms.orm.bbs.Post;
import com.yucitms.orm.school.Department;

/**
 * 院系
 * @author qiangzi
 *
 */
public class DepartmentDAOImpl extends BaseDaoImpl<Department> implements DepartmentDAO{

	@Override
	public ArrayList<Department> findDepartmentIdName() {
		// TODO Auto-generated method stub
//		String HQL="From Department";
		String HQL="select new Department(id,departmentName) From Department";
		ArrayList<Department> departmentList = (ArrayList<Department>) getSession().createQuery(HQL).list();
		
		
		
		
//		Department department = new Department();
//		Criteria criteria = getSession().createCriteria(Department.class);
//        criteria.add(Example.create(department));
//        ArrayList<Department> departmentList= (ArrayList<Department>) criteria.list();

        return departmentList;
	}
	
}
