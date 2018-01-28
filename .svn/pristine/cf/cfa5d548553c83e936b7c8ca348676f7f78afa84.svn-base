package com.yucitms.action.netLesson;

import java.io.File;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.yucitms.action.BaseAction;
import com.yucitms.config.Config;
import com.yucitms.orm.netLesson.ExcellentCourse;
import com.yucitms.orm.netLesson.ExcellentTeacher;
import com.yucitms.orm.netLesson.LessionBook;
import com.yucitms.util.FtpUtil;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;
import com.yucitms.util.UpLoadUtil;

public class LessonBookAction extends BaseAction<LessionBook>{
	////////////////后台
	private Integer courseId;
	private String uploadFileName;
	private File upload;
	private String uploadContentType;
	/**
	 * 列表
	 * @return
	 */
	public String getLessonBookList(){
		HqlHelper hqlHelper = new HqlHelper(LessionBook.class, "lb");
		hqlHelper.addWhereCondition("lb.excellentCourse.id=?", courseId);
		hqlHelper.addWhereCondition(model.getBookName()!=null&&!model.getBookName().equals(""), "lb.bookName like ?","%"+model.getBookName()+"%");
		PageBean pageBean=lessionBookService.getLessonBookList(pageNum,Config.EXCELLENTCOURSE_PageSize, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "getLessonBookList";
	}
	/**
	 * 添加
	 */
	public String addLessonBookPage(){
		
		return "addLessonBookPage";
	}
	public String addLessonBook(){
		ExcellentCourse excellentCourse= excellentCourseService.getById(courseId);
		try {
			uploadFileName=UpLoadUtil.Upload_FtpOrLocal(Config.UPLOAD_method, uploadFileName, upload, Config.EXCELLENTCOURSE_SaveImgPath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
			model.setImgPath(uploadFileName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		model.setCreateDate(new Date());
		model.setExcellentCourse(excellentCourse);
		lessionBookService.addLessonBook(model);
		return "lessonBookList";
	}
	/**
	 * 修改
	 */
	public String updateLessonBookPage(){
		LessionBook book = lessionBookService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(book);
		return "updateLessonBookPage";
		
	}
	public String updateLessonBook(){
		LessionBook book = lessionBookService.getById(model.getId());
		try {
			if(upload!=null){
				 FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveImgPath+book.getImgPath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);	
				uploadFileName=UpLoadUtil.Upload_FtpOrLocal(Config.UPLOAD_method, uploadFileName, upload, Config.EXCELLENTCOURSE_SaveImgPath, Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				book.setImgPath(uploadFileName);  				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		book.setAuthor(model.getAuthor());
		book.setBookCode(model.getBookCode());
		book.setBookName(model.getBookName());
		book.setPublishingHouse(model.getPublishingHouse());
		lessionBookService.updateLessonBook(book);
		return "lessonBookList";
		
	}
	
	/**
	 * 删除
	 */
	public String deleteLessonBook(){
		LessionBook book = lessionBookService.getById(model.getId());
		FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveImgPath+book.getImgPath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);	
		lessionBookService.deleteLessonBook(model.getId());
		return "lessonBookList";
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
