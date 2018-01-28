package com.yucitms.service.exam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yucitms.orm.exam.PaperSource;
import com.yucitms.orm.exam.QuestionsGrouping;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试卷中大题
 * @author qiangzi
 *
 */
public interface QuestionsGroupingService extends BaseService{
	public PageBean getPaperQuestionsGroupingList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addQuestionsGrouping(QuestionsGrouping questionsGrouping);
	public void deleteQuestionsGrouping(Integer id);
	public void updateQuestionsGrouping(QuestionsGrouping questionsGrouping);
	public QuestionsGrouping getById(Integer id);
	
}
