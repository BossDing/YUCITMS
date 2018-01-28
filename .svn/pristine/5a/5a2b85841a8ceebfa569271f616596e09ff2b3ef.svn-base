package com.yucitms.action.netLesson;

import java.io.File;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.yucitms.action.BaseAction;
import com.yucitms.config.Config;
import com.yucitms.orm.netLesson.ExcellentCourse;
import com.yucitms.orm.netLesson.ExcellentTeacher;
import com.yucitms.orm.netLesson.ImgCarousel;
import com.yucitms.util.FtpUtil;
import com.yucitms.util.HqlHelper;
import com.yucitms.util.PageBean;
import com.yucitms.util.UpLoadUtil;

public class ImgCarouselAction extends BaseAction<ImgCarousel> {
	// /////////////////后台
	private Integer courseId;
	private String uploadFileName;
	private File upload;
	private String uploadContentType;

	/**
	 * 教师团队列表
	 * 
	 * @return
	 */
	public String getImgCarouselList() {
	
		HqlHelper hqlHelper = new HqlHelper(ImgCarousel.class, "et");
		hqlHelper.addWhereCondition("et.course.id=?", courseId);
		PageBean pageBean = imgCarouselService.getImgCarouselList(
				pageNum, Config.EXCELLENTCOURSE_PageSize, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "getImgCarouselList";
	}

	/**
	 * 添加教师
	 * 
	 * @return
	 */
	public String addImgCarouselPage() {
		return "addImgCarouselPage";
	}

	public String addImgCarousel() {
		System.out.println("文件名称" + uploadFileName);
		try {
			uploadFileName = UpLoadUtil
					.Upload_FtpOrLocal(Config.UPLOAD_method, uploadFileName,
							upload, Config.EXCELLENTCOURSE_SaveImgPath,
							Config.FTP_addrss, Config.FTP_username,
							Config.FTP_password);
			model.setImgPath(uploadFileName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ExcellentCourse course = excellentCourseService.getById(courseId);
		model.setCourse(course);
		model.setCreateDate(new Date());
		imgCarouselService.addImgCarousel(model);
		return "imgCarouselList";
	}

	/**
	 * 更新
	 */
	public String updateImgCarouselPage() {
		
		ImgCarousel imgCarousel = imgCarouselService
				.getById(model.getId());
		ActionContext.getContext().getValueStack().push(imgCarousel);
		return "updateImgCarouselPage";
	}

	public String updateImgCarousel() {
		ImgCarousel imgCarousel = imgCarouselService.getById(model.getId());
		try {
			if (upload != null) {
				//删除 旧文件
				FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveImgPath+imgCarousel.getImgPath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);
				
				uploadFileName = UpLoadUtil.Upload_FtpOrLocal(
						Config.UPLOAD_method, uploadFileName, upload,
						Config.EXCELLENTCOURSE_SaveImgPath, Config.FTP_addrss,
						Config.FTP_username, Config.FTP_password);
				imgCarousel.setImgPath(uploadFileName);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		imgCarousel.setImgExplain(model.getImgExplain());
		imgCarouselService.updateImgCarousel(imgCarousel);
		return "imgCarouselList";
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteImgCarousel() {
		ImgCarousel imgCarousel = imgCarouselService.getById(model.getId());
				//删除 旧文件
        FtpUtil.delete_file(Config.DELETE_method,Config.EXCELLENTCOURSE_SaveImgPath+imgCarousel.getImgPath(), Config.FTP_addrss, Config.FTP_username, Config.FTP_password);	
		imgCarouselService.deleteImgCarousel(model.getId());
		return "imgCarouselList";
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
