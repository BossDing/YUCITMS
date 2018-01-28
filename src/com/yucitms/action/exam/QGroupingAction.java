package com.yucitms.action.exam;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.yucitms.action.BaseAction;
import com.yucitms.orm.exam.Classify;
import com.yucitms.orm.exam.Grouping;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;
/**
 * 试题分组
 * @author qiangzi
 *
 */
public class QGroupingAction extends BaseAction<Grouping>{
	/**
	 * 列表
	 * @return
	 */
	public String getGroupingList(){
		HqlHelper hqlHelper = new HqlHelper(Grouping.class,"c").addOrderByProperty("id", false);
		PageBean bean=groupingService.getGroupingList(pageNum, 10, hqlHelper);
		ActionContext.getContext().getValueStack().push(bean);
		return "getGroupingList";
	}
	/**
	 * 添加
	 * @return
	 */
	public String addGroupingPage(){
		return "addGroupingPage";
	}
	
	public String addGrouping(){
		model.setState(true);
		model.setCreateDate(new Date());
		groupingService.addGrouping(model);
		return "GroupingList";
	}
	/**
	 * 修改
	 * @return
	 */
	public String updateGroupingPage(){
		Grouping grouping=groupingService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(grouping);
		return "updateGroupingPage";
	}
	
	public String updateGrouping(){
		Grouping grouping=groupingService.getById(model.getId());
		grouping.setGrouping(model.getGrouping());
		groupingService.updateGrouping(grouping);
		return "GroupingList";
	}
	/**
	 * 禁用
	 */
	/**
	 * 禁用
	 */
	public String  disableGrouping(){
		Grouping grouping=groupingService.getById(model.getId());
		grouping.setState(false);
		groupingService.updateGrouping(grouping);
		return "GroupingList";
	}
	/**
	 * 启用
	 */
	public String enabledGrouping(){
		Grouping grouping=groupingService.getById(model.getId());
		grouping.setState(true);
		groupingService.updateGrouping(grouping);
		return "GroupingList";
	}
}
