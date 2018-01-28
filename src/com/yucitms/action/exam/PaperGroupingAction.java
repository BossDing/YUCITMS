package com.yucitms.action.exam;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.yucitms.action.BaseAction;
import com.yucitms.orm.exam.PaperGrouping;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;


public class PaperGroupingAction extends BaseAction<PaperGrouping>{
	/**
	 * 列表
	 * @return
	 */
	public String getPaperGroupingList(){
		HqlHelper hqlHelper = new HqlHelper(PaperGrouping.class,"c").addOrderByProperty("id", false);
		PageBean bean=paperGroupingService.getPaperGroupingList(pageNum, 10, hqlHelper);
		ActionContext.getContext().getValueStack().push(bean);
		return "getPaperGroupingList";
	}
	/**
	 * 添加
	 * @return
	 */
	public String addPaperGroupingPage(){
		return "addPaperGroupingPage";
	}
	
	public String addPaperGrouping(){
		model.setCreateDate(new Date());
		model.setState(true);
		paperGroupingService.addPaperGrouping(model);
		return "PaperGroupingList";
	}
	/**
	 * 修改
	 * @return
	 */
	public String updatePaperGroupingPage(){
		ActionContext.getContext().getValueStack().push(paperGroupingService.getById(model.getId()));
		return "updatePaperGroupingPage";
	}
	
	public String updatePaperGrouping(){
		PaperGrouping PaperGrouping= paperGroupingService.getById(model.getId());
		PaperGrouping.setPaperGrouping(model.getPaperGrouping());
		paperGroupingService.updatePaperGrouping(PaperGrouping);
		return "PaperGroupingList";
	}
	/**
	 * 禁用
	 */
	public String  disablePaperGrouping(){
		PaperGrouping PaperGrouping= paperGroupingService.getById(model.getId());
		PaperGrouping.setState(false);
		paperGroupingService.updatePaperGrouping(PaperGrouping);
		return "PaperGroupingList";
	}
	/**
	 * 启用
	 */
	public String enabledPaperGrouping(){
		PaperGrouping PaperGrouping= paperGroupingService.getById(model.getId());
		PaperGrouping.setState(true);
		paperGroupingService.updatePaperGrouping(PaperGrouping);
		return "PaperGroupingList";
	}
}
