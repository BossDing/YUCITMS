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
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.exam.Questions_DanXuanService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 单选
 * @author qiangzi
 *
 */
public class Questions_DanXuanServiceImpl extends BaseServiceImpl implements Questions_DanXuanService{

	@Override
	public PageBean getQuestions_DanXuanList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		// TODO Auto-generated method stub
		return getDanXuanDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addQuestions_DanXuan(Questions_DanXuan questions_DanXuan) {
		// TODO Auto-generated method stub
		getDanXuanDAO().save(questions_DanXuan);
	}

	@Override
	public void deleteQuestions_DanXuan(Integer id) {
		// TODO Auto-generated method stub
		getDanXuanDAO().delete(id);
	}

	@Override
	public void updateQuestions_DanXuan(Questions_DanXuan questions_DanXuan) {
		// TODO Auto-generated method stub
		getDanXuanDAO().update(questions_DanXuan);
	}

	@Override
	public Questions_DanXuan getById(Integer id) {
		// TODO Auto-generated method stub
		return getDanXuanDAO().getById(id);
	}

	@Override
	public void batchEnabled(Integer[] ids) {
		String HQL="update Questions_DanXuan set state=true where id in (:ids)";
		getDanXuanDAO().getSession().createQuery(HQL).setParameterList("ids", ids).executeUpdate();
	}

	@Override
	public void batchDisable(Integer[] ids) {
		String HQL="update Questions_DanXuan set state=false where id in (:ids)";
		getDanXuanDAO().getSession().createQuery(HQL).setParameterList("ids", ids).executeUpdate();
		
	}

	@Override
	public void batchDelete(Integer[] ids) {
		String HQL="delete Questions_DanXuan where id in (:ids)";
		getDanXuanDAO().getSession().createQuery(HQL).setParameterList("ids", ids).executeUpdate();
		
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
	        	List<Questions_DanXuan> danXuans=getDanXuanDAO().findAll();
		        for (int i = 0; i < danXuans.size(); i++) {
		        	Questions_DanXuan danXuan=danXuans.get(i);
		        	r4.setText((i+1)+"."+danXuan.getQuestions_DX());
		        	r4.addCarriageReturn();
		        	r4.setText("A."+danXuan.getA());
		        	r4.addCarriageReturn();
		        	r4.setText("B."+danXuan.getB());
		        	r4.addCarriageReturn();
		        	r4.setText("C."+danXuan.getC());
		        	r4.addCarriageReturn();
		        	r4.setText("D."+danXuan.getD());
		        	r4.addCarriageReturn();
		        	r4.setText("答案："+danXuan.getAnswer_DX());
		        	r4.addCarriageReturn();
		        	r4.setText("解析："+danXuan.getParse());
		        	r4.addCarriageReturn();
		        	r4.addCarriageReturn();
				}
	        }else{
	        	List<Questions_DanXuan> danXuans=getDanXuanDAO().getByIds(ids);
		        for (int i = 0; i < danXuans.size(); i++) {
		        	Questions_DanXuan danXuan=danXuans.get(i);
		        	r4.setText((i+1)+"."+danXuan.getQuestions_DX());
		        	r4.addCarriageReturn();
		        	r4.setText("A."+danXuan.getA());
		        	r4.addCarriageReturn();
		        	r4.setText("B."+danXuan.getB());
		        	r4.addCarriageReturn();
		        	r4.setText("C."+danXuan.getC());
		        	r4.addCarriageReturn();
		        	r4.setText("D."+danXuan.getD());
		        	r4.addCarriageReturn();
		        	r4.setText("答案："+danXuan.getAnswer_DX());
		        	r4.addCarriageReturn();
		        	r4.setText("解析："+danXuan.getParse());
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
