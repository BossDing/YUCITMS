package com.yucitms.service.impl.exam;

import java.util.HashSet;
import java.util.Set;

import com.yucitms.orm.exam.QuestionsGrouping;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.exam.QuestionsGroupingService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试卷中大题
 * @author qiangzi
 *
 */
public class QuestionsGroupingServiceImpl extends BaseServiceImpl implements QuestionsGroupingService{

	@Override
	public PageBean getPaperQuestionsGroupingList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		// TODO Auto-generated method stub
		return getQuestionsGroupingDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addQuestionsGrouping(QuestionsGrouping questionsGrouping) {
		// TODO Auto-generated method stub
		getQuestionsGroupingDAO().save(questionsGrouping);
	}

	@Override
	public void deleteQuestionsGrouping(Integer id) {
		// TODO Auto-generated method stub
		getQuestionsGroupingDAO().delete(id);
	}

	@Override
	public void updateQuestionsGrouping(QuestionsGrouping questionsGrouping) {
		// TODO Auto-generated method stub
		getQuestionsGroupingDAO().update(questionsGrouping);
	}

	@Override
	public QuestionsGrouping getById(Integer id) {
		// TODO Auto-generated method stub
		return getQuestionsGroupingDAO().getById(id);
	}
	
	
}
