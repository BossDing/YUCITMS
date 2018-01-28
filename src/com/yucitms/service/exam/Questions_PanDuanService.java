package com.yucitms.service.exam;

import java.io.OutputStream;
import java.util.Date;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.Questions_PanDuan;
import com.yucitms.orm.exam.Questions_PanDuan;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 判断题
 * @author qiangzi
 *
 */
public interface Questions_PanDuanService  extends BaseService{
	public PageBean getQuestions_PanDuanList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addQuestions_PanDuan(Questions_PanDuan questions_PanDuan);
	public void deleteQuestions_PanDuan(Integer id);
	public void updateQuestions_PanDuan(Questions_PanDuan questions_PanDuan);
	public Questions_PanDuan getById(Integer id);
	public void batchEnabled(Integer []ids);
	public void batchDisable(Integer []ids);
	public void batchDelete(Integer []ids);
	public void exprotQuestion(OutputStream out,Integer []ids);
}
