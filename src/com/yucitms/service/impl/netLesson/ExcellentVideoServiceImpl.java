package com.yucitms.service.impl.netLesson;

import java.util.Date;

import com.yucitms.orm.netLesson.ExcellentVideo;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.netLesson.ExcellentVideoService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 视频
 * @author qiangzi
 *
 */
public class ExcellentVideoServiceImpl extends BaseServiceImpl implements ExcellentVideoService{

	@Override
	public PageBean getxcellentVideoList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		return getExcellentVideoDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addxcellentVideo(ExcellentVideo excellentVideo) {
		getExcellentVideoDAO().save(excellentVideo);
		
	}

	@Override
	public void deletexcellentVideo(Integer id) {
		getExcellentVideoDAO().delete(id);
		
	}

	@Override
	public void updatexcellentVideo(ExcellentVideo excellentVideo) {
		getExcellentVideoDAO().update(excellentVideo);
		
	}

	@Override
	public ExcellentVideo getById(Integer id) {
		
		return getExcellentVideoDAO().getById(id);
	}
	
}
