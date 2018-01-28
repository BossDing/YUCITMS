package com.yucitms.orm.exam;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.yucitms.orm.school.Major;

/**
 * 考试表
 * @author qiangzi
 *
 */
public class Exam {
	private Integer id;
	private ExamPaper examPaper;//试卷
	private Major major;//专业
	private Set<AnswerSheets> answerSheets= new HashSet<AnswerSheets>();//答题卡
	private Date startDate;//开始时间
	private Date endDate;//结束时间
	private Date createDate;//创建时间
	private String remark;//备注
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ExamPaper getExamPaper() {
		return examPaper;
	}
	public void setExamPaper(ExamPaper examPaper) {
		this.examPaper = examPaper;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public Set<AnswerSheets> getAnswerSheets() {
		return answerSheets;
	}
	public void setAnswerSheets(Set<AnswerSheets> answerSheets) {
		this.answerSheets = answerSheets;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
