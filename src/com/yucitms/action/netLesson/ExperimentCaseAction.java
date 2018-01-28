package com.yucitms.action.netLesson;

import java.io.File;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.yucitms.action.BaseAction;
import com.yucitms.config.Config;
import com.yucitms.orm.netLesson.ExcellentCourse;
import com.yucitms.orm.netLesson.ExperimentCase;
import com.yucitms.orm.netLesson.ExperimentCase;
import com.yucitms.util.FtpUtil;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;
import com.yucitms.util.UpLoadUtil;

/**
 * 实训案例			
 * @author qiangzi
 *
 */
public class ExperimentCaseAction extends BaseAction<ExperimentCase>{
	
	/////////////////////后台
	private Integer courseId;
	private String uploadFileName;
	private File upload;
	private String uploadContentType;
	/**
	 * 教师团队列表
	 * @return
	 */
	public String getExperimentCaseList(){
		HqlHelper hqlHelper = new HqlHelper(ExperimentCase.class, "et");
		hqlHelper.addWhereCondition("et.course.id=?", courseId);
		hqlHelper.addWhereCondition(model.getName()!=null&&!model.getName().equals(""), "et.teacherName like ?","%"+model.getName()+"%");
		PageBean pageBean=experimentCaseService.getExperimentCaseList(pageNum,Config.EXCELLENTCOURSE_PageSize, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "getExperimentCaseList";
	}
	/**
	 * 添加教师
	 * @return
	 */
	public String addExperimentCasePage(){
		return "addExperimentCasePage";
	}
	public String addExperimentCase(){
		System.out.println("文件名称"+uploadFileName);
		try {
			uploadFileName=UpLoadUtil.Upload_FtpOrLocal(Config.UPLOAD_method, uploadFileName, upload, Config.EXCELLENTCOURSE_SaveFilePath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
			model.setFilePath(uploadFileName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ExcellentCourse course=excellentCourseService.getById(courseId);
		model.setCourse(course);
		model.setCreateDate(new Date());
		experimentCaseService.addExperimentCase(model);
		return "experimentCaseList";
	}
	/**
	 * 更新
	 */
	public String updateExperimentCasePage(){
		System.out.println("获取到的id"+model.getId());
		ExperimentCase ExperimentCase = experimentCaseService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(ExperimentCase);
		return "updateExperimentCasePage";
	}
	public String updateExperimentCase(){
		ExperimentCase experimentCase = experimentCaseService.getById(model.getId());
		try {
			if(upload!=null){
				//删除 旧文件
				FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveFilePath+experimentCase.getFilePath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				uploadFileName=UpLoadUtil.Upload_FtpOrLocal(Config.UPLOAD_method, uploadFileName, upload, Config.EXCELLENTCOURSE_SaveFilePath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				experimentCase.setFilePath(uploadFileName);  				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		experimentCase.setName(model.getName());
		
		experimentCaseService.updatExperimentCase(experimentCase);
		return "experimentCaseList";
	}
	/**
	 * 删除
	 * @return
	 */
	public String deleteExperimentCase(){
		ExperimentCase experimentCase = experimentCaseService.getById(model.getId());
		//删除 旧文件
		FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveFilePath+experimentCase.getFilePath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
		experimentCaseService.deleteExperimentCase(model.getId());
		return "experimentCaseList";
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
