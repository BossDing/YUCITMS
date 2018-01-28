package com.yucitms.service.netLesson;

import java.util.Date;

import com.yucitms.orm.netLesson.ExcellentVideo;
import com.yucitms.orm.netLesson.LessionBook;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 视频
 * @author qiangzi
 *
 */
public interface ExcellentVideoService extends BaseService{
	public PageBean getxcellentVideoList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addxcellentVideo(ExcellentVideo excellentVideo);
	public void deletexcellentVideo(Integer id);
	public void updatexcellentVideo(ExcellentVideo excellentVideo);
	public ExcellentVideo getById(Integer id); 
}
