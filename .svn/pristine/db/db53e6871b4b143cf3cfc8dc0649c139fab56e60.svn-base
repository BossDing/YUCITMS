package com.yucitms.service.impl.netLesson;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.yucitms.orm.netLesson.ReferenceData;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.netLesson.ReferenceDataService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 参考资料
 * @author qiangzi
 *
 */
public class ReferenceDataServiceImpl extends BaseServiceImpl implements ReferenceDataService{

	@Override
	public PageBean getReferenceData(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		// TODO Auto-generated method stub
		return getReferenceDataDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addReferenceData(ReferenceData referenceData) {
		getReferenceDataDAO().save(referenceData);
		
	}

	@Override
	public void deleteReferenceData(Integer id) {
		getReferenceDataDAO().delete(id);
		
	}

	@Override
	public void updatReferenceData(ReferenceData referenceData) {
		getReferenceDataDAO().update(referenceData);
		
	}

	@Override
	public ReferenceData getById(Integer id) {
		
		return getReferenceDataDAO().getById(id);
	}
		
}
