package com.yucitms.service.impl.exam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.Difficulty;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.exam.DifficultyService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试题难度
 * @author qiangzi
 *
 */
public class DifficultyServiceImpl extends  BaseServiceImpl implements DifficultyService{

	@Override
	public PageBean getDifficultyList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		// TODO Auto-generated method stub
		return getDifficultyDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addDifficulty(Difficulty Difficulty) {
		// TODO Auto-generated method stub
		getDifficultyDAO().save(Difficulty);
	}

	@Override
	public void deleteDifficulty(Integer id) {
		// TODO Auto-generated method stub
		getDifficultyDAO().delete(id);
	}

	@Override
	public void updateDifficulty(Difficulty Difficulty) {
		// TODO Auto-generated method stub
		getDifficultyDAO().update(Difficulty);
	}

	@Override
	public Difficulty getById(Integer id) {
		// TODO Auto-generated method stub
		return getDifficultyDAO().getById(id);
	}

	@Override
	public List<Difficulty> findEnabled() {
		String hql="from Difficulty where state=true";
		return getDifficultyDAO().getSession().createQuery(hql).list();
	}

}
