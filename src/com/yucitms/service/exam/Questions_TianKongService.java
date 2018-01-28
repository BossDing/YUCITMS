package com.yucitms.service.exam;

import java.io.OutputStream;
import java.util.Date;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.Questions_TianKong;
import com.yucitms.orm.exam.Questions_TianKong;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 填空题
 * @author qiangzi
 *
 */
public interface Questions_TianKongService  extends BaseService{
	public PageBean getQuestions_TianKongList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addQuestions_TianKong(Questions_TianKong questions_TianKong);
	public void deleteQuestions_TianKong(Integer id);
	public void updateQuestions_TianKong(Questions_TianKong questions_TianKong);
	public Questions_TianKong getById(Integer id);
	public void batchEnabled(Integer []ids);
	public void batchDisable(Integer []ids);
	public void batchDelete(Integer []ids);
	public void exprotQuestion(OutputStream out,Integer []ids);
}
