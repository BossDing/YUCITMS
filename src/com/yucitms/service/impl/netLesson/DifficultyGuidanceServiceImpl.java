/**
 * 
 */
/**
 * @author qiangzi
 *
 */
package com.yucitms.service.impl.netLesson;

import com.yucitms.dao.netLesson.DifficultyGuidanceDAO;
import com.yucitms.orm.netLesson.DifficultyGuidance;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.netLesson.DifficultyGuidanceService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

public class DifficultyGuidanceServiceImpl extends BaseServiceImpl implements DifficultyGuidanceService{

	@Override
	public void add(DifficultyGuidance entity) {
	getDifficultyGuidanceDAO().save(entity);
	}

	@Override
	public PageBean getDifficultyGuidanceList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		return getDifficultyGuidanceDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public DifficultyGuidance getById(Integer id) {
		// TODO Auto-generated method stub
		return getDifficultyGuidanceDAO().getById(id);
	}

	@Override
	public void deleteDifficultyGuidance(Integer id) {
		getDifficultyGuidanceDAO().delete(id);
		
	}

	@Override
	public void updateDifficultyGuidance(DifficultyGuidance difficultyGuidance) {
		getDifficultyGuidanceDAO().update(difficultyGuidance);
		
	}
	
}