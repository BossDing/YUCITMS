package com.yucitms.service.netLesson;



import java.util.List;

import com.yucitms.orm.netLesson.ExcellentCourse;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 精品课程
 * @author qiangzi
 *
 */
public interface ExcellentCourseService extends BaseService{
	public PageBean getCourseList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addCourse(ExcellentCourse course);
	public void deleteCourse(Integer courseId);
	public void updateCourse(ExcellentCourse course);
	public ExcellentCourse getById(Integer id);
	public List<ExcellentCourse> findAll();
	public List<ExcellentCourse> findFinish();
	public void setZhuxian(Integer id);
	public ExcellentCourse findZhuXian();
}
