package com.yucitms.action.exam;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.yucitms.action.BaseAction;
import com.yucitms.orm.exam.Classify;
import com.yucitms.orm.exam.Source;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;
/**
 * 试题来源
 * @author qiangzi
 *
 */
public class QSourceAction extends BaseAction<Source>{
	/**
	 * 列表
	 * @return
	 */
	public String getSourceList(){
		HqlHelper hqlHelper = new HqlHelper(Source.class,"c").addOrderByProperty("id", false);
		PageBean bean=sourceService.getSourceList(pageNum, 10, hqlHelper);
		ActionContext.getContext().getValueStack().push(bean);
		return "getSourceList";
	}
	/**
	 * 添加
	 * @return
	 */
	public String addSourcePage(){
		return "addSourcePage";
	}
	
	public String addSource(){
		model.setState(true);
		model.setCreateDate(new Date());
		sourceService.addSource(model);
		return "SourceList";
	}
	/**
	 * 修改
	 * @return
	 */
	public String updateSourcePage(){
		Source source=sourceService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(source);
		return "updateSourcePage";
	}
	
	public String updateSource(){
		Source source=sourceService.getById(model.getId());
		source.setSource(model.getSource());
		sourceService.updateSource(source);
		return "SourceList";
	}
	/**
	 * 禁用
	 */
	public String  disableSource(){
		Source source= sourceService.getById(model.getId());
		source.setState(false);
		sourceService.updateSource(source);
		return "SourceList";
	}
	/**
	 * 启用
	 */
	public String enabledSource(){
		Source source= sourceService.getById(model.getId());
		source.setState(true);
		sourceService.updateSource(source);
		return "SourceList";
	}
}
