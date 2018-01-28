package com.yucitms.service.impl.netLesson;

import com.yucitms.orm.netLesson.ImgCarousel;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.netLesson.ImgCarouselService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

public class ImgCarouselServiceImpl extends BaseServiceImpl implements ImgCarouselService{

	@Override
	public PageBean getImgCarouselList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		
		return getImgCarouselDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addImgCarousel(ImgCarousel imgCarousel) {
		// TODO Auto-generated method stub
		getImgCarouselDAO().save(imgCarousel);
	}

	@Override
	public void deleteImgCarousel(Integer id) {
		// TODO Auto-generated method stub
		getImgCarouselDAO().delete(id);
	}

	@Override
	public void updateImgCarousel(ImgCarousel imgCarousel) {
		// TODO Auto-generated method stub
		getImgCarouselDAO().update(imgCarousel);
	}

	@Override
	public ImgCarousel getById(Integer id) {
		// TODO Auto-generated method stub
		return getImgCarouselDAO().getById(id);
	}
	
}
