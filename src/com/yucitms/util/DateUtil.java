package com.yucitms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 时间辅助
 * @author Administrator
 *
 */
public class DateUtil {
	/**
	 * 获取年月日
	 * @param date
	 * @return
	 */
	public static String getYMD(Date date){
		if(date==null){
	        return "无";			
			}else{
				
				SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String datestr= sFormat.format(date);
				String datestrs[]=datestr.split(" ");
				return datestrs[0];
			}
	}
	/**
	 * 获取时分秒
	 * @param date
	 * @return
	 */
	public static String getHMS(Date date){
		if(date==null){
        return "无";			
		}else{
			
			SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String datestr= sFormat.format(date);
			String datestrs[]=datestr.split(" ");
			return datestrs[1];
		}
	}
	public static void main(String[] args) {
		System.out.println(DateUtil.getHMS(new Date()));
		System.out.println(DateUtil.getYMD(new Date()));
	}
	/**
	 * 时间辅助   字符串转化为Date
	 * @throws ParseException
	 */
	public static Date[] StringToDate(String start,String end,Date startDate,Date endDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			endDate = sdf.parse(end);
			startDate = sdf.parse(start);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date dates[] = new Date[2];
		dates[0]=startDate;
		dates[1]=endDate;
		return dates;
	}
}
