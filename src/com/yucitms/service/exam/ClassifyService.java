package com.yucitms.service.exam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.Classify;
import com.yucitms.orm.netLesson.LessionBook;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试题分类
 * @author qiangzi
 *
 */
public interface ClassifyService extends BaseService{
	public PageBean getClassifyList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addClassify(Classify classify);
	public void deleteClassify(Integer id);
	public void updateClassify(Classify classify);
	public Classify getById(Integer id); 
    public List<Classify> findEnabled();
}
