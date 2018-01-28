package com.yucitms.service.school;

import java.util.ArrayList;

import com.yucitms.orm.school.Major;
import com.yucitms.service.BaseService;

public interface MajorService extends BaseService{

	ArrayList<Major> findMajorIdNmaeByDepartmentID(Integer departmentID);

	Major findMajorByID(Integer majorIDInteger);

}
