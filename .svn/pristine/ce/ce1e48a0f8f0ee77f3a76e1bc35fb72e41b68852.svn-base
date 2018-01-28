package com.yucitms.util;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.yucitms.config.Config;

/**
 * 上传工具类
 * @author qiangzi
 *
 */
public class UpLoadUtil {
	/**
	 * 上传文件至本地
	 * @param type 上传方式
	 * @param uploadFileName 文件名
	 * @param uploadFile	文件
	 * @param savePath	保存路径
	 * @param ftp_address ftp地址
	 * @param ftp_uase ftp账号
	 * @param ftp_pas  ftp密码
	 */
	public static String Upload_FtpOrLocal(String type,String uploadFileName,File uploadFile,String savePath,String ftp_address,String ftp_uase,String ftp_pas){
		uploadFileName = FileOpreationUtil.modifyFileName(uploadFileName);
		try {
			if(type.equals(Config.UPLOAD_ftp)){
				FileInputStream fis = new FileInputStream(uploadFile);
				FtpUtil.FtpUpload(fis, uploadFileName,ftp_address , ftp_uase, ftp_pas, savePath);
			}else{
				FileOutputStream fos = new FileOutputStream(savePath+uploadFileName);
				FileInputStream fis = new FileInputStream(uploadFile);
				byte [] a = new byte[9024];
				int length = 0;
				while((length=fis.read(a))>0){
					fos.write(a, 0, length);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return uploadFileName;
	}
	/**
	 * 临时文件保存至文件服务器
	 * @param filePath 文件全路径
	 * @param uploadFileName 文件名
	 * @param ftp_savePath	保存位置
	 * @param ftp_address	ftp地址
	 * @param ftp_uase		ftp账号	
	 * @param ftp_pas		ftp密码
	 */
	public static void temporaryFiles(String filePath,String uploadFileName,String ftp_savePath,String ftp_address,String ftp_uase,String ftp_pas){
		try {
			FileInputStream fis = new FileInputStream(new File(filePath));
			FtpUtil.FtpUpload(fis, uploadFileName,ftp_address , ftp_uase, ftp_pas, ftp_savePath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	/**
	 * 把上传为office文件转换为swf文件
	 * @param type	指文件保存至本地还是ftp
	 * @param uploadFileName	文件名
	 * @param uploadFile	文件
	 * @param temp_path		临时文件路径 注意：当上传至本地时此处为null
	 * @param savePath		文件最终报错路径
	 * @param ftp_address	ftp地址
	 * @param ftp_uase		ftp账号
	 * @param ftp_pas		ftp密码
	 * @return
	 */
	public static String uploadOfficToSwf(String type,String uploadFileName,File uploadFile,String temp_path,String savePath,String ftp_address,String ftp_uase,String ftp_pas){
		
		try {
			if(type.equals(Config.UPLOAD_ftp)){
				FileOutputStream fos = new FileOutputStream(temp_path+uploadFileName);
				FileInputStream fis = new FileInputStream(uploadFile);
				byte [] a = new byte[9024];
				int length = 0;
				while((length=fis.read(a))>0){
					fos.write(a, 0, length);
				}
				fis.close();
				fos.close();
				//保存原件至服务器
				temporaryFiles(temp_path+uploadFileName, uploadFileName, savePath, ftp_address, ftp_uase, ftp_pas);
				
				DocConverter converter = new DocConverter(temp_path+uploadFileName);
				if(converter.conver()){
					uploadFileName=uploadFileName.substring(0, uploadFileName.lastIndexOf("."));
					uploadFileName=uploadFileName+".swf";
					System.out.println(uploadFileName);
					//保存转化后的文件至服务器
					temporaryFiles(temp_path+uploadFileName, uploadFileName, savePath, ftp_address, ftp_uase, ftp_pas);
				}
				return uploadFileName;
			}else{
				FileOutputStream fos = new FileOutputStream(savePath+uploadFileName);
				FileInputStream fis = new FileInputStream(uploadFile);
				byte [] a = new byte[9024];
				int length = 0;
				while((length=fis.read(a))>0){
					fos.write(a, 0, length);
				}
				DocConverter converter = new DocConverter(savePath+uploadFileName);
				converter.conver();
				uploadFileName=uploadFileName.substring(0, uploadFileName.lastIndexOf("."));
				uploadFileName=uploadFileName+".swf";
				return uploadFileName;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "错误";
		}
	}
	
	/**
	 * 把上传为office文件转换为swf文件
	 * @param type	指文件保存至本地还是ftp
	 * @param uploadFileName	文件名
	 * @param uploadFile	文件
	 * @param temp_path		临时文件路径 注意：当上传至本地时此处为null
	 * @param savePath		文件最终报错路径
	 * @param ftp_address	ftp地址
	 * @param ftp_uase		ftp账号
	 * @param ftp_pas		ftp密码
	 * @return
	 */
	public static String uploadOfficToSwf_update(String type,String uploadFileName,File uploadFile,String temp_path,String savePath,String ftp_address,String ftp_uase,String ftp_pas){
		
		try {
			if(type.equals(Config.UPLOAD_method)){
				FileOutputStream fos = new FileOutputStream(temp_path+uploadFileName);
				FileInputStream fis = new FileInputStream(uploadFile);
				byte [] a = new byte[9024];
				int length = 0;
				while((length=fis.read(a))>0){
					fos.write(a, 0, length);
				}
				fis.close();
				fos.close();
				//保存原件至服务器
				temporaryFiles(temp_path+uploadFileName, uploadFileName, savePath, ftp_address, ftp_uase, ftp_pas);
				DocConverter converter = new DocConverter(temp_path+uploadFileName);
				if(converter.conver()){
					uploadFileName=uploadFileName.substring(0, uploadFileName.lastIndexOf("."));
					uploadFileName=uploadFileName+".swf";
					System.out.println(uploadFileName);
					//保存转化后的文件至服务器
					temporaryFiles(temp_path+uploadFileName, uploadFileName, savePath, ftp_address, ftp_uase, ftp_pas);
				}
				return uploadFileName;
			}else{
				FileOutputStream fos = new FileOutputStream(savePath+uploadFileName);
				FileInputStream fis = new FileInputStream(uploadFile);
				byte [] a = new byte[9024];
				int length = 0;
				while((length=fis.read(a))>0){
					fos.write(a, 0, length);
				}
				DocConverter converter = new DocConverter(savePath+uploadFileName);
				converter.conver();
				uploadFileName=uploadFileName.substring(0, uploadFileName.lastIndexOf("."));
				uploadFileName=uploadFileName+".swf";
				return uploadFileName;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "错误";
		}
	}
}