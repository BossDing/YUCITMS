package com.yucitms.action.exam;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.yucitms.action.BaseAction;
import com.yucitms.orm.exam.Classify;
import com.yucitms.orm.exam.PaperClassify;
import com.yucitms.orm.exam.PaperSource;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;


public class PaperClassifyAction extends BaseAction<PaperClassify>{
	/**
	 * 列表
	 * @return
	 */
	public String getPaperClassifyList(){
		HqlHelper hqlHelper = new HqlHelper(PaperClassify.class,"c").addOrderByProperty("id", false);
		PageBean bean=paperClassifyService.getPaperClassifyList(pageNum, 10, hqlHelper);
		ActionContext.getContext().getValueStack().push(bean);
		return "getPaperClassifyList";
	}
	/**
	 * 添加
	 * @return
	 */
	public String addPaperClassifyPage(){
		return "addPaperClassifyPage";
	}
	
	public String addPaperClassify(){
		model.setCreateDate(new Date());
		model.setState(true);
		paperClassifyService.addPaperClassify(model);
		return "PaperClassifyList";
	}
	/**
	 * 修改
	 * @return
	 */
	public String updatePaperClassifyPage(){
		ActionContext.getContext().getValueStack().push(paperClassifyService.getById(model.getId()));
		return "updatePaperClassifyPage";
	}
	
	public String updatePaperClassify(){
		PaperClassify PaperClassify= paperClassifyService.getById(model.getId());
		PaperClassify.setPaperClassify(model.getPaperClassify());
		paperClassifyService.updatePaperClassify(PaperClassify);
		return "PaperClassifyList";
	}
	/**
	 * 禁用
	 */
	public String  disablePaperClassify(){
		PaperClassify PaperClassify= paperClassifyService.getById(model.getId());
		PaperClassify.setState(false);
		paperClassifyService.updatePaperClassify(PaperClassify);
		return "PaperClassifyList";
	}
	/**
	 * 启用
	 */
	public String enabledPaperClassify(){
		PaperClassify PaperClassify= paperClassifyService.getById(model.getId());
		PaperClassify.setState(true);
		paperClassifyService.updatePaperClassify(PaperClassify);
		return "PaperClassifyList";
	}
}
