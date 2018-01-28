package com.yucitms.service.impl.netLesson;

import java.util.List;

import com.yucitms.orm.netLesson.ExcellentCourse;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.netLesson.ExcellentCourseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 精品课程
 * @author qiangzi
 *
 */
public class ExcellentCourseServiceImpl extends BaseServiceImpl implements ExcellentCourseService{

	@Override
	public PageBean getCourseList(int pageNum,int Pagesize,HqlHelper hqlHelper) {
		return getExcellentCourseDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}
	@Override
	public void addCourse(ExcellentCourse course) {
		getExcellentCourseDAO().save(course);
	}

	@Override
	public void deleteCourse(Integer courseId) {
		getExcellentCourseDAO().delete(courseId);
		
	}

	@Override
	public void updateCourse(ExcellentCourse course) {
		getExcellentCourseDAO().update(course);
		
	}

	@Override
	public ExcellentCourse getById(Integer id) {
		
		return getExcellentCourseDAO().getById(id);
	}
	@Override
	public java.util.List<ExcellentCourse> findAll() {
		return getExcellentCourseDAO().findAll();
	}
	@Override
	public List<ExcellentCourse> findFinish() {
		String HQL="from ExcellentCourse e where e.addFinish=? AND e.state=?";
		return getExcellentCourseDAO().getSession().createQuery(HQL).setParameter(0, true).setParameter(1, true).list();
	}
	@Override
	public void setZhuxian(Integer id) {
		//先取消主显的
		String HQL="update ExcellentCourse set zhuxian=false where zhuxian=true";
		getExcellentCourseDAO().getSession().createQuery(HQL).executeUpdate();
		//设置主显
		String HQL1="update ExcellentCourse set zhuxian=true where id=?";
		getExcellentCourseDAO().getSession().createQuery(HQL1).setParameter(0, id).executeUpdate();
		
	}
	@Override
	public ExcellentCourse findZhuXian() {
		String hql="From ExcellentCourse where zhuxian=true";
		return (ExcellentCourse) getExcellentCourseDAO().getSession().createQuery(hql).uniqueResult();
	}
	
	
}
