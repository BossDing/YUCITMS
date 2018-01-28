package com.yucitms.action.exam;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.yucitms.action.BaseAction;
import com.yucitms.orm.exam.PaperSource;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;


public class PaperSourceAction extends BaseAction<PaperSource>{
	/**
	 * 列表
	 * @return
	 */
	public String getPaperSourceList(){
		HqlHelper hqlHelper = new HqlHelper(PaperSource.class,"c").addOrderByProperty("id", false);
		PageBean bean=paperSourceService.getPaperSourceList(pageNum, 10, hqlHelper);
		ActionContext.getContext().getValueStack().push(bean);
		return "getPaperSourceList";
	}
	/**
	 * 添加
	 * @return
	 */
	public String addPaperSourcePage(){
		return "addPaperSourcePage";
	}
	
	public String addPaperSource(){
		model.setCreateDate(new Date());
		model.setState(true);
		paperSourceService.addPaperSource(model);
		return "PaperSourceList";
	}
	/**
	 * 修改
	 * @return
	 */
	public String updatePaperSourcePage(){
		ActionContext.getContext().getValueStack().push(paperSourceService.getById(model.getId()));
		return "updatePaperSourcePage";
	}
	
	public String updatePaperSource(){
		PaperSource PaperSource= paperSourceService.getById(model.getId());
		PaperSource.setPaperSource(model.getPaperSource());
		paperSourceService.updatePaperSource(PaperSource);
		return "PaperSourceList";
	}
	/**
	 * 禁用
	 */
	public String  disablePaperSource(){
		PaperSource PaperSource= paperSourceService.getById(model.getId());
		PaperSource.setState(false);
		paperSourceService.updatePaperSource(PaperSource);
		return "PaperSourceList";
	}
	/**
	 * 启用
	 */
	public String enabledPaperSource(){
		PaperSource PaperSource= paperSourceService.getById(model.getId());
		PaperSource.setState(true);
		paperSourceService.updatePaperSource(PaperSource);
		return "PaperSourceList";
	}
}
