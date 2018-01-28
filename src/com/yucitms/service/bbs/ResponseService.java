package com.yucitms.service.bbs;

import com.yucitms.orm.bbs.Response;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 帖子回复
 * @author qiangzi
 *
 */
public interface ResponseService extends BaseService{
	public PageBean getResponseList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addResponse(Response response);
	public void deleteResponse(Integer id);
	public void updatResponse(Response response);
	public Response getById(Integer id); 
    
}
