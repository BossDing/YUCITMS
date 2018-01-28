package com.yucitms.service.impl.bbs;

import java.util.List;
import java.util.Set;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.bbs.Type;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.bbs.TypeService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;
/**
 * 帖子类型
 * @author qiangzi
 *
 */
public class TypeServiceImpl extends BaseServiceImpl implements TypeService{

	@Override
	public PageBean getTypeList(int pageNum, int Pagesize, HqlHelper hqlHelper) {
		return getTypeDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public List<Type> findAll() {
		// TODO Auto-generated method stub
		return getTypeDAO().findAll();
	}

	@Override
	public void addType(Type type) {
		// TODO Auto-generated method stub
		getTypeDAO().save(type);
	}

	@Override
	public void deleteType(Integer id) {
		// TODO Auto-generated method stub
		getTypeDAO().delete(id);
	}

	@Override
	public void updatPost(Type type) {
		// TODO Auto-generated method stub
		getTypeDAO().update(type);
	}

	@Override
	public Type getById(Integer id) {
		// TODO Auto-generated method stub
		return getTypeDAO().getById(id);
	}

  
}
