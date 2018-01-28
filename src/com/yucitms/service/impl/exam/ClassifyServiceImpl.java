package com.yucitms.service.impl.exam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.Classify;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.exam.ClassifyService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试题分类
 * @author qiangzi
 *
 */
public class ClassifyServiceImpl extends BaseServiceImpl implements ClassifyService{

	@Override
	public PageBean getClassifyList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		
		return getClassifyDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addClassify(Classify classify) {
		// TODO Auto-generated method stub
		getClassifyDAO().save(classify);
	}

	@Override
	public void deleteClassify(Integer id) {
		// TODO Auto-generated method stub
		getClassifyDAO().delete(id);
	}

	@Override
	public void updateClassify(Classify classify) {
		// TODO Auto-generated method stub
		getClassifyDAO().update(classify);
	}

	@Override
	public Classify getById(Integer id) {
		// TODO Auto-generated method stub
		return getClassifyDAO().getById(id);
	}

	@Override
	public List<Classify> findEnabled() {
		String hql="from Classify where state=true";
		return getClassifyDAO().getSession().createQuery(hql).list();
	}
	
}
