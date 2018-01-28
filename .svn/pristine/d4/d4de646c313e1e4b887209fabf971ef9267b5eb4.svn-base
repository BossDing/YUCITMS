package com.yucitms.service.impl.netLesson;

import java.util.Date;

import com.yucitms.orm.netLesson.ExperimentCase;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.netLesson.ExperimentCaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 实训案例			
 * @author qiangzi
 *
 */
public class ExperimentCaseServiceImpl extends BaseServiceImpl implements ExperimentCaseService{

	@Override
	public PageBean getExperimentCaseList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		// TODO Auto-generated method stub
		return getExperimentCaseDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addExperimentCase(ExperimentCase experimentCase) {
		// TODO Auto-generated method stub
		getExperimentCaseDAO().save(experimentCase);
	}

	@Override
	public void deleteExperimentCase(Integer id) {
		// TODO Auto-generated method stub
		getExperimentCaseDAO().delete(id);
	}

	@Override
	public void updatExperimentCase(ExperimentCase experimentCase) {
		// TODO Auto-generated method stub
		getExperimentCaseDAO().update(experimentCase);
	}

	@Override
	public ExperimentCase getById(Integer id) {
		// TODO Auto-generated method stub
		return getExperimentCaseDAO().getById(id);
	}
	
}
