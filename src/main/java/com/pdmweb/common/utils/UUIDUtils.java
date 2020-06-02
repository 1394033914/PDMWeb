package com.pdmweb.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 获取主键方法
 * @author 
 *
 */
public class UUIDUtils {
	
	 /** 
	  *   生成主键(15位数字)
	  *  主键生成方式,年月日时分秒毫秒的时间戳 例如：180910094204299
     */ 
	public static synchronized Long getLongId(){
		try {
			TimeUnit.NANOSECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("YYMMddHHmmssSSS");
		return Long.parseLong(sdf.format(new Date()));
	}
	
	/** 
	  *   生成主键(20位数字)
	  *  主键生成方式,年月日时分秒毫秒的时间戳 例如：1810311557430000845
	  */ 
	public static synchronized Long getUUIDTOLongNew(){
		try {
			TimeUnit.NANOSECONDS.sleep(1000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("YYMMddHHmmssSSSSSSS"); //1810311557430000845
		return Long.parseLong(sdf.format(new Date()));
	}
}
