package com.yucitms.service.school;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.yucitms.orm.netLesson.ExcellentCourse;
import com.yucitms.orm.school.Course;
import com.yucitms.service.BaseService;

/**
 * 课程
 * @author qiangzi
 *
 */
public interface CourseService extends BaseService{
	public void addCourse(Course course);
	public void deleteCourse(Integer courseId);
	public void updateCourse(Course course);
	public Course getById(Integer id);
}
