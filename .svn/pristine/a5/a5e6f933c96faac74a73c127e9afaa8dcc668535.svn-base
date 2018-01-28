package com.yucitms.service.exam;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.ExamPaper;
import com.yucitms.orm.exam.PaperClassify;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试卷分类
 * @author qiangzi
 *
 */
public interface PaperClassifyService extends BaseService{
	public PageBean getPaperClassifyList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addPaperClassify(PaperClassify paperClassify);
	public void deletePaperClassify(Integer id);
	public void updatePaperClassify(PaperClassify paperClassify);
	public PaperClassify getById(Integer id);
	public List<PaperClassify> findEnabled();
}
