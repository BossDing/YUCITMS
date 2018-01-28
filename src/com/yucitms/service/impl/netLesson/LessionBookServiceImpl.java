package com.yucitms.service.impl.netLesson;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.yucitms.orm.netLesson.LessionBook;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.netLesson.LessionBookService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 精品课程所需要的书籍
 * @author qiangzi
 *
 */
public class LessionBookServiceImpl extends BaseServiceImpl implements LessionBookService{

	@Override
	public PageBean getLessonBookList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		
		return getLessionBookDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addLessonBook(LessionBook lessionBook) {
		getLessionBookDAO().save(lessionBook);
		
	}

	@Override
	public void deleteLessonBook(Integer id) {
		getLessionBookDAO().delete(id);
		
	}

	@Override
	public void updateLessonBook(LessionBook lessionBook) {
		getLessionBookDAO().update(lessionBook);
		
	}

	@Override
	public LessionBook getById(Integer id) {
		return getLessionBookDAO().getById(id);
	}
	
	
	
}
