package com.yucitms.service.impl.netLesson;

import com.yucitms.orm.netLesson.ExcellentTeacher;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.netLesson.ExcellentTeacherService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 精品课程教师
 * @author qiangzi
 *
 */
public class ExcellentTeacherServiceImpl extends BaseServiceImpl implements ExcellentTeacherService{

	@Override
	public PageBean getExcellentTeacherList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		
		return getExcellentTeacherDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addExcellentTeacher(ExcellentTeacher excellentTeacher) {
		getExcellentTeacherDAO().save(excellentTeacher);
		
	}

	@Override
	public void deleteExcellentTeacher(Integer id) {
	  getExcellentTeacherDAO().delete(id);
		
	}

	@Override
	public void updateExcellentTeacher(ExcellentTeacher excellentTeacher) {
		getExcellentTeacherDAO().update(excellentTeacher);
		
	}

	@Override
	public ExcellentTeacher getById(Integer id) {
		
		return getExcellentTeacherDAO().getById(id);
	}
	
}
