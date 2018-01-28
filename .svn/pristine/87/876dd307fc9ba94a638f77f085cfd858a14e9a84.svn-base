package com.yucitms.service.exam;

import java.io.OutputStream;
import java.util.Date;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.Questions_DanXuan;
import com.yucitms.orm.exam.Questions_DanXuan;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 单选
 * @author qiangzi
 *
 */
public interface Questions_DanXuanService extends BaseService{
	public PageBean getQuestions_DanXuanList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addQuestions_DanXuan(Questions_DanXuan questions_DanXuan);
	public void deleteQuestions_DanXuan(Integer id);
	public void updateQuestions_DanXuan(Questions_DanXuan questions_DanXuan);
	public Questions_DanXuan getById(Integer id);
	public void batchEnabled(Integer []ids);
	public void batchDisable(Integer []ids);
	public void batchDelete(Integer []ids);
	public void exprotQuestion(OutputStream out,Integer []ids);
}
