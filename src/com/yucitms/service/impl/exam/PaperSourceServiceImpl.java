package com.yucitms.service.impl.exam;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.PaperSource;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.exam.PaperSourceService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试卷来源
 * @author qiangzi
 *
 */
public class PaperSourceServiceImpl extends BaseServiceImpl implements PaperSourceService{

	@Override
	public PageBean getPaperSourceList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		// TODO Auto-generated method stub
		return getPaperSourceDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addPaperSource(PaperSource paperSource) {
		// TODO Auto-generated method stub
		getPaperSourceDAO().save(paperSource);
	}

	@Override
	public void deletePaperSource(Integer id) {
		// TODO Auto-generated method stub
		getPaperSourceDAO().delete(id);
	}

	@Override
	public void updatePaperSource(PaperSource paperSource) {
		// TODO Auto-generated method stub
		getPaperSourceDAO().update(paperSource);
	}

	@Override
	public PaperSource getById(Integer id) {
		// TODO Auto-generated method stub
		return getPaperSourceDAO().getById(id);
	}

	@Override
	public List<PaperSource> findEnabled() {
		String hql="from PaperSource where state=true";
		return getPaperSourceDAO().getSession().createQuery(hql).list();
	}
	
	
}
