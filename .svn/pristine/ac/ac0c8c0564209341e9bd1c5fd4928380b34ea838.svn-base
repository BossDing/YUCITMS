package com.yucitms.service.exam;

import java.io.OutputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yucitms.action.exam.QuestionsConfig;
import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.ExamPaper;
import com.yucitms.orm.exam.Grouping;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试卷
 * @author qiangzi
 *
 */
public interface ExamPaperService extends BaseService{
	public PageBean getExamPaperList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addExamPaper(ExamPaper examPaper);
	public void deleteExamPaper(Integer id);
	public void updateExamPaper(ExamPaper examPaper);
	public ExamPaper getById(Integer id);
	public List<ExamPaper> findEnabled();
	public void exportPaper(OutputStream out,Integer id);
	public void batchEnabledOrDisable(String type,Integer ids[]);
}
