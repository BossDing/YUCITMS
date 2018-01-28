package com.yucitms.service.bbs;

import java.util.Date;

import com.yucitms.orm.bbs.Post;
import com.yucitms.orm.netLesson.ExcellentVideo;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

public interface PostService extends BaseService{
	public PageBean getPostList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addPost(Post post);
	public void deletePost(Integer id);
	public void updatPost(Post post);
	public Post getById(Integer id); 
	public long getTimeCount(Date start,Date end);
	public long newresp();
}
