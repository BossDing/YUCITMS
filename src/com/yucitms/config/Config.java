package com.yucitms.config;

/**
 * 用于配置apache路径
 * 
 * @author qiangzi
 * 
 */
public class Config {
	/**
	 * FTP配置
	 */
	public static String UPLOAD_ftp = "FTP";// 单独文件服务器
	public static String UPLOAD_local = "LOACL";// 本地服务器
	public static String DOWNLOAD_ftp = "FTP";// 单独文件服务器
	public static String DOWNLOAD_local = "LOACL";// 本地服务器
	public static String DELETE_ftp = "FTP";// 单独文件服务器
	public static String DELETE_local = "LOACL";// 本地服务器
	public static String FTP_addrss = "172.20.28.240";
	public static String FTP_username = "administrator";
	public static String FTP_password = "administrator";
	/**
	 * 临时文件路径
	 */
	public static String TEMP_path = "d:/temp/";// 
	/**
	 * 精品课程
	 */
	public static int EXCELLENTCOURSE_PageSize = 10;// 精品课程每页内容
	// 精品课程上传路径
	public static String EXCELLENTCOURSE_SaveImgPath = "/ExcellentCourse/img/";// 精品课程路径
	public static String EXCELLENTCOURSE_SaveVideoPath = "/ExcellentCourse/video/";// 视频路径
	public static String EXCELLENTCOURSE_SaveFilePath = "/ExcellentCourse/file/";// 文件路径
	// 使用apache服务器图片路径
	public static String EXCELLENTCOURSE_ImgPath_Apache = "http://172.20.28.240:8088/web/YUCITMS/ExcellentCourse/img";// 精品课程路径
	// //使用apache服务器视频路径
	public static String EXCELLENTCOURSE_VideoPath_Apache = "http://172.20.28.240:8088/web/YUCITMS/ExcellentCourse/video";// 视频路径
	// //使用apache服务器文档路径
	public static String EXCELLENTCOURSE_FilePath_Apache = "http://172.20.28.240:8088/web/YUCITMS/ExcellentCourse/file";// 视频路径
	/**
	 * 页面最终显示 可修改
	 */
	public static String EXCELLENTCOURSE_ImgPath = EXCELLENTCOURSE_ImgPath_Apache;
	public static String EXCELLENTCOURSE_VideoPath = EXCELLENTCOURSE_VideoPath_Apache;
	public static String EXCELLENTCOURSE_FilePath = EXCELLENTCOURSE_FilePath_Apache;
	/**
	 * 下载路径
	 */
	public static String EXCELLENTCOURSE_downFilePath = "ExcellentCourse/file";
	// 上传文件的方式
	public static String UPLOAD_method = UPLOAD_ftp;
	// 上传文件的方式
    public static String DOWNLOAD_method = DOWNLOAD_ftp;
	// 删除文件方式
    public static String DELETE_method = DELETE_ftp;
    
    
    ///////////论坛设置
    public static int BBS_pageSize = 10;
    /**
     * 实训
     */
    public static int PAGENUM = 1;
    public static String PRACTICALTRAINING_SaveFilePath = "/PracticalTraining/file/";// 文件路径
 // //使用apache服务器文档路径
 	public static String PRACTICALTRAINING_FilePath_Apache = "http://172.20.28.240:8088/web/YUCITMS/PracticalTraining/file";// 视频路径
}
