package com.yucitms.service.impl.school;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.yucitms.orm.netLesson.ExcellentCourse;
import com.yucitms.orm.school.Course;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.school.CourseService;

/**
 * 课程
 * @author qiangzi
 *
 */
public class CourseServiceImpl extends BaseServiceImpl implements CourseService{

	@Override
	public void addCourse(Course course) {
		getCourseDAO().save(course);
	}

	@Override
	public void deleteCourse(Integer courseId) {
		getCourseDAO().delete(courseId);
		
	}

	@Override
	public void updateCourse(Course course) {
		getCourseDAO().update(course);
		
	}

	@Override
	public Course getById(Integer id) {
		
		return getCourseDAO().getById(id);
	}
	
	
}
