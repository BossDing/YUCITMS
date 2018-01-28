package com.yucitms.service.netLesson;

import com.yucitms.orm.netLesson.LessionBook;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 精品课程所需要的书籍
 * @author qiangzi
 *
 */
public interface LessionBookService extends BaseService{
	public PageBean getLessonBookList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addLessonBook(LessionBook lessionBook);
	public void deleteLessonBook(Integer id);
	public void updateLessonBook(LessionBook lessionBook);
	public LessionBook getById(Integer id); 
	
	
}
