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
import com.yucitms.orm.exam.Questions_JianDa;
import com.yucitms.orm.exam.Questions_PanDuan;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.exam.Questions_JianDaService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 简答题
 * @author qiangzi
 *
 */
public class Questions_JianDaServiceImpl extends BaseServiceImpl implements Questions_JianDaService{

	@Override
	public PageBean getQuestions_JianDaList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		// TODO Auto-generated method stub
		return getJianDaDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addQuestions_JianDa(Questions_JianDa questions_JianDa) {
		// TODO Auto-generated method stub
		getJianDaDAO().save(questions_JianDa);
	}

	@Override
	public void deleteQuestions_JianDa(Integer id) {
		// TODO Auto-generated method stub
		getJianDaDAO().delete(id);
	}

	@Override
	public void updateQuestions_JianDa(Questions_JianDa questions_JianDa) {
		// TODO Auto-generated method stub
		getJianDaDAO().update(questions_JianDa);
	}

	@Override
	public Questions_JianDa getById(Integer id) {
		// TODO Auto-generated method stub
		return getJianDaDAO().getById(id);
	}

	@Override
	public void batchEnabled(Integer[] ids) {
		String HQL="update Questions_JianDa set state=true where id in (:ids)";
		getJianDaDAO().getSession().createQuery(HQL).setParameterList("ids", ids).executeUpdate();
	}

	@Override
	public void batchDisable(Integer[] ids) {
		String HQL="update Questions_JianDa set state=false where id in (:ids)";
		getJianDaDAO().getSession().createQuery(HQL).setParameterList("ids", ids).executeUpdate();
		
	}

	@Override
	public void batchDelete(Integer[] ids) {
		String HQL="delete Questions_JianDa where id in (:ids)";
		getJianDaDAO().getSession().createQuery(HQL).setParameterList("ids", ids).executeUpdate();
		
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
        	
        	List<Questions_JianDa> jianDas=getJianDaDAO().findAll();
        	
	        for (int i = 0; i < jianDas.size(); i++) {
	        	Questions_JianDa jianDa=jianDas.get(i);
	        	r4.setText((i+1)+"."+jianDa.getQuestions_JD());
	        	r4.addCarriageReturn();
	        	r4.setText("答案："+jianDa.getAnswer_JD());
	        	r4.addCarriageReturn();
	        	r4.setText("解析："+jianDa.getParse());
	        	r4.addCarriageReturn();
	        	r4.addCarriageReturn();
			}
        }else{
        	List<Questions_JianDa> jianDas=getJianDaDAO().getByIds(ids);
        	
	        for (int i = 0; i < jianDas.size(); i++) {
	        	Questions_JianDa jianDa=jianDas.get(i);
	        	r4.setText((i+1)+"."+jianDa.getQuestions_JD());
	        	r4.addCarriageReturn();
	        	r4.setText("答案："+jianDa.getAnswer_JD());
	        	r4.addCarriageReturn();
	        	r4.setText("解析："+jianDa.getParse());
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
