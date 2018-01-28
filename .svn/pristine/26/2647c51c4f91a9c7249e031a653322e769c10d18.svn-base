package com.yucitms.service.exam;

import java.io.OutputStream;
import java.util.Date;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.Questions;
import com.yucitms.orm.exam.Questions_DuoXuan;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 多选
 * @author qiangzi
 *
 */
public interface Questions_DuoXuanService extends BaseService{
	public PageBean getQuestions_DuoXuanList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addQuestions_DuoXuan(Questions_DuoXuan questions_DuoXuan);
	public void deleteQuestions_DuoXuan(Integer id);
	public void updateQuestions_DuoXuan(Questions_DuoXuan questions_DuoXuan);
	public Questions_DuoXuan getById(Integer id);
	//试题批量启用
	public void batchEnabled(Integer []ids);
	public void batchDisable(Integer []ids);
	public void batchDelete(Integer []ids);
	public void exprotQuestion(OutputStream out,Integer []ids);
}
