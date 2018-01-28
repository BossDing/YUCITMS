package com.yucitms.service.impl.exam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.Grouping;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.exam.GroupingService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

public class GroupingServiceImpl extends BaseServiceImpl implements GroupingService{

	@Override
	public PageBean getGroupingList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		// TODO Auto-generated method stub
		return getGroupingDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addGrouping(Grouping Grouping) {
		// TODO Auto-generated method stub
		getGroupingDAO().save(Grouping);
	}

	@Override
	public void deleteGrouping(Integer id) {
		// TODO Auto-generated method stub
		getGroupingDAO().delete(id);
	}

	@Override
	public void updateGrouping(Grouping Grouping) {
		// TODO Auto-generated method stub
		getGroupingDAO().update(Grouping);
	}

	@Override
	public Grouping getById(Integer id) {
		// TODO Auto-generated method stub
		return getGroupingDAO().getById(id);
	}

	@Override
	public List<Grouping> findEnabled() {
		String hql="from Grouping where state=true";
		return getGroupingDAO().getSession().createQuery(hql).list();
	}
	
}
