package com.yucitms.orm.exam;
/**
 * 答题卡里的答案
 * @author qiangzi
 *
 */
public class Answer {
	private Integer id;
	private String answer;//答案
	private boolean right;//正确
	private String parse;//解析
	private float defen;//得分
	private String remark;//评语
	private AnswerSheets answerSheets;//所属答题卡
	private Questions questions;//对应的题目
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public String getParse() {
		return parse;
	}
	public void setParse(String parse) {
		this.parse = parse;
	}
	public float getDefen() {
		return defen;
	}
	public void setDefen(float defen) {
		this.defen = defen;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public AnswerSheets getAnswerSheets() {
		return answerSheets;
	}
	public void setAnswerSheets(AnswerSheets answerSheets) {
		this.answerSheets = answerSheets;
	}
	public Questions getQuestions() {
		return questions;
	}
	public void setQuestions(Questions questions) {
		this.questions = questions;
	}
	
}
