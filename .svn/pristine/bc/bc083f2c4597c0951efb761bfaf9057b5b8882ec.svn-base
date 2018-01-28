package com.yucitms.service.impl.exam;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.Questions_DanXuan;
import com.yucitms.orm.exam.Questions_PanDuan;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.exam.Questions_PanDuanService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 判断题
 * @author qiangzi
 *
 */
public class Questions_PanDuanServiceImpl  extends BaseServiceImpl implements Questions_PanDuanService{

	@Override
	public PageBean getQuestions_PanDuanList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		// TODO Auto-generated method stub
		return getPanDuanDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addQuestions_PanDuan(Questions_PanDuan questions_PanDuan) {
		// TODO Auto-generated method stub
		getPanDuanDAO().save(questions_PanDuan);
	}

	@Override
	public void deleteQuestions_PanDuan(Integer id) {
		// TODO Auto-generated method stub
		getPanDuanDAO().delete(id);
	}

	@Override
	public void updateQuestions_PanDuan(Questions_PanDuan questions_PanDuan) {
		// TODO Auto-generated method stub
		getPanDuanDAO().update(questions_PanDuan);
	}

	@Override
	public Questions_PanDuan getById(Integer id) {
		// TODO Auto-generated method stub
		return getPanDuanDAO().getById(id);
	}

	@Override
	public void batchEnabled(Integer[] ids) {
		String HQL="update Questions_PanDuan set state=true where id in (:ids)";
		getPanDuanDAO().getSession().createQuery(HQL).setParameterList("ids", ids).executeUpdate();
	}

	@Override
	public void batchDisable(Integer[] ids) {
		String HQL="update Questions_PanDuan set state=false where id in (:ids)";
		getPanDuanDAO().getSession().createQuery(HQL).setParameterList("ids", ids).executeUpdate();
		
	}

	@Override
	public void batchDelete(Integer[] ids) {
		String HQL="delete Questions_PanDuan where id in (:ids)";
		getPanDuanDAO().getSession().createQuery(HQL).setParameterList("ids", ids).executeUpdate();
		
	}

	@Override
	public void exprotQuestion(OutputStream out, Integer[] ids) {
		XWPFDocument doc = new XWPFDocument();  
        XWPFParagraph p3 = doc.createParagraph();  
        p3.setWordWrap(true);  
        p3.setPageBreak(true);  //分页符
        XWPFRun r4 = p3.createRun();  
        p3.setAlignment(ParagraphAlignment.LEFT); 
        if(ids==null||ids.length==0){//导出全部
        	
        	List<Questions_PanDuan> panDuans=getPanDuanDAO().findAll();
        	
	        for (int i = 0; i < panDuans.size(); i++) {
	        	Questions_PanDuan panDuan=panDuans.get(i);
	        	r4.setText((i+1)+"."+panDuan.getQuestions_PD());
	        	r4.addCarriageReturn();
	        	r4.setText("答案："+panDuan.getAnswer_PD());
	        	r4.addCarriageReturn();
	        	r4.setText("解析："+panDuan.getParse());
	        	r4.addCarriageReturn();
	        	r4.addCarriageReturn();
			}
        }else{
        	List<Questions_PanDuan> panDuans=getPanDuanDAO().getByIds(ids);
        	
	        for (int i = 0; i < panDuans.size(); i++) {
	        	Questions_PanDuan panDuan=panDuans.get(i);
	        	r4.setText((i+1)+"."+panDuan.getQuestions_PD());
	        	r4.addCarriageReturn();
	        	r4.setText("答案："+panDuan.getAnswer_PD());
	        	r4.addCarriageReturn();
	        	r4.setText("解析："+panDuan.getParse());
	        	r4.addCarriageReturn();
	        	r4.addCarriageReturn();
			}
        }
	   
        try {
			doc.write(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	
	
}
