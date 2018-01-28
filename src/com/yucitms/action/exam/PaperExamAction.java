package com.yucitms.action.exam;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.yucitms.action.BaseAction;
import com.yucitms.orm.exam.Classify;
import com.yucitms.orm.exam.Difficulty;
import com.yucitms.orm.exam.ExamPaper;
import com.yucitms.orm.exam.PaperClassify;
import com.yucitms.orm.exam.PaperGrouping;
import com.yucitms.orm.exam.PaperSource;
import com.yucitms.orm.exam.Questions;
import com.yucitms.orm.exam.QuestionsGrouping;
import com.yucitms.orm.exam.Questions_DanXuan;
import com.yucitms.orm.exam.Questions_DuoXuan;
import com.yucitms.orm.exam.Questions_JianDa;
import com.yucitms.orm.exam.Questions_PanDuan;
import com.yucitms.orm.exam.Questions_TianKong;
import com.yucitms.orm.exam.Source;
import com.yucitms.orm.school.Teacher;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;

public class PaperExamAction extends BaseAction<ExamPaper> {
	private String[] jiegou;
	private int[] index;
	private Integer pclassifyId;
	private Integer pgroupingId;
	private Integer psourceId;
	private Integer qgroupingId;// 大题分组
	private Integer questionId;// 问题id
	private Integer paperId;// 试卷ID
	private Integer questionIds[];
	private float fenzhi[];
	private float sumScore;
	// /////////////////////试题列表//////////////////////////
	private Integer difficultyId;// 难度
	private Integer classifyId;// 分类
	private Integer groupingId;// 分组
	private Integer sourceId;// 来源
	private String questionContent;// 问题
	private String questionType;// 问题类型
	private boolean state;// 状态
	private Integer id;// 试题编号
	private String qtype;// 试题类型
	private Classify classify;
	/**
	 * 试卷列表
	 */
	private Integer paperClassifieId;
	private Integer paperGroupingId;
	private Integer paperSourceId;
	private boolean paperstate=true;
    private String utype;//批量操作类型
    private Integer ids[];//批量操作id
    
	public String getPaperList() {
		List<PaperClassify> paperClassifies = paperClassifyService
				.findEnabled();
		List<PaperGrouping> paperGroupings = paperGroupingService.findEnabled();
		List<PaperSource> paperSources = paperSourceService.findEnabled();
		ActionContext.getContext().put("paperClassifies", paperClassifies);
		ActionContext.getContext().put("paperGroupings", paperGroupings);
		ActionContext.getContext().put("paperSources", paperSources);
		return "getPaperList";
	}

	/**
	 * 添加试卷基本信息
	 * 
	 * @return
	 */
	public String addPaper1() {
		PaperClassify paperClassify = paperClassifyService.getById(pclassifyId);
		PaperGrouping paperGrouping = paperGroupingService.getById(pgroupingId);
		PaperSource paperSource = paperSourceService.getById(psourceId);
		model.setCreateDate(new Date());
		model.setPaperClassify(paperClassify);
		model.setPaperGrouping(paperGrouping);
		model.setPaperSource(paperSource);
		model.setTeacher(getLoginTeacher());
		Set<QuestionsGrouping> groupings = new HashSet<QuestionsGrouping>();
		if (jiegou != null && jiegou.length != 0 && index != null
				&& index.length != 0) {
			QuestionsGrouping grouping = null;
			for (int i = 0; i < jiegou.length; i++) {
				grouping = new QuestionsGrouping();
				grouping.setName(jiegou[i]);
				grouping.setIndex(index[i]);
				questionsGroupingService.addQuestionsGrouping(grouping);
				groupings.add(grouping);
			}
			model.setQuestionsGroupings(groupings);
		}
		model.setState(true);
		model.setCreateDate(new Date());
		examPaperService.addExamPaper(model);
		ExamPaper examPaper = examPaperService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(examPaper);
		return "addPaper1";
	}

	/**
	 * 试卷添加新结构
	 */
	public String addGrouping() {
		System.out.println("试卷" + paperId);
		ExamPaper examPaper = examPaperService.getById(paperId);
		if (jiegou != null && jiegou.length != 0 && index != null
				&& index.length != 0) {
			QuestionsGrouping grouping = null;
			for (int i = 0; i < jiegou.length; i++) {
				grouping = new QuestionsGrouping();
				grouping.setName(jiegou[i]);
				grouping.setIndex(index[i]);
				grouping.setExamPaper(examPaper);
				questionsGroupingService.addQuestionsGrouping(grouping);
			}
		}
		ActionContext.getContext().getValueStack()
				.push(examPaperService.getById(paperId));
		return "addPaper1";
	}

	/**
	 * 删除分组
	 */
	public String deleteGrouping() {
		Integer id = questionsGroupingService.getById(qgroupingId)
				.getExamPaper().getId();
		questionsGroupingService.deleteQuestionsGrouping(qgroupingId);
		ActionContext.getContext().getValueStack()
				.push(examPaperService.getById(id));
		return "addPaper1";
	}

	/**
	 * 试卷各分组下的试题（查看试题列表，并且可以操作）
	 * 
	 * @return
	 */
	public String selectQuestion() {
		QuestionsGrouping questionsGrouping = questionsGroupingService
				.getById(qgroupingId);
		ActionContext.getContext().getValueStack().push(questionsGrouping);
		sumScore=questionsGrouping.getZongfen();
		return "selectQuestion";
	}

	/**
	 * 查看试卷
	 */
	public String seePaperQuestion() {
		ExamPaper examPaper = examPaperService.getById(paperId);
		ActionContext.getContext().getValueStack().push(examPaper);
		return "addPaper1";
	}

	/**
	 * 添加试题到分组
	 */
	public String addQuestionToGrouping() {
		QuestionsGrouping questionsGrouping = questionsGroupingService
				.getById(qgroupingId);
		Questions questions = new Questions();
		Integer qid = questionsService.findWhere(questionType, questionId,qgroupingId);
		if (questionType.equals(QuestionsConfig.TIANKONG)) {
			if (qid == null) {
				Questions_TianKong questions_TianKong = tianKongService
						.getById(questionId);
				questions.setQuestions(questions_TianKong.getQuestions_TK());
				questions.setAnswer(questions_TianKong.getAnswer_TK());
				questions.setParse(questions_TianKong.getAnswer_TK());
				questions.setType(QuestionsConfig.TIANKONG);
				questions.setQcode(questionId);
			}
		} else if (questionType.equals(QuestionsConfig.DANXUAN)) {
			if (qid == null) {
				Questions_DanXuan danxuan = danXuanService.getById(questionId);
				questions.setQuestions(danxuan.getQuestions_DX());
				questions.setAnswer(danxuan.getAnswer_DX());
				questions.setParse(danxuan.getParse());
				questions.setA(danxuan.getA());
				questions.setB(danxuan.getB());
				questions.setC(danxuan.getC());
				questions.setD(danxuan.getD());
				questions.setType(QuestionsConfig.DANXUAN);
				questions.setQcode(questionId);
			}
		} else if (questionType.equals(QuestionsConfig.DUOXUAN)) {
			if (qid == null) {
				Questions_DuoXuan duoxuan = duoXuanService.getById(questionId);
				questions.setQuestions(duoxuan.getQuestions_DXS());
				questions.setAnswer(duoxuan.getAnswer_DXS());
				questions.setParse(duoxuan.getParse());
				questions.setA(duoxuan.getA());
				questions.setB(duoxuan.getB());
				questions.setC(duoxuan.getC());
				questions.setD(duoxuan.getD());
				questions.setType(QuestionsConfig.DUOXUAN);
				questions.setQcode(questionId);
			}
		} else if (questionType.equals(QuestionsConfig.PANDUAN)) {
			if (qid == null) {
				Questions_PanDuan panduan = panDuanService.getById(questionId);
				questions.setQuestions(panduan.getQuestions_PD());
				questions.setAnswer_pd(panduan.getAnswer_PD());
				questions.setParse(panduan.getParse());
				questions.setType(QuestionsConfig.PANDUAN);
				questions.setQcode(questionId);
			}
		} else if (questionType.equals(QuestionsConfig.JIANDA)) {
			if (qid == null) {
				Questions_JianDa jianda = jianDaService.getById(questionId);
				questions.setQuestions(jianda.getQuestions_JD());
				questions.setAnswer(jianda.getAnswer_JD());
				questions.setParse(jianda.getParse());
				questions.setType(QuestionsConfig.JIANDA);
				questions.setQcode(questionId);
			}
		}
		if (qid == null) {
			questions.setQuestionsGrouping(questionsGrouping);
			questionsService.addQuestions(questions);
		}
		// System.out.println(qgroupingId);
		// System.out.println(questionId);
		try {
			ServletActionContext.getResponse().getWriter().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 取消试题到分组
	 */
	public String unAddQuestionToGrouping() {
		if (!questionType.equals("") && questionType != null) {
			Integer qid = questionsService.findWhere(questionType, questionId,qgroupingId);
			if (qid != null) {
				questionsService.deleteQuestions(qid);
			}
		}
		// System.out.println(qgroupingId);
		// System.out.println(questionId);
		try {
			ServletActionContext.getResponse().getWriter().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 删除试题
	 */
	public String deleteQuestion() {
		questionsService.deleteQuestions(questionId);
		try {
			ServletActionContext.getResponse().getWriter().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 排序试题
	 */
	public String qusetionSort() {
		if (questionIds != null && questionIds.length > 0) {
			for (int i = 0; i < questionIds.length; i++) {
				questionsService.updateIndex(questionIds[i], fenzhi[i], i + 1);
			}
			//求和
			QuestionsGrouping grouping=questionsGroupingService.getById(qgroupingId);
			grouping.setZongfen(sumScore);
			questionsGroupingService.updateQuestionsGrouping(grouping);
			ExamPaper examPaper =examPaperService.getById(grouping.getExamPaper().getId());
			List<QuestionsGrouping> groupings= new ArrayList<QuestionsGrouping>(examPaper.getQuestionsGroupings());
		    float sum=0;
			for(int i=0;i<groupings.size();i++){
				QuestionsGrouping groupingSum=groupings.get(i);
				sum+=groupingSum.getZongfen();
			}
			examPaper.setZongScore(sum);
			examPaperService.updateExamPaper(examPaper);
		}
		return "qusetionSort";
	}

	/**
	 * 导出试卷
	 */
	public String exportPaper() {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			OutputStream out = response.getOutputStream();
			response.setContentType("octets/stream");
			response.addHeader("Content-Disposition",
					"attachment;filename=paper.docx");
			examPaperService.exportPaper(out, paperId);
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 前置要求 加载数据
	 * 
	 * @return
	 */
	public void before() {
		List<PaperClassify> paperClassifies = paperClassifyService
				.findEnabled();
		List<PaperGrouping> paperGroupings = paperGroupingService.findEnabled();
		List<PaperSource> paperSources = paperSourceService.findEnabled();
		ActionContext.getContext().put("paperClassifies", paperClassifies);
		ActionContext.getContext().put("paperGroupings", paperGroupings);
		ActionContext.getContext().put("paperSources", paperSources);
	}

	/**
	 * 列表
	 * 
	 * @return
	 */
	public String getExamPaperList() {
		
		before();
		HqlHelper hqlHelper = new HqlHelper(ExamPaper.class, "e").addWhereCondition("e.teacher.id=?", getLoginTeacher().getId());
		hqlHelper.addWhereCondition(paperId != null, "e.id=?", paperId);
		hqlHelper.addWhereCondition(model.getPaperName() != null
				&& !model.getPaperName().equals(""), "e.paperName like ?", "%"
				+ model.getPaperName() + "%");
		hqlHelper.addWhereCondition(paperClassifieId != null,
				"e.paperClassify.id=?", paperClassifieId);
		hqlHelper.addWhereCondition(paperGroupingId != null,
				"e.paperGrouping.id=?", paperGroupingId);
		hqlHelper.addWhereCondition(paperSourceId != null,
				"e.paperSource.id=?", paperSourceId);
		hqlHelper.addWhereCondition("e.state=?", paperstate);
		hqlHelper.addOrderByProperty("id", false);
		PageBean pageBean = examPaperService.getExamPaperList(pageNum, 10,
				hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "getExamPaperList";
	}
    /**
     * 批量修改试卷 状态
     */
	public String batch(){
		if(utype.equals(QuestionsConfig.UTYPE_Disable)){//禁用
			examPaperService.batchEnabledOrDisable(QuestionsConfig.UTYPE_Disable, ids);
		}else if(utype.equals(QuestionsConfig.UTYPE_Enabled)){//启用
			examPaperService.batchEnabledOrDisable(QuestionsConfig.UTYPE_Enabled, ids);
		}
		return "ExamPaperList";
	}
	/**
	 * 修改试卷属性
	 */
	public String updatePaperPage(){
		 ExamPaper examPaper= examPaperService.getById(paperId);
		 before();
		 paperClassifieId=examPaper.getPaperClassify().getId();
		 paperGroupingId=examPaper.getPaperGrouping().getId();
		 paperSourceId=examPaper.getPaperSource().getId();
		 paperstate=examPaper.isState();
		 ActionContext.getContext().getValueStack().push(examPaper);
		return "updatePaperPage";
	}
	public String updatePaper(){
		 ExamPaper examPaper= examPaperService.getById(paperId);
		 examPaper.setCreateDate(new Date());
		 examPaper.setPaperName(model.getPaperName());
		 examPaper.setJigeScore(model.getJigeScore());
		 examPaper.setState(paperstate);
		 PaperClassify paperClassify = paperClassifyService.getById(pclassifyId);
		 PaperGrouping paperGrouping = paperGroupingService.getById(pgroupingId);
		 PaperSource paperSource = paperSourceService.getById(psourceId);
		 examPaper.setPaperClassify(paperClassify);
		 examPaper.setPaperGrouping(paperGrouping);
		 examPaper.setPaperSource(paperSource);
		 examPaperService.updateExamPaper(examPaper);
		return "ExamPaperList";
	}
	// /////////////////////试题列表//////////////////////////

	/**
	 * 所有试题分类列表 属性
	 */
	private void property() {
		// 查询试题属性
		List<Classify> classifies = classifyService.findEnabled();
		List<Difficulty> difficulties = difficultyService.findEnabled();
		// List<Grouping> groupings= groupingService.findEnabled();
		List<Source> sources = sourceService.findEnabled();
		ActionContext.getContext().put("classifies", classifies);
		ActionContext.getContext().put("difficulties", difficulties);
		// ActionContext.getContext().put("groupings", groupings);
		ActionContext.getContext().put("sources", sources);
	}

	/**
	 * 填空题列表
	 * 
	 * @return
	 */
	public String getTKquestionList() {
		property();
		qtype = QuestionsConfig.TIANKONG;
		HqlHelper helper = new HqlHelper(Questions_TianKong.class, "q").addWhereCondition("q.teacher.id=?", getLoginTeacher().getId());
		helper.addWhereCondition("q.state=?", true);
		PageBean pageBean = tianKongService.getQuestions_TianKongList(pageNum,
				QuestionsConfig.PAGESIZE, helper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "getTKquestionList";
	}

	/**
	 * 单选
	 * 
	 * @return
	 */
	public String getDXquestionList() {
		property();
		qtype = QuestionsConfig.DANXUAN;
		HqlHelper helper = new HqlHelper(Questions_DanXuan.class, "q").addWhereCondition("q.teacher.id=?", getLoginTeacher().getId());
		helper.addWhereCondition("q.state=?", true);
		PageBean pageBean = danXuanService.getQuestions_DanXuanList(pageNum,
				QuestionsConfig.PAGESIZE, helper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "getDXquestionList";
	}

	/**
	 * 多选
	 * 
	 * @return
	 */

	public String getDXSquestionList() {
		property();
		qtype = QuestionsConfig.DUOXUAN;
		HqlHelper helper = new HqlHelper(Questions_DuoXuan.class, "q").addWhereCondition("q.teacher.id=?", getLoginTeacher().getId());
		helper.addWhereCondition("q.state=?", true);
		PageBean pageBean = duoXuanService.getQuestions_DuoXuanList(pageNum,
				QuestionsConfig.PAGESIZE, helper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "getDXSquestionList";
	}

	/**
	 * 判断
	 * 
	 * @return
	 */
	public String getPDquestionList() {
		property();
		qtype = QuestionsConfig.PANDUAN;
		HqlHelper helper = new HqlHelper(Questions_PanDuan.class, "q").addWhereCondition("q.teacher.id=?", getLoginTeacher().getId());
		helper.addWhereCondition("q.state=?", true);
		PageBean pageBean = panDuanService.getQuestions_PanDuanList(pageNum,
				QuestionsConfig.PAGESIZE, helper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "getPDquestionList";
	}

	/**
	 * 简答
	 * 
	 * @return
	 */
	public String getJDquestionList() {
		property();
		qtype = QuestionsConfig.JIANDA;
		HqlHelper helper = new HqlHelper(Questions_JianDa.class, "q").addWhereCondition("q.teacher.id=?", getLoginTeacher().getId());
		helper.addWhereCondition("q.state=?", true);
		PageBean pageBean = jianDaService.getQuestions_JianDaList(pageNum,
				QuestionsConfig.PAGESIZE, helper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "getJDquestionList";
	}

	/**
	 * 全局搜索
	 */
	public String search() {
		property();
		if (questionType.equals(QuestionsConfig.TIANKONG)) {
			qtype = QuestionsConfig.TIANKONG;
			HqlHelper helper = new HqlHelper(Questions_TianKong.class, "q").addWhereCondition("q.teacher.id=?", getLoginTeacher().getId());
			helper.addWhereCondition(id != null, "q.id=?", id);
			helper.addWhereCondition(questionContent != null
					&& !questionContent.equals(""), "q.questions_TK like ?",
					"%" + questionContent + "%");
			helper.addWhereCondition("q.state=?", true);
			helper.addWhereCondition(difficultyId != null, "q.difficulty.id=?",
					difficultyId);
			PageBean pageBean = tianKongService.getQuestions_TianKongList(
					pageNum, QuestionsConfig.PAGESIZE, helper);
			ActionContext.getContext().getValueStack().push(pageBean);
			return "togetTKquestionList";
		} else if (questionType.equals(QuestionsConfig.DANXUAN)) {
			qtype = QuestionsConfig.DANXUAN;
			HqlHelper helper = new HqlHelper(Questions_DanXuan.class, "q").addWhereCondition("q.teacher.id=?", getLoginTeacher().getId());
			helper.addWhereCondition(id != null, "q.id=?", id);
			helper.addWhereCondition(questionContent != null
					&& !questionContent.equals(""), "q.questions_DX like ?",
					"%" + questionContent + "%");
			helper.addWhereCondition("q.state=?", true);
			helper.addWhereCondition(difficultyId != null, "q.difficulty.id=?",
					difficultyId);
			PageBean pageBean = danXuanService.getQuestions_DanXuanList(
					pageNum, QuestionsConfig.PAGESIZE, helper);
			ActionContext.getContext().getValueStack().push(pageBean);
			return "togetDXquestionList";
		} else if (questionType.equals(QuestionsConfig.DUOXUAN)) {
			qtype = QuestionsConfig.DUOXUAN;
			HqlHelper helper = new HqlHelper(Questions_DuoXuan.class, "q").addWhereCondition("q.teacher.id=?", getLoginTeacher().getId());
			helper.addWhereCondition(id != null, "q.id=?", id);
			helper.addWhereCondition(questionContent != null
					&& !questionContent.equals(""), "q.questions_DXS like ?",
					"%" + questionContent + "%");
			helper.addWhereCondition("q.state=?", true);
			helper.addWhereCondition(difficultyId != null, "q.difficulty.id=?",
					difficultyId);
			PageBean pageBean = duoXuanService.getQuestions_DuoXuanList(
					pageNum, QuestionsConfig.PAGESIZE, helper);
			ActionContext.getContext().getValueStack().push(pageBean);
			return "togetDXSquestionList";
		} else if (questionType.equals(QuestionsConfig.JIANDA)) {
			qtype = QuestionsConfig.JIANDA;
			HqlHelper helper = new HqlHelper(Questions_JianDa.class, "q").addWhereCondition("q.teacher.id=?", getLoginTeacher().getId());
			helper.addWhereCondition(id != null, "q.id=?", id);
			helper.addWhereCondition(questionContent != null
					&& !questionContent.equals(""), "q.questions_JD like ?",
					"%" + questionContent + "%");
			helper.addWhereCondition("q.state=?", true);
			helper.addWhereCondition(difficultyId != null, "q.difficulty.id=?",
					difficultyId);
			PageBean pageBean = jianDaService.getQuestions_JianDaList(pageNum,
					QuestionsConfig.PAGESIZE, helper);
			ActionContext.getContext().getValueStack().push(pageBean);
			return "togetJDquestionList";
		} else if (questionType.equals(QuestionsConfig.PANDUAN)) {
			qtype = QuestionsConfig.PANDUAN;
			HqlHelper helper = new HqlHelper(Questions_PanDuan.class, "q").addWhereCondition("q.teacher.id=?", getLoginTeacher().getId());
			helper.addWhereCondition(id != null, "q.id=?", id);
			helper.addWhereCondition(questionContent != null
					&& !questionContent.equals(""), "q.questions_PD like ?",
					"%" + questionContent + "%");
			helper.addWhereCondition("q.state=?", true);
			helper.addWhereCondition(difficultyId != null, "q.difficulty.id=?",
					difficultyId);
			PageBean pageBean = panDuanService.getQuestions_PanDuanList(
					pageNum, QuestionsConfig.PAGESIZE, helper);
			ActionContext.getContext().getValueStack().push(pageBean);
			return "togetPDquestionList";
		}
		return null;
	}

	// ///////////////////////////////////////////////
	public String[] getJiegou() {
		return jiegou;
	}

	public void setJiegou(String[] jiegou) {
		this.jiegou = jiegou;
	}

	public int[] getIndex() {
		return index;
	}

	public void setIndex(int[] index) {
		this.index = index;
	}

	public Integer getPclassifyId() {
		return pclassifyId;
	}

	public void setPclassifyId(Integer pclassifyId) {
		this.pclassifyId = pclassifyId;
	}

	public Integer getPgroupingId() {
		return pgroupingId;
	}

	public void setPgroupingId(Integer pgroupingId) {
		this.pgroupingId = pgroupingId;
	}

	public Integer getPsourceId() {
		return psourceId;
	}

	public void setPsourceId(Integer psourceId) {
		this.psourceId = psourceId;
	}

	public Integer getDifficultyId() {
		return difficultyId;
	}

	public void setDifficultyId(Integer difficultyId) {
		this.difficultyId = difficultyId;
	}

	public Integer getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(Integer classifyId) {
		this.classifyId = classifyId;
	}

	public Integer getGroupingId() {
		return groupingId;
	}

	public void setGroupingId(Integer groupingId) {
		this.groupingId = groupingId;
	}

	public Integer getSourceId() {
		return sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public Classify getClassify() {
		return classify;
	}

	public void setClassify(Classify classify) {
		this.classify = classify;
	}

	public Integer getQgroupingId() {
		return qgroupingId;
	}

	public void setQgroupingId(Integer qgroupingId) {
		this.qgroupingId = qgroupingId;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getPaperId() {
		return paperId;
	}

	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}

	public Integer[] getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(Integer[] questionIds) {
		this.questionIds = questionIds;
	}

	public float[] getFenzhi() {
		return fenzhi;
	}

	public void setFenzhi(float[] fenzhi) {
		this.fenzhi = fenzhi;
	}

	public Integer getPaperClassifieId() {
		return paperClassifieId;
	}

	public void setPaperClassifieId(Integer paperClassifieId) {
		this.paperClassifieId = paperClassifieId;
	}

	public Integer getPaperGroupingId() {
		return paperGroupingId;
	}

	public void setPaperGroupingId(Integer paperGroupingId) {
		this.paperGroupingId = paperGroupingId;
	}

	public Integer getPaperSourceId() {
		return paperSourceId;
	}

	public void setPaperSourceId(Integer paperSourceId) {
		this.paperSourceId = paperSourceId;
	}

	public boolean isPaperstate() {
		return paperstate;
	}

	public void setPaperstate(boolean paperstate) {
		this.paperstate = paperstate;
	}

	public String getUtype() {
		return utype;
	}

	public void setUtype(String utype) {
		this.utype = utype;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public float getSumScore() {
		return sumScore;
	}

	public void setSumScore(float sumScore) {
		this.sumScore = sumScore;
	}

}
