package com.yucitms.service.exam;

import java.util.List;

import com.yucitms.orm.exam.Classify;
import com.yucitms.orm.exam.Difficulty;
import com.yucitms.service.BaseService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试题难度
 * @author qiangzi
 *
 */
public interface DifficultyService extends  BaseService{
	public PageBean getDifficultyList(int pageNum,int Pagesize,HqlHelper hqlHelper);
	public void addDifficulty(Difficulty Difficulty);
	public void deleteDifficulty(Integer id);
	public void updateDifficulty(Difficulty Difficulty);
	public Difficulty getById(Integer id); 
	public List<Difficulty> findEnabled();
}
