package com.yucitms.service.exam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.Grouping;
import com.yucitms.orm.exam.Source;
import com.yucitms.orm.exam.Source;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试题来源
 * @author qiangzi
 *
 */
public interface SourceService extends BaseService{
	public PageBean getSourceList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addSource(Source Source);
	public void deleteSource(Integer id);
	public void updateSource(Source Source);
	public Source getById(Integer id);
	public List<Source> findEnabled();
}
