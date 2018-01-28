package com.yucitms.action.practicalTraining;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yucitms.config.Config;
import com.yucitms.orm.attendance.AttendanceMain;
import com.yucitms.orm.netLesson.DifficultyGuidance;
import com.yucitms.orm.practicalTraining.PracticalTrainingTemplate;
import com.yucitms.orm.school.Student;
import com.yucitms.orm.school.Teacher;
import com.yucitms.service.practicalTraining.PracticalTrainingTemplateService;
import com.yucitms.util.DateUtil;
import com.yucitms.util.FileOpreationUtil;
import com.yucitms.util.FtpUtil;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;
import com.yucitms.util.UpLoadUtil;

public class PracticalTrainingAction extends ActionSupport{
	private PracticalTrainingTemplate practicalTrainingTemplate;
	private PracticalTrainingTemplateService practicalTrainingTemplateService;
	private Teacher teacher;
	Date date = new Date();
	
	private File upload;
	private String uploadFileName;
	private File upload2;
	private String upload2FileName;
	private String uploadContentType;
	private String upload2ContentType;
	private String templateID;//模板ID
	private String templateName;//模板名称
	private String technologicalType;//技术类型
	
	/**
	 * 实训任务(初始化)
	 */
	public String practicalTrainingTask(){
//		HqlHelper hqlHelper = new HqlHelper(PracticalTrainingTemplate.class, "pt");
//		PageBean pageBean=practicalTrainingTemplateService.queryAttendance(Config.PAGENUM,Config.EXCELLENTCOURSE_PageSize,hqlHelper);
//		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "practicalTrainingTask";
	}
	
	/**
	 * 模板(初始化)
	 */
	public String template(){
		HqlHelper hqlHelper = new HqlHelper(PracticalTrainingTemplate.class, "pt");
		PageBean pageBean=practicalTrainingTemplateService.queryAttendance(Config.PAGENUM,Config.EXCELLENTCOURSE_PageSize,hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "template";
	}
	
	/**
	 * 新增实训模板
	 */
	public String addTemplate(){
		teacher=(Teacher)ActionContext.getContext().getSession().get("teacher");
		if(upload!=null){	//模板
			practicalTrainingTemplate.setUploadTemplateName(uploadFileName);
			uploadFileName = FileOpreationUtil.modifyFileName(uploadFileName);
			uploadFileName=UpLoadUtil.Upload_FtpOrLocal(Config.UPLOAD_method, uploadFileName, upload, Config.PRACTICALTRAINING_SaveFilePath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
			practicalTrainingTemplate.setUploadTemplatePath(uploadFileName);
		}
		if(upload2!=null){	//降级模板
			practicalTrainingTemplate.setDegradationTemplateName(upload2FileName);
			upload2FileName = FileOpreationUtil.modifyFileName(upload2FileName);
			upload2FileName=UpLoadUtil.Upload_FtpOrLocal(Config.UPLOAD_method, upload2FileName, upload2, Config.PRACTICALTRAINING_SaveFilePath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
			practicalTrainingTemplate.setDegradationTemplatePath(upload2FileName);
		}
		practicalTrainingTemplate.setUploadTime(date);
		practicalTrainingTemplate.setTeacher(teacher);
		
		practicalTrainingTemplateService.saveTemplate(practicalTrainingTemplate);
		return "addTemplate";
	}

	/**
	 * 删除
	 */
	public String deleteTemplate(){
		Integer integertemplateID=Integer.valueOf(templateID);
		practicalTrainingTemplate = practicalTrainingTemplateService.getById(integertemplateID);
		FtpUtil.delete_file(Config.DELETE_method,Config.PRACTICALTRAINING_SaveFilePath+practicalTrainingTemplate.getUploadTemplatePath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
		FtpUtil.delete_file(Config.DELETE_method,Config.PRACTICALTRAINING_SaveFilePath+practicalTrainingTemplate.getDegradationTemplatePath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
		practicalTrainingTemplateService.deleteById(integertemplateID);
		
		return "deleteTemplate";
	}
	
	/**
	 *打开更新页面 
	 */
	public String editTemplate(){
		Integer integertemplateID=Integer.valueOf(templateID);
		practicalTrainingTemplate = practicalTrainingTemplateService.getById(integertemplateID);
		
		
		return "editTemplate";
	}
	/**
	 *更新 
	 */
	public String updateTemplate(){
//		Integer integertemplateID=Integer.valueOf(templateID);
		PracticalTrainingTemplate practicalTrainingTemplateTemp = practicalTrainingTemplateService.getById(practicalTrainingTemplate.getId());
		teacher=(Teacher)ActionContext.getContext().getSession().get("teacher");
		if(upload!=null){	//模板
			practicalTrainingTemplate.setUploadTemplateName(uploadFileName);
			uploadFileName = FileOpreationUtil.modifyFileName(uploadFileName);
			//删除 旧文件
			FtpUtil.delete_file(Config.DELETE_method,Config.PRACTICALTRAINING_SaveFilePath+practicalTrainingTemplate.getUploadTemplatePath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
			uploadFileName=UpLoadUtil.Upload_FtpOrLocal(Config.UPLOAD_method, uploadFileName, upload, Config.PRACTICALTRAINING_SaveFilePath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
			practicalTrainingTemplate.setUploadTemplatePath(uploadFileName);
		}else{
			practicalTrainingTemplate.setUploadTemplateName(practicalTrainingTemplateTemp.getUploadTemplateName());
			practicalTrainingTemplate.setUploadTemplatePath(practicalTrainingTemplateTemp.getUploadTemplatePath());
		}
		if(upload2!=null){	//降级模板
			practicalTrainingTemplate.setDegradationTemplateName(practicalTrainingTemplateTemp.getDegradationTemplateName());
			upload2FileName = FileOpreationUtil.modifyFileName(practicalTrainingTemplateTemp.getDegradationTemplatePath());
			//删除 旧文件
			FtpUtil.delete_file(Config.DELETE_method,Config.PRACTICALTRAINING_SaveFilePath+practicalTrainingTemplate.getDegradationTemplatePath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
			upload2FileName=UpLoadUtil.Upload_FtpOrLocal(Config.UPLOAD_method, upload2FileName, upload2, Config.PRACTICALTRAINING_SaveFilePath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
			practicalTrainingTemplate.setDegradationTemplatePath(upload2FileName);
		}else{
			practicalTrainingTemplate.setDegradationTemplateName(upload2FileName);
			practicalTrainingTemplate.setDegradationTemplatePath(upload2FileName);
		}
		practicalTrainingTemplate.setUploadTime(date);
		practicalTrainingTemplate.setTeacher(teacher);
		practicalTrainingTemplateService.update(practicalTrainingTemplate);
		return "updateTemplate";
	}
	
	/**
	 *查询Template
	 */
	public String queryTemplate(){
		HqlHelper hqlHelper = new HqlHelper(PracticalTrainingTemplate.class, "pt");
		hqlHelper.addSqlCondition(queryTemplateSql());
		PageBean pageBean=practicalTrainingTemplateService.queryAttendance(Config.PAGENUM,Config.EXCELLENTCOURSE_PageSize,hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "template";
		
	}
	
	public String queryTemplateSql(){
		Boolean and = false;
		String sql = "WHERE ";
		if(practicalTrainingTemplate.getTemplateName()!=null){
			sql = sql + " templateName like'%"+practicalTrainingTemplate.getTemplateName()+"%'";
			and = true;
		}
		if(practicalTrainingTemplate.getTechnologicalType()!=null){
			if(and){
				sql = sql + " and ";
			}
			sql = sql + " technologicalType like'%"+practicalTrainingTemplate.getTechnologicalType()+"%'";
		}
		
		return sql;
	}
	
	
	public PracticalTrainingTemplate getPracticalTrainingTemplate() {
		return practicalTrainingTemplate;
	}

	public void setPracticalTrainingTemplate(
			PracticalTrainingTemplate practicalTrainingTemplate) {
		this.practicalTrainingTemplate = practicalTrainingTemplate;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public File getUpload2() {
		return upload2;
	}

	public void setUpload2(File upload2) {
		this.upload2 = upload2;
	}

	public String getUpload2FileName() {
		return upload2FileName;
	}

	public void setUpload2FileName(String upload2FileName) {
		this.upload2FileName = upload2FileName;
	}

	public String getUpload2ContentType() {
		return upload2ContentType;
	}

	public void setUpload2ContentType(String upload2ContentType) {
		this.upload2ContentType = upload2ContentType;
	}

	public PracticalTrainingTemplateService getPracticalTrainingTemplateService() {
		return practicalTrainingTemplateService;
	}

	public void setPracticalTrainingTemplateService(
			PracticalTrainingTemplateService practicalTrainingTemplateService) {
		this.practicalTrainingTemplateService = practicalTrainingTemplateService;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTemplateID() {
		return templateID;
	}

	public void setTemplateID(String templateID) {
		this.templateID = templateID;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTechnologicalType() {
		return technologicalType;
	}

	public void setTechnologicalType(String technologicalType) {
		this.technologicalType = technologicalType;
	}
	
}
