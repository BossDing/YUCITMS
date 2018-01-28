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
import com.yucitms.orm.exam.Questions_DuoXuan;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.exam.Questions_DuoXuanService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 多选
 * @author qiangzi
 *
 */
public class Questions_DuoXuanServiceImpl extends BaseServiceImpl implements Questions_DuoXuanService{

	@Override
	public PageBean getQuestions_DuoXuanList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		// TODO Auto-generated method stub
		return getDuoXuanDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addQuestions_DuoXuan(Questions_DuoXuan questions_DuoXuan) {
		// TODO Auto-generated method stub
		getDuoXuanDAO().save(questions_DuoXuan);
	}

	@Override
	public void deleteQuestions_DuoXuan(Integer id) {
		// TODO Auto-generated method stub
		getDuoXuanDAO().delete(id);
	}

	@Override
	public void updateQuestions_DuoXuan(Questions_DuoXuan questions_DuoXuan) {
		// TODO Auto-generated method stub
		getDuoXuanDAO().update(questions_DuoXuan);
	}

	@Override
	public Questions_DuoXuan getById(Integer id) {
		// TODO Auto-generated method stub
		return getDuoXuanDAO().getById(id);
	}

	@Override
	public void batchEnabled(Integer[] ids) {
		String HQL="update Questions_DuoXuan set state=true where id in (:ids)";
		getDuoXuanDAO().getSession().createQuery(HQL).setParameterList("ids", ids).executeUpdate();
	}

	@Override
	public void batchDisable(Integer[] ids) {
		String HQL="update Questions_DuoXuan set state=false where id in (:ids)";
		getDuoXuanDAO().getSession().createQuery(HQL).setParameterList("ids", ids).executeUpdate();
		
	}

	@Override
	public void batchDelete(Integer[] ids) {
		String HQL="delete Questions_DuoXuan where id in (:ids)";
		getDuoXuanDAO().getSession().createQuery(HQL).setParameterList("ids", ids).executeUpdate();
		
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
        	List<Questions_DuoXuan> duoXuans=getDuoXuanDAO().findAll();
	        for (int i = 0; i < duoXuans.size(); i++) {
	        	Questions_DuoXuan duoXuan=duoXuans.get(i);
	        	r4.setText((i+1)+"."+duoXuan.getQuestions_DXS());
	        	r4.addCarriageReturn();
	        	r4.setText("A."+duoXuan.getA());
	        	r4.addCarriageReturn();
	        	r4.setText("B."+duoXuan.getB());
	        	r4.addCarriageReturn();
	        	r4.setText("C."+duoXuan.getC());
	        	r4.addCarriageReturn();
	        	r4.setText("D."+duoXuan.getD());
	        	r4.addCarriageReturn();
	        	r4.setText("答案："+duoXuan.getAnswer_DXS());
	        	r4.addCarriageReturn();
	        	r4.setText("解析："+duoXuan.getParse());
	        	r4.addCarriageReturn();
	        	r4.addCarriageReturn();
			}
        }else{
        	List<Questions_DuoXuan> duoXuans=getDuoXuanDAO().getByIds(ids);
	        for (int i = 0; i < duoXuans.size(); i++) {
	        	Questions_DuoXuan duoXuan=duoXuans.get(i);
	        	r4.setText((i+1)+"."+duoXuan.getQuestions_DXS());
	        	r4.addCarriageReturn();
	        	r4.setText("A."+duoXuan.getA());
	        	r4.addCarriageReturn();
	        	r4.setText("B."+duoXuan.getB());
	        	r4.addCarriageReturn();
	        	r4.setText("C."+duoXuan.getC());
	        	r4.addCarriageReturn();
	        	r4.setText("D."+duoXuan.getD());
	        	r4.addCarriageReturn();
	        	r4.setText("答案："+duoXuan.getAnswer_DXS());
	        	r4.addCarriageReturn();
	        	r4.setText("解析："+duoXuan.getParse());
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
