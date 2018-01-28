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
import com.yucitms.orm.exam.Questions_PanDuan;
import com.yucitms.orm.exam.Questions_TianKong;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.exam.Questions_TianKongService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 填空题
 * @author qiangzi
 *
 */
public class Questions_TianKongServiceImpl  extends BaseServiceImpl implements Questions_TianKongService{

	@Override
	public PageBean getQuestions_TianKongList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		// TODO Auto-generated method stub
		return getTianKongDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addQuestions_TianKong(Questions_TianKong questions_TianKong) {
		// TODO Auto-generated method stub
		getTianKongDAO().save(questions_TianKong);
	}

	@Override
	public void deleteQuestions_TianKong(Integer id) {
		// TODO Auto-generated method stub
		getTianKongDAO().delete(id);
	}

	@Override
	public void updateQuestions_TianKong(Questions_TianKong questions_TianKong) {
		// TODO Auto-generated method stub
		getTianKongDAO().update(questions_TianKong);
	}

	@Override
	public Questions_TianKong getById(Integer id) {
		// TODO Auto-generated method stub
		return getTianKongDAO().getById(id);
	}

	@Override
	public void batchEnabled(Integer[] ids) {
		String HQL="update Questions_TianKong set state=true where id in (:ids)";
		getTianKongDAO().getSession().createQuery(HQL).setParameterList("ids", ids).executeUpdate();
	}

	@Override
	public void batchDisable(Integer[] ids) {
		String HQL="update Questions_TianKong set state=false where id in (:ids)";
		getTianKongDAO().getSession().createQuery(HQL).setParameterList("ids", ids).executeUpdate();
		
	}

	@Override
	public void batchDelete(Integer[] ids) {
		String HQL="delete Questions_TianKong where id in (:ids)";
		getTianKongDAO().getSession().createQuery(HQL).setParameterList("ids", ids).executeUpdate();
		
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
        	
        	List<Questions_TianKong> tianKongs=getTianKongDAO().findAll();
        	
	        for (int i = 0; i < tianKongs.size(); i++) {
	        	Questions_TianKong tianKong=tianKongs.get(i);
	        	r4.setText((i+1)+"."+tianKong.getQuestions_TK());
	        	r4.addCarriageReturn();
	        	r4.setText("答案："+tianKong.getAnswer_TK());
	        	r4.addCarriageReturn();
	        	r4.setText("解析："+tianKong.getAnswer_TK());
	        	r4.addCarriageReturn();
	        	r4.addCarriageReturn();
			}
        }else{
        	List<Questions_TianKong> tianKongs=getTianKongDAO().getByIds(ids);
        	
	        for (int i = 0; i < tianKongs.size(); i++) {
	        	Questions_TianKong tianKong=tianKongs.get(i);
	        	r4.setText((i+1)+"."+tianKong.getQuestions_TK());
	        	r4.addCarriageReturn();
	        	r4.setText("答案："+tianKong.getAnswer_TK());
	        	r4.addCarriageReturn();
	        	r4.setText("解析："+tianKong.getAnswer_TK());
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
