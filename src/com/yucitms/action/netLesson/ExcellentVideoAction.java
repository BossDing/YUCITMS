package com.yucitms.action.netLesson;

import java.io.File;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.yucitms.action.BaseAction;
import com.yucitms.config.Config;
import com.yucitms.orm.netLesson.ExcellentCourse;
import com.yucitms.orm.netLesson.ExcellentTeacher;
import com.yucitms.orm.netLesson.ExcellentVideo;
import com.yucitms.orm.netLesson.ExcellentVideo;
import com.yucitms.util.FtpUtil;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;
import com.yucitms.util.UpLoadUtil;

/**
 * 视频
 * @author qiangzi
 *
 */
public class ExcellentVideoAction extends BaseAction<ExcellentVideo>{
	/**
	 * 精品视频
	 */
	public String excellentMP4(){
		ExcellentCourse excellentCourse = excellentCourseService.getById(courseId);
		ActionContext.getContext().getValueStack().push(excellentCourse);
		return "excellentMP4";
	}
	
	////////////////////////////////////后台
	private Integer courseId;
	private String uploadFileName;
	private File upload;
	private String uploadContentType;
	private File uploadimg;
	private String uploadimgFileName;
	private String uploadimgContentType;
	
	/**
	 * 视频列表
	 * @return
	 */
	public String getExcellentVideoList(){
		HqlHelper hqlHelper = new HqlHelper(ExcellentVideo.class, "et");
		hqlHelper.addWhereCondition("et.course.id=?", courseId);
		hqlHelper.addWhereCondition(model.getVideoName()!=null&&!model.getVideoName().equals(""), "et.VideoName like ?","%"+model.getVideoName()+"%");
		PageBean pageBean=excellentVideoService.getxcellentVideoList(pageNum,Config.EXCELLENTCOURSE_PageSize, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "getExcellentVideoList";
	}
	/**
	 * 添加视频
	 * @return
	 */
	public String addExcellentVideoPage(){
		return "addExcellentVideoPage";
	}
	public String addExcellentVideo(){
		System.out.println("文件名称"+uploadFileName);
		try {
			if(upload!=null){
				uploadFileName=UpLoadUtil.Upload_FtpOrLocal(Config.UPLOAD_method, uploadFileName, upload, Config.EXCELLENTCOURSE_SaveVideoPath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				model.setVideoPath(uploadFileName);				
			}
			if(uploadimg!=null){
				uploadimgFileName=UpLoadUtil.Upload_FtpOrLocal(Config.UPLOAD_method, uploadimgFileName, uploadimg, Config.EXCELLENTCOURSE_SaveImgPath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				model.setVideoImgPath(uploadimgFileName);	
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ExcellentCourse course=excellentCourseService.getById(courseId);
		model.setCourse(course);
		model.setCreateDate(new Date());
		excellentVideoService.addxcellentVideo(model);
		return "excellentVideoList";
	}
	/**
	 * 更新视频
	 */
	public String updateExcellentVideoPage(){
		System.out.println("获取到的id"+model.getId());
		ExcellentVideo excellentVideo = excellentVideoService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(excellentVideo);
		return "updateExcellentVideoPage";
	}
	public String updateExcellentVideo(){
		ExcellentVideo excellentVideo = excellentVideoService.getById(model.getId());
		try {
			if(upload!=null){
				//删除 旧文件
				FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveVideoPath+excellentVideo.getVideoPath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				uploadFileName=UpLoadUtil.Upload_FtpOrLocal(Config.UPLOAD_method, uploadFileName, upload, Config.EXCELLENTCOURSE_SaveVideoPath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				excellentVideo.setVideoPath(uploadFileName);  				
			}
			if(uploadimg!=null){
				FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveImgPath+excellentVideo.getVideoImgPath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				uploadimgFileName=UpLoadUtil.Upload_FtpOrLocal(Config.UPLOAD_method, uploadimgFileName, uploadimg, Config.EXCELLENTCOURSE_SaveImgPath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				excellentVideo.setVideoImgPath(uploadimgFileName);  
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		excellentVideo.setVideoName(model.getVideoName());
		excellentVideoService.updatexcellentVideo(excellentVideo);
		return "excellentVideoList";
	}
	/**
	 * 删除视频
	 * @return
	 */
	public String deleteExcellentVideo(){
		ExcellentVideo excellentVideo = excellentVideoService.getById(model.getId());
		//删除 旧文件
		FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveVideoPath+excellentVideo.getVideoPath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
		FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveImgPath+excellentVideo.getVideoImgPath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
		excellentVideoService.deletexcellentVideo(model.getId());
		return "excellentVideoList";
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
	public File getUploadimg() {
		return uploadimg;
	}
	public void setUploadimg(File uploadimg) {
		this.uploadimg = uploadimg;
	}
	public String getUploadimgFileName() {
		return uploadimgFileName;
	}
	public void setUploadimgFileName(String uploadimgFileName) {
		this.uploadimgFileName = uploadimgFileName;
	}
	public String getUploadimgContentType() {
		return uploadimgContentType;
	}
	public void setUploadimgContentType(String uploadimgContentType) {
		this.uploadimgContentType = uploadimgContentType;
	}
	
}
