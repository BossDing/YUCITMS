package com.yucitms.service.exam;

import java.io.OutputStream;
import java.util.Date;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.Questions_JianDa;
import com.yucitms.orm.exam.Questions_JianDa;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 简答题
 * @author qiangzi
 *
 */
public interface Questions_JianDaService extends BaseService{
	public PageBean getQuestions_JianDaList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addQuestions_JianDa(Questions_JianDa questions_JianDa);
	public void deleteQuestions_JianDa(Integer id);
	public void updateQuestions_JianDa(Questions_JianDa questions_JianDa);
	public Questions_JianDa getById(Integer id);
	public void batchEnabled(Integer []ids);
	public void batchDisable(Integer []ids);
	public void batchDelete(Integer []ids);
	public void exprotQuestion(OutputStream out,Integer []ids);
}
