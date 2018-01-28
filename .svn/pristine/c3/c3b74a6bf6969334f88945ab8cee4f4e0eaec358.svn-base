package com.yucitms.service.exam;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.PaperSource;
import com.yucitms.orm.exam.PaperSource;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试卷来源
 * @author qiangzi
 *
 */
public interface PaperSourceService extends BaseService{
	public PageBean getPaperSourceList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addPaperSource(PaperSource paperSource);
	public void deletePaperSource(Integer id);
	public void updatePaperSource(PaperSource paperSource);
	public PaperSource getById(Integer id);
	public List<PaperSource> findEnabled();
	
}
