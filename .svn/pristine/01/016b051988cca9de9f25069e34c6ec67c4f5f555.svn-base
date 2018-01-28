package com.yucitms.action.netLesson;

import java.io.File;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.yucitms.action.BaseAction;
import com.yucitms.config.Config;
import com.yucitms.orm.netLesson.ExcellentCourse;
import com.yucitms.orm.netLesson.ExcellentVideo;
import com.yucitms.orm.netLesson.ExpandApplication;
import com.yucitms.util.FileOpreationUtil;
import com.yucitms.util.FtpUtil;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;
import com.yucitms.util.UpLoadUtil;

public class ExpandApplicationAction extends BaseAction<ExpandApplication> {
	// //////////////////////////////////后台
	private Integer courseId;
	private String uploadFileName;
	private File upload;
	private String uploadContentType;

	/**
	 * 视频列表
	 * 
	 * @return
	 */
	public String getExpandApplicationList() {
		HqlHelper hqlHelper = new HqlHelper(ExpandApplication.class, "et");
		hqlHelper.addWhereCondition("et.course.id=?", courseId);
		hqlHelper.addWhereCondition(model.getName() != null
				&& !model.getName().equals(""), "et.name like ?", "%"
				+ model.getName() + "%");
		PageBean pageBean = expandApplicationService.getExpandApplicationList(pageNum,
				Config.EXCELLENTCOURSE_PageSize, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "getExpandApplicationList";
	}

	/**
	 * 添加视频
	 * 
	 * @return
	 */
	public String addExpandApplicationPage() {
		return "addExpandApplicationPage";
	}

	public String addExpandApplication() {
		System.out.println("文件名称" + uploadFileName);
		try {
			uploadFileName = FileOpreationUtil.modifyFileName(uploadFileName);
			model.setOldFilePath(uploadFileName);
			uploadFileName=UpLoadUtil.uploadOfficToSwf(Config.UPLOAD_ftp, uploadFileName, upload, Config.TEMP_path, Config.EXCELLENTCOURSE_SaveFilePath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
			
			model.setFilePath(uploadFileName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ExcellentCourse course = excellentCourseService.getById(courseId);
		model.setCourse(course);
		model.setCreateDate(new Date());
		expandApplicationService.addExpandApplication(model);
		return "expandApplicationList";
	}

	/**
	 * 更新视频
	 */
	public String updateExpandApplicationPage() {
		System.out.println("获取到的id" + model.getId());
		ExpandApplication expandApplication = expandApplicationService.getById(model
				.getId());
		ActionContext.getContext().getValueStack().push(expandApplication);
		return "updateExpandApplicationPage";
	}

	public String updateExpandApplication() {
		ExpandApplication expandApplication = expandApplicationService.getById(model
				.getId());
		try {
			if (upload != null) {
				uploadFileName = FileOpreationUtil.modifyFileName(uploadFileName);
				//删除 旧文件
				FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveFilePath+expandApplication.getFilePath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveFilePath+expandApplication.getOldFilePath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				expandApplication.setOldFilePath(uploadFileName);
				uploadFileName=UpLoadUtil.uploadOfficToSwf(Config.UPLOAD_ftp, uploadFileName, upload, Config.TEMP_path, Config.EXCELLENTCOURSE_SaveFilePath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				
				expandApplication.setFilePath(uploadFileName);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		expandApplication.setName(model.getName());
		expandApplicationService.updateExpandApplication(expandApplication);
		return "expandApplicationList";
	}

	/**
	 * 删除视频
	 * 
	 * @return
	 */
	public String deleteExpandApplication() {
		ExpandApplication expandApplication = expandApplicationService.getById(model
				.getId());
		//删除 旧文件
		FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveFilePath+expandApplication.getOldFilePath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
		FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveFilePath+expandApplication.getFilePath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
		expandApplicationService.deleteExpandApplication(model.getId());
		return "expandApplicationList";
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
