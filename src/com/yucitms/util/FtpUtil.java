package com.yucitms.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;

import com.yucitms.config.Config;

public class FtpUtil {
	  /** 
     * FTP上传单个文件测试 
     */ 
    public static void FtpUpload(FileInputStream inputStream,String filename,String ftp_address,String ftp_username,String ftp_password,String ftp_savePath) { 
        FTPClient ftpClient = new FTPClient(); 
        //FileInputStream fis = null; 

        try { 
            ftpClient.connect(ftp_address); 
            ftpClient.login(ftp_username, ftp_password); 

           /* File srcFile = new File("D:\\1.txt"); 
            fis = new FileInputStream(srcFile); */
            //设置上传目录 
            ftpClient.changeWorkingDirectory(ftp_savePath); 
            ftpClient.setBufferSize(1024); 
            ftpClient.setControlEncoding("Utf-8"); 
            //设置文件类型（二进制） 
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); 
            ftpClient.storeFile(filename, inputStream); 
        } catch (IOException e) { 
            e.printStackTrace(); 
            throw new RuntimeException("FTP客户端出错！", e); 
        } finally { 
            IOUtils.closeQuietly(inputStream); 
            try { 
                ftpClient.disconnect(); 
            } catch (IOException e) { 
                e.printStackTrace(); 
                throw new RuntimeException("关闭FTP连接发生异常！", e); 
            } 
        } 
    } 

    /**
     * 下载
     * @param downLoad_type  下载途径 
     * @param ftp_address	 ftp地址
     * @param ftp_username	 ftp账号
     * @param ftp_password	 ftp密码
     * @param ftp_downLoadPath	下载文件的全路径（包括文件本身）
     * @return
     */
    public static InputStream Download(String downLoad_type,String ftp_address,String ftp_username,String ftp_password,String ftp_downLoadPath) {     	
        InputStream inputStream=null;
        if(downLoad_type.endsWith(Config.DOWNLOAD_ftp)){
        	 FTPClient ftpClient = new FTPClient(); 
             try { 
                 ftpClient.connect(ftp_address); 
                 ftpClient.login(ftp_username, ftp_password);
                 String [] str=ftp_downLoadPath.split("/");
                 ftpClient.setBufferSize(1024); 
                 //设置文件类型（二进制） 
                 ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                 ftpClient.setFileTransferMode(FTPClient.COMPRESSED_TRANSFER_MODE);
                 ftpClient.setControlEncoding("UTF-8"); 
                 ftpClient.enterLocalPassiveMode();
                 inputStream =ftpClient.retrieveFileStream(ftp_downLoadPath);    
             } catch (IOException e) { 
                 e.printStackTrace(); 
                 throw new RuntimeException("FTP客户端出错！", e); 
             } finally { 
             	
             }
        }else{
        	 try {
        		 File file = new File(ftp_downLoadPath);  
				inputStream= FileUtils.openInputStream(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return inputStream; 
    } 
  /**
   * 删除文件
   * @param type 判断文件位置
   * @param url	 文件全路径
   * @param ftp_address ftp地址
   * @param ftp_username ftp账号
   * @param ftp_password	ftp密码
   */
    public static void delete_file(String type,String url,String ftp_address,String ftp_username,String ftp_password){
    	if(type.equals(Config.DELETE_ftp)){
    		try {
        		FTPClient ftpClient = new FTPClient();
           	 ftpClient.connect(ftp_address); 
                ftpClient.login(ftp_username, ftp_password);
           	 ftpClient.deleteFile(url);
    		} catch (Exception e) {
    			// TODO: handle exception
    		}

    	}else{
    		File file= new File(url);
    		if(file.isFile()){
    			file.delete();
    		}
    	}
    	    	
       }
}
