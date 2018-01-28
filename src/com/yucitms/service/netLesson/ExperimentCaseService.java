package com.yucitms.service.netLesson;

import java.util.Date;

import com.yucitms.orm.netLesson.ExcellentVideo;
import com.yucitms.orm.netLesson.ExperimentCase;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 实训案例			
 * @author qiangzi
 *
 */
public interface ExperimentCaseService extends BaseService{
	public PageBean getExperimentCaseList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addExperimentCase(ExperimentCase experimentCase);
	public void deleteExperimentCase(Integer id);
	public void updatExperimentCase(ExperimentCase experimentCase);
	public ExperimentCase getById(Integer id); 
}
