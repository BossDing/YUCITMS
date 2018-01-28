package com.yucitms.orm.exam;

import java.util.Date;

import com.yucitms.orm.school.Teacher;

/**
 * 判断题
 * @author qiangzi
 *
 */
public class Questions_PanDuan  implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String  questions_PD;//问题
	private int  answer_PD;//正确答案 /0错误1正确
	private String  parse;//解析
	private String type;//类型
	private Date createDate;
	private Classify classify;//试题分类
    private Difficulty difficulty;//难易
    private Grouping grouping;//分组
    private Source source;//来源
    private boolean state;
    private Teacher teacher;//出题人
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestions_PD() {
		return questions_PD;
	}
	public void setQuestions_PD(String questions_PD) {
		this.questions_PD = questions_PD;
	}
	public int getAnswer_PD() {
		return answer_PD;
	}
	public void setAnswer_PD(int answer_PD) {
		this.answer_PD = answer_PD;
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
