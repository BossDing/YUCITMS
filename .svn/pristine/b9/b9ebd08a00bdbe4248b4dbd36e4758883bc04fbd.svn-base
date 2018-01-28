package com.yucitms.action.exam;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yucitms.orm.exam.Classify;
import com.yucitms.orm.exam.Difficulty;
import com.yucitms.orm.exam.Grouping;
import com.yucitms.orm.exam.Questions_DanXuan;
import com.yucitms.orm.exam.Questions_DuoXuan;
import com.yucitms.orm.exam.Questions_JianDa;
import com.yucitms.orm.exam.Questions_PanDuan;
import com.yucitms.orm.exam.Questions_TianKong;
import com.yucitms.orm.exam.Source;
import com.yucitms.orm.school.Teacher;
import com.yucitms.service.exam.ClassifyService;
import com.yucitms.service.exam.DifficultyService;
import com.yucitms.service.exam.GroupingService;
import com.yucitms.service.exam.QuestionsService;
import com.yucitms.service.exam.Questions_DanXuanService;
import com.yucitms.service.exam.Questions_DuoXuanService;
import com.yucitms.service.exam.Questions_JianDaService;
import com.yucitms.service.exam.Questions_PanDuanService;
import com.yucitms.service.exam.Questions_TianKongService;
import com.yucitms.service.exam.SourceService;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;
/**
 * 管理试题  搜索 列表
 * @author qiangzi
 *
 */
public class QuestionManagerAction extends ActionSupport{
	/*
	 * service
	 */
	private ClassifyService classifyService;
	private DifficultyService difficultyService;
	private GroupingService groupingService;
	private SourceService sourceService;
	private QuestionsService questionsService;
	private Questions_DuoXuanService duoXuanService;
	private Questions_JianDaService jianDaService;
	private Questions_PanDuanService panDuanService;
	private Questions_TianKongService tianKongService;
	private Questions_DanXuanService danXuanService;
	/*
	 * 分页属性
	 */
	private int pageNum = 1;

	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	} 
	/*
	 * 表单查询属性
	 */
	private Integer difficultyId;//难度
	private Integer classifyId;//分类
	private Integer groupingId;//分组
	private Integer sourceId;//来源
	private String questionContent;//问题
	private String questionType;//问题类型
	private boolean state;//试题类型
	private Integer id;//试题编号
	private String qtype;//试题类型
	private Classify classify;
	private Difficulty difficulty;
	private Grouping grouping;
	private Source source;
	private Teacher teacher;
	
	/**
	 * 所有试题分类列表 属性
	 */
	private void property(){
		//查询试题属性
				List<Classify> classifies= classifyService.findEnabled();
				List<Difficulty> difficulties=difficultyService.findEnabled();
			//	List<Grouping> groupings= groupingService.findEnabled();
				List<Source> sources =sourceService.findEnabled();
				ActionContext.getContext().put("classifies", classifies);
				ActionContext.getContext().put("difficulties", difficulties);
			//	ActionContext.getContext().put("groupings", groupings);
				ActionContext.getContext().put("sources", sources);
				//当前登录者
				 teacher = (Teacher) ActionContext.getContext().getSession().get("teacher");
	}
	/**
	 * 查询试题前执行
	 */
	private void addbefore(){
		classify=classifyService.getById(classifyId);
		difficulty=difficultyService.getById(difficultyId);
	//	grouping=groupingService.getById(groupingId);
		source=sourceService.getById(sourceId);
	}
	/**
	 * 填空题列表
	 * @return
	 */
	public String  getTKquestionList(){
		property();
		qtype=QuestionsConfig.TIANKONG;
		HqlHelper helper = new HqlHelper(Questions_TianKong.class, "q").addWhereCondition("q.teacher.id=?", teacher.getId());
		PageBean pageBean=tianKongService.getQuestions_TianKongList(pageNum, QuestionsConfig.PAGESIZE, helper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "getTKquestionList";
	} 
	/**
	 * 单选
	 * @return
	 */
	public String  getDXquestionList(){
		property();
		qtype=QuestionsConfig.DANXUAN;
		HqlHelper helper = new HqlHelper(Questions_DanXuan.class, "q").addWhereCondition("q.teacher.id=?", teacher.getId());
		PageBean pageBean=danXuanService.getQuestions_DanXuanList(pageNum, QuestionsConfig.PAGESIZE, helper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "getDXquestionList";
	} 
	/**
	 * 多选
	 * @return
	 */
	
	public String  getDXSquestionList(){
		property();
		qtype=QuestionsConfig.DUOXUAN;
		HqlHelper helper = new HqlHelper(Questions_DuoXuan.class, "q").addWhereCondition("q.teacher.id=?", teacher.getId());
		PageBean pageBean=duoXuanService.getQuestions_DuoXuanList(pageNum, QuestionsConfig.PAGESIZE, helper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "getDXSquestionList";
	} 
	/**
	 * 判断
	 * @return
	 */
	public String  getPDquestionList(){
		property();
		qtype=QuestionsConfig.PANDUAN;
		HqlHelper helper = new HqlHelper(Questions_PanDuan.class, "q").addWhereCondition("q.teacher.id=?", teacher.getId());
		PageBean pageBean=panDuanService.getQuestions_PanDuanList(pageNum, QuestionsConfig.PAGESIZE, helper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "getPDquestionList";
	} 
	/**
	 * 简答
	 * @return
	 */
	public String  getJDquestionList(){
		property();
		qtype=QuestionsConfig.JIANDA;
		HqlHelper helper = new HqlHelper(Questions_JianDa.class, "q").addWhereCondition("q.teacher.id=?", teacher.getId());
		PageBean pageBean=jianDaService.getQuestions_JianDaList(pageNum, QuestionsConfig.PAGESIZE, helper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "getJDquestionList";
	} 
	/**
	 * 全局搜索
	 */
	public String search(){
		property();
		if(questionType.equals(QuestionsConfig.TIANKONG)){
			qtype=QuestionsConfig.TIANKONG;
			HqlHelper helper = new HqlHelper(Questions_TianKong.class, "q").addWhereCondition("q.teacher.id=?", teacher.getId());
			helper.addWhereCondition(id!=null, "q.id=?",id);
			helper.addWhereCondition(questionContent!=null&&!questionContent.equals(""), "q.questions_TK like ?","%"+questionContent+"%");
			helper.addWhereCondition("q.state=?", state);
			helper.addWhereCondition(difficultyId!=null,"q.difficulty.id=?",difficultyId);
			PageBean pageBean=tianKongService.getQuestions_TianKongList(pageNum, QuestionsConfig.PAGESIZE, helper);
			ActionContext.getContext().getValueStack().push(pageBean);
			return "togetTKquestionList";
		}else if(questionType.equals(QuestionsConfig.DANXUAN)){
			qtype=QuestionsConfig.DANXUAN;
			HqlHelper helper = new HqlHelper(Questions_DanXuan.class, "q").addWhereCondition("q.teacher.id=?", teacher.getId());
			helper.addWhereCondition(id!=null, "q.id=?",id);
			helper.addWhereCondition(questionContent!=null&&!questionContent.equals(""), "q.questions_DX like ?","%"+questionContent+"%");
			helper.addWhereCondition("q.state=?", state);
			helper.addWhereCondition(difficultyId!=null,"q.difficulty.id=?",difficultyId);
			PageBean pageBean=danXuanService.getQuestions_DanXuanList(pageNum, QuestionsConfig.PAGESIZE, helper);
			ActionContext.getContext().getValueStack().push(pageBean);
			return "togetDXquestionList";
		}else if(questionType.equals(QuestionsConfig.DUOXUAN)){
			qtype=QuestionsConfig.DUOXUAN;
			HqlHelper helper = new HqlHelper(Questions_DuoXuan.class, "q").addWhereCondition("q.teacher.id=?", teacher.getId());
			helper.addWhereCondition(id!=null, "q.id=?",id);
			helper.addWhereCondition(questionContent!=null&&!questionContent.equals(""), "q.questions_DXS like ?","%"+questionContent+"%");
			helper.addWhereCondition("q.state=?", state);
			helper.addWhereCondition(difficultyId!=null,"q.difficulty.id=?",difficultyId);
			PageBean pageBean=duoXuanService.getQuestions_DuoXuanList(pageNum, QuestionsConfig.PAGESIZE, helper);
			ActionContext.getContext().getValueStack().push(pageBean);
			return "togetDXSquestionList";
		}else if(questionType.equals(QuestionsConfig.JIANDA)){
			qtype=QuestionsConfig.JIANDA;
			HqlHelper helper = new HqlHelper(Questions_JianDa.class, "q").addWhereCondition("q.teacher.id=?", teacher.getId());
			helper.addWhereCondition(id!=null, "q.id=?",id);
			helper.addWhereCondition(questionContent!=null&&!questionContent.equals(""), "q.questions_JD like ?","%"+questionContent+"%");
			helper.addWhereCondition("q.state=?", state);
			helper.addWhereCondition(difficultyId!=null,"q.difficulty.id=?",difficultyId);
			PageBean pageBean=jianDaService.getQuestions_JianDaList(pageNum, QuestionsConfig.PAGESIZE, helper);
			ActionContext.getContext().getValueStack().push(pageBean);
			return "togetJDquestionList";
		}else if(questionType.equals(QuestionsConfig.PANDUAN)){
			qtype=QuestionsConfig.PANDUAN;
			HqlHelper helper = new HqlHelper(Questions_PanDuan.class, "q").addWhereCondition("q.teacher.id=?", teacher.getId());
			helper.addWhereCondition(id!=null, "q.id=?",id);
			helper.addWhereCondition(questionContent!=null&&!questionContent.equals(""), "q.questions_PD like ?","%"+questionContent+"%");
			helper.addWhereCondition("q.state=?", state);
			helper.addWhereCondition(difficultyId!=null,"q.difficulty.id=?",difficultyId);
			PageBean pageBean=panDuanService.getQuestions_PanDuanList(pageNum, QuestionsConfig.PAGESIZE, helper);
			ActionContext.getContext().getValueStack().push(pageBean);
			return "togetPDquestionList";
		}
		return null;
	} 
	///////////封装
	public ClassifyService getClassifyService() {
		return classifyService;
	}
	public void setClassifyService(ClassifyService classifyService) {
		this.classifyService = classifyService;
	}
	public DifficultyService getDifficultyService() {
		return difficultyService;
	}
	public void setDifficultyService(DifficultyService difficultyService) {
		this.difficultyService = difficultyService;
	}
	public GroupingService getGroupingService() {
		return groupingService;
	}
	public void setGroupingService(GroupingService groupingService) {
		this.groupingService = groupingService;
	}
	public SourceService getSourceService() {
		return sourceService;
	}
	public void setSourceService(SourceService sourceService) {
		this.sourceService = sourceService;
	}
	public QuestionsService getQuestionsService() {
		return questionsService;
	}
	public void setQuestionsService(QuestionsService questionsService) {
		this.questionsService = questionsService;
	}
	public Questions_DuoXuanService getDuoXuanService() {
		return duoXuanService;
	}
	public void setDuoXuanService(Questions_DuoXuanService duoXuanService) {
		this.duoXuanService = duoXuanService;
	}
	public Questions_JianDaService getJianDaService() {
		return jianDaService;
	}
	public void setJianDaService(Questions_JianDaService jianDaService) {
		this.jianDaService = jianDaService;
	}
	public Questions_PanDuanService getPanDuanService() {
		return panDuanService;
	}
	public void setPanDuanService(Questions_PanDuanService panDuanService) {
		this.panDuanService = panDuanService;
	}
	public Questions_TianKongService getTianKongService() {
		return tianKongService;
	}
	public void setTianKongService(Questions_TianKongService tianKongService) {
		this.tianKongService = tianKongService;
	}
	public Questions_DanXuanService getDanXuanService() {
		return danXuanService;
	}
	public void setDanXuanService(Questions_DanXuanService danXuanService) {
		this.danXuanService = danXuanService;
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
	public Classify getClassify() {
		return classify;
	}
	public void setClassify(Classify classify) {
		this.classify = classify;
	}
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	public Grouping getGrouping() {
		return grouping;
	}
	public void setGrouping(Grouping grouping) {
		this.grouping = grouping;
	}
	public Source getSource() {
		return source;
	}
	public void setSource(Source source) {
		this.source = source;
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
	
}
