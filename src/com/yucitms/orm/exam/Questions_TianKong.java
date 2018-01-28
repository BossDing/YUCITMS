package com.yucitms.orm.exam;

import java.util.Date;

import com.yucitms.orm.school.Teacher;

/**
 * 填空题
 * @author qiangzi
 *
 */
public class Questions_TianKong  implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String  questions_TK;//问题
	private String  answer_TK;//答案
	private String  parse;//解析
	private String type;//类型
	private boolean state;
	private Date createDate;
	private Classify classify;//试题分类
    private Difficulty difficulty;//难易
    private Grouping grouping;//分组
    private Source source;//来源
    private Teacher teacher;//出题人
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestions_TK() {
		return questions_TK;
	}
	public void setQuestions_TK(String questions_TK) {
		this.questions_TK = questions_TK;
	}
	public String getAnswer_TK() {
		return answer_TK;
	}
	public void setAnswer_TK(String answer_TK) {
		this.answer_TK = answer_TK;
	}
	
	public String getParse() {
		return parse;
	}
	public void setParse(String parse) {
		this.parse = parse;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	
}
