package com.yucitms.service.impl.bbs;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.bbs.Response;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.bbs.ResponseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 帖子回复
 * @author qiangzi
 *
 */
public class ResponseServiceImpl extends BaseServiceImpl implements ResponseService{

	

	@Override
	public void addResponse(Response response) {
		// TODO Auto-generated method stub
		getResponseDAO().save(response);
	}

	@Override
	public void deleteResponse(Integer id) {
		// TODO Auto-generated method stub
		getResponseDAO().delete(id);
	}

	@Override
	public void updatResponse(Response response) {
		// TODO Auto-generated method stub
		getResponseDAO().update(response);
	}

	@Override
	public Response getById(Integer id) {
		// TODO Auto-generated method stub
		return getResponseDAO().getById(id);
	}

	@Override
	public PageBean getResponseList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		// TODO Auto-generated method stub
		return getResponseDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

    
}
