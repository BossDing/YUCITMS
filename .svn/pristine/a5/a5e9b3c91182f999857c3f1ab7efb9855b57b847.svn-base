package com.yucitms.service.impl.exam;

import java.util.Date;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.Questions;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.exam.QuestionsService;
import com.yucitms.service.exam.Questions_TianKongService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试卷中的题
 * @author qiangzi
 *
 */
public class QuestionsServiceImpl extends BaseServiceImpl implements QuestionsService{

	@Override
	public PageBean getQuestionsList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		// TODO Auto-generated method stub
		return getQuestionsDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addQuestions(Questions Questions) {
		// TODO Auto-generated method stub
		getQuestionsDAO().save(Questions);
	}

	@Override
	public void deleteQuestions(Integer id) {
		// TODO Auto-generated method stub
		getQuestionsDAO().delete(id);
	}

	@Override
	public void updateQuestions(Questions Questions) {
		// TODO Auto-generated method stub
		getQuestionsDAO().update(Questions);
	}

	@Override
	public Questions getById(Integer id) {
		// TODO Auto-generated method stub
		return getQuestionsDAO().getById(id);
	}

	@Override
	public Integer findWhere(String type, Integer id,Integer qgroupingId) {
		String sql="select id from Questions where type=? AND qcode=? AND questionsGrouping.id=?";
		return (Integer) getQuestionsDAO().getSession().createQuery(sql).setParameter(0, type).setParameter(1, id).setParameter(2, qgroupingId).uniqueResult();
	}

	@Override
	public void updateIndex(Integer id,float fenzhi, Integer index) {
		String hql="update Questions  set code=?,fenzhi=? where id=?";
		getQuestionsDAO().getSession().createQuery(hql).setParameter(0, index).setParameter(1, fenzhi).setParameter(2, id).executeUpdate();
	}
	
}
