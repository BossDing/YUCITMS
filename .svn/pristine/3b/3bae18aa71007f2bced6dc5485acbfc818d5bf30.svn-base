package com.yucitms.service.impl.exam;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.yucitms.action.exam.QuestionsConfig;
import com.yucitms.dao.BaseDao;
import com.yucitms.orm.exam.ExamPaper;
import com.yucitms.orm.exam.Questions;
import com.yucitms.orm.exam.QuestionsGrouping;
import com.yucitms.service.BaseService;
import com.yucitms.service.BaseServiceImpl;
import com.yucitms.service.exam.ExamPaperService;
import com.yucitms.util.ChangePlainText;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

/**
 * 试卷
 * @author qiangzi
 *
 */
public class ExamPaperServiceImpl extends BaseServiceImpl implements ExamPaperService {

	@Override
	public PageBean getExamPaperList(int pageNum, int Pagesize,
			HqlHelper hqlHelper) {
		// TODO Auto-generated method stub
		return getExamPaperDAO().getPageBean(pageNum, Pagesize, hqlHelper);
	}

	@Override
	public void addExamPaper(ExamPaper examPaper) {
		// TODO Auto-generated method stub
		getExamPaperDAO().save(examPaper);
	}

	@Override
	public void deleteExamPaper(Integer id) {
		// TODO Auto-generated method stub
		getExamPaperDAO().delete(id);
	}

	@Override
	public void updateExamPaper(ExamPaper examPaper) {
		// TODO Auto-generated method stub
		getExamPaperDAO().update(examPaper);
	}

	@Override
	public ExamPaper getById(Integer id) {
		// TODO Auto-generated method stub
		return getExamPaperDAO().getById(id);
	}

	@Override
	public List<ExamPaper> findEnabled() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exportPaper(OutputStream out, Integer id) {
		//System.out.println("试卷Id"+id);
		XWPFDocument doc = new XWPFDocument();  
		
		ExamPaper examPaper= getExamPaperDAO().getById(id);
		//标题 居中
		XWPFParagraph p3 = doc.createParagraph();  
		XWPFRun r2 = p3.createRun(); 
		r2.setFontSize(18);
		r2.setBold(true);
		r2.setText(examPaper.getPaperName());
		r2.addCarriageReturn();
		r2.addCarriageReturn();
		r2.addCarriageReturn();
		//试卷内容
		
		p3.setWordWrap(true);  
		p3.setPageBreak(true);  //分页符
		XWPFRun r4 = p3.createRun();  
		p3.setAlignment(ParagraphAlignment.LEFT);
		
		String hql="from QuestionsGrouping where examPaper.id=? order by index ASC";
		List<QuestionsGrouping> groupings= getExamPaperDAO().getSession().createQuery(hql).setParameter(0, id).list();
	//	System.out.println("试卷结构数"+groupings.size());
		for(int i=0;i<groupings.size();i++){
			QuestionsGrouping questionsGrouping= groupings.get(i);
			//大题标题
			r4.addCarriageReturn();
			r4.addCarriageReturn();
			r4.setText(questionsGrouping.getName());
			r4.addCarriageReturn();
			r4.addCarriageReturn();
			//XWPFRun r4 = p3.createRun();  
			hql="from Questions where questionsGrouping.id="+questionsGrouping.getId()+"order by code ASC";
			List<Questions> questions=getExamPaperDAO().getSession().createQuery(hql).list();
		//	System.out.println("试题数"+questions.size());
			for(int j=0;j<questions.size();j++){
				Questions question = questions.get(j);
				if(question.getType().equals(QuestionsConfig.TIANKONG)){
					r4.setText((j+1)+"."+ChangePlainText.Html2Text(question.getQuestions()));
		        	r4.addCarriageReturn();
		        	r4.setText("答案："+ChangePlainText.Html2Text(question.getAnswer()));
		        	r4.addCarriageReturn();
		        	r4.setText("解析："+ChangePlainText.Html2Text(question.getAnswer()));
		        	r4.addCarriageReturn();
		        	r4.setText("分值："+question.getFenzhi());
		        	r4.addCarriageReturn();
		        	r4.addCarriageReturn();
				}else if(question.getType().equals(QuestionsConfig.DANXUAN)||question.getType().equals(QuestionsConfig.DUOXUAN)){
					r4.setText((j+1)+"."+ChangePlainText.Html2Text(question.getQuestions()));
		        	r4.addCarriageReturn();
		        	r4.setText("A."+question.getA());
		        	r4.addCarriageReturn();
		        	r4.setText("B."+question.getB());
		        	r4.addCarriageReturn();
		        	r4.setText("C."+question.getC());
		        	r4.addCarriageReturn();
		        	r4.setText("D."+question.getD());
		        	r4.addCarriageReturn();
		        	r4.setText("答案："+ChangePlainText.Html2Text(question.getAnswer()));
		        	r4.addCarriageReturn();
		        	r4.setText("解析："+ChangePlainText.Html2Text(question.getParse()));
		        	r4.addCarriageReturn();
		        	r4.setText("分值："+question.getFenzhi());
		        	r4.addCarriageReturn();
		        	r4.addCarriageReturn();
				}else if(question.getType().equals(QuestionsConfig.PANDUAN)){
					r4.setText((j+1)+"."+ChangePlainText.Html2Text(question.getQuestions()));
		        	r4.addCarriageReturn();
		        	r4.setText("答案："+question.getAnswer_pd());
		        	r4.addCarriageReturn();
		        	r4.setText("解析："+ChangePlainText.Html2Text(question.getParse()));
		        	r4.addCarriageReturn();
		        	r4.setText("分值："+question.getFenzhi());
		        	r4.addCarriageReturn();
		        	r4.addCarriageReturn();
				}else if(question.getType().equals(QuestionsConfig.JIANDA)){
					r4.setText((j+1)+"."+ChangePlainText.Html2Text(question.getQuestions()));
		        	r4.addCarriageReturn();
		        	r4.setText("答案："+ChangePlainText.Html2Text(question.getAnswer()));
		        	r4.addCarriageReturn();
		        	r4.setText("解析："+ChangePlainText.Html2Text(question.getParse()));
		        	r4.addCarriageReturn();
		        	r4.setText("分值："+question.getFenzhi());
		        	r4.addCarriageReturn();
		        	r4.addCarriageReturn();
				}
			     }
			
		}
		try {
			doc.write(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void batchEnabledOrDisable(String type, Integer[] ids) {
		String hql="update ExamPaper set state=? where id in (:ids)";
		if(type.equals(QuestionsConfig.UTYPE_Disable)){
			getExamPaperDAO().getSession().createQuery(hql).setParameter(0, false).setParameterList("ids", ids).executeUpdate();
		}else{
			getExamPaperDAO().getSession().createQuery(hql).setParameter(0, true).setParameterList("ids", ids).executeUpdate();
		}
		
	}
	
}
