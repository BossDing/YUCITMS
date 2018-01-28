package com.yucitms.orm.exam;

import java.util.Date;

import com.yucitms.orm.school.Teacher;

/**
 * 多选
 * @author qiangzi
 *
 */
public class Questions_DuoXuan implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String  questions_DXS;//问题
	private String A;
	private String B;
	private String C;
	private String D;
	private String E;
	private String F;
	private String  answer_DXS;//答案
	private String  parse;//解析
	private boolean state;//状态
	private String type;//类型
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
	public String getQuestions_DXS() {
		return questions_DXS;
	}
	public void setQuestions_DXS(String questions_DXS) {
		this.questions_DXS = questions_DXS;
	}
	public String getA() {
		return A;
	}
	public void setA(String a) {
		A = a;
	}
	public String getB() {
		return B;
	}
	public void setB(String b) {
		B = b;
	}
	public String getC() {
		return C;
	}
	public void setC(String c) {
		C = c;
	}
	public String getD() {
		return D;
	}
	public void setD(String d) {
		D = d;
	}
	public String getE() {
		return E;
	}
	public void setE(String e) {
		E = e;
	}
	public String getF() {
		return F;
	}
	public void setF(String f) {
		F = f;
	}
	public String getAnswer_DXS() {
		return answer_DXS;
	}
	public void setAnswer_DXS(String answer_DXS) {
		this.answer_DXS = answer_DXS;
	}
	public String getParse() {
		return parse;
	}
	public void setParse(String parse) {
		this.parse = parse;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
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
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
