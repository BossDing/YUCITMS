package com.yucitms.service.impl.exam;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.PaperGrouping;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.exam.PaperGroupingService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试卷分组
 * @author qiangzi
 *
 */
public class PaperGroupingServiceImpl extends BaseServiceImpl implements PaperGroupingService{

	@Override
	public PageBean getPaperGroupingList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		// TODO Auto-generated method stub
		return getPaperGroupingDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addPaperGrouping(PaperGrouping paperGrouping) {
		// TODO Auto-generated method stub
		getPaperGroupingDAO().save(paperGrouping);
	}

	@Override
	public void deletePaperGrouping(Integer id) {
		// TODO Auto-generated method stub
		getPaperGroupingDAO().delete(id);
	}

	@Override
	public void updatePaperGrouping(PaperGrouping paperGrouping) {
		// TODO Auto-generated method stub
		getPaperGroupingDAO().update(paperGrouping);
	}

	@Override
	public PaperGrouping getById(Integer id) {
		// TODO Auto-generated method stub
		return getPaperGroupingDAO().getById(id);
	}

	@Override
	public List<PaperGrouping> findEnabled() {
		String hql="from PaperGrouping where state=true";
		return getPaperGroupingDAO().getSession().createQuery(hql).list();
	}
	
	
}
