package com.yucitms.service.impl.bbs;

import java.util.Date;

import com.yucitms.orm.bbs.Post;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.bbs.PostService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

public class PostServiceImpl extends BaseServiceImpl implements PostService {

	@Override
	public PageBean getPostList(int pageNum, int Pagesize, HqlHelper hqlHelper) {

		return getPostDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addPost(Post post) {
		// TODO Auto-generated method stub
		getPostDAO().save(post);
	}

	@Override
	public void deletePost(Integer id) {
		// TODO Auto-generated method stub
		getPostDAO().delete(id);
	}

	@Override
	public void updatPost(Post post) {
		// TODO Auto-generated method stub
		getPostDAO().update(post);
	}

	@Override
	public Post getById(Integer id) {
		// TODO Auto-generated method stub
		return getPostDAO().getById(id);
	}

	@Override
	public long getTimeCount(Date start, Date end) {
		String hql = "select count(*) from Post as p where p.createTime >=? and p.createTime <=? ";

		return (Long) getPostDAO().getSession().createQuery(hql)
				.setTimestamp(0, start).setTimestamp(1, end).uniqueResult();
	}

	@Override
	public long newresp() {
		String hql = "select count(*) from Post as p where p.newresp=true";

		return (Long) getPostDAO().getSession().createQuery(hql).uniqueResult();
	}

}
