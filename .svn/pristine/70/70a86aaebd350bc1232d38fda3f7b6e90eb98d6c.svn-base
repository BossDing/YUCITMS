package com.yucitms.orm.exam;

import java.util.HashSet;
import java.util.Set;

/**
 * 试卷中大题
 * @author qiangzi
 *
 */
public class QuestionsGrouping implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;//大题命名
	//题
	private Set<Questions> questions= new HashSet<Questions>();//试题
	private int index;//索引
	private String type;
	private ExamPaper examPaper;
	private float zongfen;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Questions> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ExamPaper getExamPaper() {
		return examPaper;
	}
	public void setExamPaper(ExamPaper examPaper) {
		this.examPaper = examPaper;
	}
	public float getZongfen() {
		return zongfen;
	}
	public void setZongfen(float zongfen) {
		this.zongfen = zongfen;
	}
	
	
	
}
