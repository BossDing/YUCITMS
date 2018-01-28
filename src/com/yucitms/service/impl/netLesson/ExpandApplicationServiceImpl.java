package com.yucitms.service.impl.netLesson;

import java.util.Date;

import com.yucitms.orm.netLesson.ExpandApplication;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.netLesson.ExpandApplicationService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 扩展应用
 * @author qiangzi
 *
 */
public class ExpandApplicationServiceImpl extends BaseServiceImpl implements ExpandApplicationService{

	@Override
	public PageBean getExpandApplicationList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		// TODO Auto-generated method stub
		return getExpandApplicationDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addExpandApplication(ExpandApplication expandApplication) {
		// TODO Auto-generated method stub
		getExpandApplicationDAO().save(expandApplication);
	}

	@Override
	public void deleteExpandApplication(Integer id) {
		getExpandApplicationDAO().delete(id);
		
	}

	@Override
	public void updateExpandApplication(ExpandApplication expandApplication) {
		// TODO Auto-generated method stub
		getExpandApplicationDAO().update(expandApplication);
	}

	@Override
	public com.yucitms.orm.netLesson.ExpandApplication getById(Integer id) {
		// TODO Auto-generated method stub
		return getExpandApplicationDAO().getById(id);
	}
	
}
