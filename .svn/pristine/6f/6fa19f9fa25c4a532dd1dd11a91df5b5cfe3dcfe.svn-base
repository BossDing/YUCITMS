package com.yucitms.service.impl.practicalTraining;

import com.yucitms.orm.practicalTraining.PracticalTrainingTemplate;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.practicalTraining.PracticalTrainingTemplateService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;
/**
 * 实训模板
 * @author woxiaxiangyang
 *
 */
public class PracticalTrainingTemplateServiceImpl extends BaseServiceImpl implements PracticalTrainingTemplateService{

	/**
	 * 保存
	 */
	@Override
	public void saveTemplate(PracticalTrainingTemplate practicalTrainingTemplate) {
		getPracticalTrainingTemplateDao().save(practicalTrainingTemplate);
		
	}

	@Override
	public PageBean queryAttendance(int pAGENUM, int eXCELLENTCOURSE_PageSize,
			HqlHelper hqlHelper) {
		return getPracticalTrainingTemplateDao().getPageBean(pAGENUM, eXCELLENTCOURSE_PageSize, hqlHelper);
	}

	@Override
	public PracticalTrainingTemplate getById(Integer integertemplateID) {
		// TODO Auto-generated method stub
		return getPracticalTrainingTemplateDao().getById(integertemplateID);
	}

	@Override
	public void deleteById(Integer integertemplateID) {
		getPracticalTrainingTemplateDao().delete(integertemplateID);
	}

	@Override
	public void update(PracticalTrainingTemplate practicalTrainingTemplate) {
		getPracticalTrainingTemplateDao().update(practicalTrainingTemplate);
		
	}
	
}
