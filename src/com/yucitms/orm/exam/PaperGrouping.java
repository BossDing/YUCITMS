package com.yucitms.orm.exam;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 试卷分组
 * @author qiangzi
 *
 */
public class PaperGrouping implements java.io.Serializable{
	private Integer id;
	private String paperGrouping;
	private Date createDate;
	private boolean state;
	private Set<ExamPaper> examPapers = new HashSet<ExamPaper>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPaperGrouping() {
		return paperGrouping;
	}
	public void setPaperGrouping(String paperGrouping) {
		this.paperGrouping = paperGrouping;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Set<ExamPaper> getExamPapers() {
		return examPapers;
	}
	public void setExamPapers(Set<ExamPaper> examPapers) {
		this.examPapers = examPapers;
	}
	
}
