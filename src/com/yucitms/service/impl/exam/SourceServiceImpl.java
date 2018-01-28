package com.yucitms.service.impl.exam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.Questions_TianKong;
import com.yucitms.orm.exam.Source;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.exam.Questions_TianKongService;
import com.yucitms.service.exam.SourceService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试题来源
 * @author qiangzi
 *
 */
public class SourceServiceImpl extends BaseServiceImpl implements SourceService{

	@Override
	public PageBean getSourceList(int pageNum, int Pagesize, HqlHelper hqlHelper) {
		// TODO Auto-generated method stub
		return getSourceDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addSource(Source Source) {
		// TODO Auto-generated method stub
		getSourceDAO().save(Source);
	}

	@Override
	public void deleteSource(Integer id) {
		// TODO Auto-generated method stub
		getSourceDAO().delete(id);
	}

	@Override
	public void updateSource(Source Source) {
		// TODO Auto-generated method stub
		getSourceDAO().update(Source);
	}

	@Override
	public Source getById(Integer id) {
		
		return getSourceDAO().getById(id);
	}

	@Override
	public List<Source> findEnabled() {
		String hql="from Source where state=true";
		return getSourceDAO().getSession().createQuery(hql).list();
	}

	
}
