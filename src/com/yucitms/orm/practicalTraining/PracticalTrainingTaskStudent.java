package com.yucitms.orm.practicalTraining;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.yucitms.orm.school.ClassRoom;
import com.yucitms.orm.school.Student;
import com.yucitms.orm.school.Teacher;

/**
 * 实训任务表
 * @author woxiaxiangyang
 *
 */
public class PracticalTrainingTaskStudent implements java.io.Serializable{
	private Integer id;
	private Date issuedTime;//发布时间
	private Date claimTime;//认领时间
	private String describe;//描述
	
	private String progress;//进度
	private Student student;//学生（具体到学生）
	private Teacher teacher;//任务发布教师（所属）
	private PracticalTrainingTask practicalTrainingTask;//实训任务
	private String uploadTemplateName; //上传模板名称
	private String uploadTemplatePath; //上传模板路径
	private String degradationTemplateName; //上传降级模板名称
	private String degradationTemplatePath; //上传降级模板路径
	private String submitMark;//提交标示（submitTrue/submitFalse）
	private int score;//分数
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getIssuedTime() {
		return issuedTime;
	}
	public void setIssuedTime(Date issuedTime) {
		this.issuedTime = issuedTime;
	}
	public Date getClaimTime() {
		return claimTime;
	}
	public void setClaimTime(Date claimTime) {
		this.claimTime = claimTime;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public PracticalTrainingTask getPracticalTrainingTask() {
		return practicalTrainingTask;
	}
	public void setPracticalTrainingTask(PracticalTrainingTask practicalTrainingTask) {
		this.practicalTrainingTask = practicalTrainingTask;
	}
	public String getUploadTemplateName() {
		return uploadTemplateName;
	}
	public void setUploadTemplateName(String uploadTemplateName) {
		this.uploadTemplateName = uploadTemplateName;
	}
	public String getUploadTemplatePath() {
		return uploadTemplatePath;
	}
	public void setUploadTemplatePath(String uploadTemplatePath) {
		this.uploadTemplatePath = uploadTemplatePath;
	}
	public String getDegradationTemplateName() {
		return degradationTemplateName;
	}
	public void setDegradationTemplateName(String degradationTemplateName) {
		this.degradationTemplateName = degradationTemplateName;
	}
	public String getDegradationTemplatePath() {
		return degradationTemplatePath;
	}
	public void setDegradationTemplatePath(String degradationTemplatePath) {
		this.degradationTemplatePath = degradationTemplatePath;
	}
	public String getSubmitMark() {
		return submitMark;
	}
	public void setSubmitMark(String submitMark) {
		this.submitMark = submitMark;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
