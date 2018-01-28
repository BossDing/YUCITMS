package com.yucitms.service.bbs;

import java.util.List;
import java.util.Set;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.bbs.Post;
import com.yucitms.orm.bbs.Type;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;
/**
 * 帖子类型
 * @author qiangzi
 *
 */
public interface TypeService extends BaseService{
	public PageBean getTypeList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public List<Type> findAll();
	public void addType(Type type);
	public void deleteType(Integer id);
	public void updatPost(Type type);
	public Type getById(Integer id); 
  
}
