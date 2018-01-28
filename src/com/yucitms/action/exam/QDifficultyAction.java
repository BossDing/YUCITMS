package com.yucitms.action.exam;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.yucitms.action.BaseAction;
import com.yucitms.orm.exam.Classify;
import com.yucitms.orm.exam.Difficulty;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试题难度属性
 * @author qiangzi
 *
 */
public class QDifficultyAction extends BaseAction<Difficulty>{
	/**
	 * 列表
	 * @return
	 */
	public String getDifficultyList(){
		HqlHelper hqlHelper = new HqlHelper(Difficulty.class,"c").addOrderByProperty("id", false);
		PageBean bean=difficultyService.getDifficultyList(pageNum, 10, hqlHelper);
		ActionContext.getContext().getValueStack().push(bean);
		return "getDifficultyList";
	}
	/**
	 * 添加
	 * @return
	 */
	public String addDifficultyPage(){
		return "addDifficultyPage";
	}
	
	public String addDifficulty(){
		model.setCreateDate(new Date());
		model.setState(true);
		difficultyService.addDifficulty(model);
		return "DifficultyList";
	}
	/**
	 * 修改
	 * @return
	 */
	public String updateDifficultyPage(){
		Difficulty difficulty=difficultyService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(difficulty);
		return "updateDifficultyPage";
	}
	
	public String updateDifficulty(){
		Difficulty difficulty=difficultyService.getById(model.getId());
		difficulty.setDifficulty(model.getDifficulty());
		difficultyService.updateDifficulty(difficulty);
		return "DifficultyList";
	}
	/**
	 * 禁用
	 */
	public String  disableDifficulty(){
		Difficulty difficulty=difficultyService.getById(model.getId());
		difficulty.setState(false);
		difficultyService.updateDifficulty(difficulty);
		return "DifficultyList";
	}
	/**
	 * 启用
	 */
	public String enabledDifficulty(){
		Difficulty difficulty=difficultyService.getById(model.getId());
		difficulty.setState(true);
		difficultyService.updateDifficulty(difficulty);
		return "DifficultyList";
	}
}
