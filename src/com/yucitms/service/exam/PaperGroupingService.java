package com.yucitms.service.exam;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.PaperClassify;
import com.yucitms.orm.exam.PaperGrouping;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试卷分组
 * @author qiangzi
 *
 */
public interface PaperGroupingService extends BaseService{
	public PageBean getPaperGroupingList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addPaperGrouping(PaperGrouping paperGrouping);
	public void deletePaperGrouping(Integer id);
	public void updatePaperGrouping(PaperGrouping paperGrouping);
	public PaperGrouping getById(Integer id);
	public List<PaperGrouping> findEnabled();
	
}
