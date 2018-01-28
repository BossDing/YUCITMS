package com.yucitms.action.exam;



import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.yucitms.action.BaseAction;
import com.yucitms.orm.exam.Classify;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试题分类属性
 * @author qiangzi
 *
 */
public class QClassifyAction extends BaseAction<Classify>{
	/**
	 * 列表
	 * @return
	 */
	public String getClassifyList(){
		HqlHelper hqlHelper = new HqlHelper(Classify.class,"c").addOrderByProperty("id", false);
		PageBean bean=classifyService.getClassifyList(pageNum, 10, hqlHelper);
		ActionContext.getContext().getValueStack().push(bean);
		return "getClassifyList";
	}
	/**
	 * 添加
	 * @return
	 */
	public String addClassifyPage(){
		return "addClassifyPage";
	}
	
	public String addClassify(){
		model.setCreateDate(new Date());
		model.setState(true);
		classifyService.addClassify(model);
		return "classifyList";
	}
	/**
	 * 修改
	 * @return
	 */
	public String updateClassifyPage(){
		ActionContext.getContext().getValueStack().push(classifyService.getById(model.getId()));
		return "updateClassifyPage";
	}
	
	public String updateclassify(){
		Classify classify= classifyService.getById(model.getId());
		classify.setClassify(model.getClassify());
		classifyService.updateClassify(classify);
		return "classifyList";
	}
	/**
	 * 禁用
	 */
	public String  disableClassify(){
		Classify classify= classifyService.getById(model.getId());
		classify.setState(false);
		classifyService.updateClassify(classify);
		return "classifyList";
	}
	/**
	 * 启用
	 */
	public String enabledClassify(){
		Classify classify= classifyService.getById(model.getId());
		classify.setState(true);
		classifyService.updateClassify(classify);
		return "classifyList";
	}
}
