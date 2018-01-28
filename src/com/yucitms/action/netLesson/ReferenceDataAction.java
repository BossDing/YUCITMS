package com.yucitms.action.netLesson;

import java.io.File;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.yucitms.action.BaseAction;
import com.yucitms.config.Config;
import com.yucitms.orm.netLesson.ExcellentCourse;
import com.yucitms.orm.netLesson.ReferenceData;
import com.yucitms.util.FileOpreationUtil;
import com.yucitms.util.FtpUtil;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;
import com.yucitms.util.UpLoadUtil;

/**
 * 参考资料
 * @author qiangzi
 *
 */
public class ReferenceDataAction extends BaseAction<ReferenceData>{
	public String referenceData(){
		ExcellentCourse excellentCourse = excellentCourseService.getById(courseId);
		ActionContext.getContext().getValueStack().push(excellentCourse);
		return "referenceData";
	}
	
	
	///////////////////////后台 
	private Integer courseId;
	private String uploadFileName;
	private File upload;
	private String uploadContentType;
	/**
	 * 列表
	 * @return
	 */
	public String getReferenceDataList(){
		HqlHelper hqlHelper = new HqlHelper(ReferenceData.class, "et");
		hqlHelper.addWhereCondition("et.courses.id=?", courseId);
		hqlHelper.addWhereCondition(model.getReferenceName()!=null&&!model.getReferenceName().equals(""), "et.VideoName like ?","%"+model.getReferenceName()+"%");
		PageBean pageBean=referenceDataService.getReferenceData(pageNum,Config.EXCELLENTCOURSE_PageSize, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "getReferenceDataList";
	}
	/**
	 * 添加
	 * @return
	 */
	public String addReferenceDataPage(){
		return "addReferenceDataPage";
	}
	public String addReferenceData(){
		System.out.println("文件名称"+uploadFileName);
		try {
			uploadFileName = FileOpreationUtil.modifyFileName(uploadFileName);
			model.setOldFilePath(uploadFileName);
			uploadFileName=UpLoadUtil.uploadOfficToSwf(Config.UPLOAD_ftp, uploadFileName, upload, Config.TEMP_path, Config.EXCELLENTCOURSE_SaveFilePath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
			model.setPdfPath(uploadFileName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ExcellentCourse course=excellentCourseService.getById(courseId);
		model.setCourses(course);
		model.setCreateDate(new Date());
		referenceDataService.addReferenceData(model);
		return "referenceDataList";
	}
	/**
	 * 更新
	 */
	public String updateReferenceDataPage(){
		System.out.println("获取到的id"+model.getId());
		ReferenceData referenceData = referenceDataService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(referenceData);
		return "updateReferenceDataPage";
	}
	public String updateReferenceData(){
		ReferenceData referenceData = referenceDataService.getById(model.getId());
		try {
			if(upload!=null){
				FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveFilePath+referenceData.getOldFilePath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);	
				uploadFileName = FileOpreationUtil.modifyFileName(uploadFileName);
				referenceData.setOldFilePath(uploadFileName);
				FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveFilePath+referenceData.getPdfPath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);	
				uploadFileName=UpLoadUtil.uploadOfficToSwf(Config.UPLOAD_ftp, uploadFileName, upload, Config.TEMP_path, Config.EXCELLENTCOURSE_SaveFilePath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				referenceData.setPdfPath(uploadFileName);  				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		referenceData.setReferenceName(model.getReferenceName());
		referenceDataService.updatReferenceData(referenceData);
		return "referenceDataList";
	}
	/**
	 * 删除
	 * @return
	 */
	public String deleteReferenceData(){
		ReferenceData referenceData = referenceDataService.getById(model.getId());
		FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveFilePath+referenceData.getOldFilePath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);	
		FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveFilePath+referenceData.getPdfPath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);		
		referenceDataService.deleteReferenceData(model.getId());
		return "referenceDataList";
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	
}
