package com.yucitms.service.exam;

import java.util.List;

import com.yucitms.orm.exam.Difficulty;
import com.yucitms.orm.exam.Grouping;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

public interface GroupingService extends BaseService{
	public PageBean getGroupingList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addGrouping(Grouping Grouping);
	public void deleteGrouping(Integer id);
	public void updateGrouping(Grouping Grouping);
	public Grouping getById(Integer id);
	public List<Grouping> findEnabled();
}
