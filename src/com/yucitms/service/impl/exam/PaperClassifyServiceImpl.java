package com.yucitms.service.impl.exam;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.PaperClassify;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.exam.PaperClassifyService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试卷分类
 * @author qiangzi
 *
 */
public class PaperClassifyServiceImpl extends BaseServiceImpl implements PaperClassifyService{

	@Override
	public PageBean getPaperClassifyList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		// TODO Auto-generated method stub
		return getPaperClassifyDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addPaperClassify(PaperClassify paperClassify) {
		// TODO Auto-generated method stub
		getPaperClassifyDAO().save(paperClassify);
	}

	@Override
	public void deletePaperClassify(Integer id) {
		// TODO Auto-generated method stub
		getPaperClassifyDAO().delete(id);
	}

	@Override
	public void updatePaperClassify(PaperClassify paperClassify) {
		// TODO Auto-generated method stub
		getPaperClassifyDAO().update(paperClassify);
	}

	@Override
	public PaperClassify getById(Integer id) {
		// TODO Auto-generated method stub
		return getPaperClassifyDAO().getById(id);
	}

	@Override
	public List<PaperClassify> findEnabled() {
		String hql="from PaperClassify where state=true";
		return getPaperClassifyDAO().getSession().createQuery(hql).list();
	}
	
}
