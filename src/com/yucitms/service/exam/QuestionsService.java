package com.yucitms.service.exam;

import java.util.Date;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.Questions;
import com.yucitms.orm.exam.Questions;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试卷中的题
 * @author qiangzi
 *
 */
public interface QuestionsService extends BaseService{
	public PageBean getQuestionsList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addQuestions(Questions Questions);
	public void deleteQuestions(Integer id);
	public void updateQuestions(Questions Questions);
	public Questions getById(Integer id);
	public Integer findWhere(String type,Integer id,Integer qgroupingId);
	public void updateIndex(Integer id,float fenzhi,Integer index);
}
