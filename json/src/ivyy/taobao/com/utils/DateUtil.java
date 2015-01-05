package ivyy.taobao.com.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 *@Author:jilongliang
 *@Email:jilongliang@sina.com
 *@Date:2015-1-5
 *@CopyRight:liangjilong
 *@Description:DateUtil处理类
 */
public class DateUtil extends org.apache.commons.lang.time.DateUtils{
	/**
	 * 将微信消息中的CreateTime转换成标准格式的时间（yyyy-MM-dd HH:mm:ss）
	 * 
	 * @param createTime
	 *            消息创建时间
	 * @return
	 */
	public static String formatTime(String createTime) {
		// 将微信传入的CreateTime转换成long类型，再乘以1000
		long msgCreateTime = Long.parseLong(createTime) * 1000L;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date(msgCreateTime));
	}
	/** 
     * 获取前/后n天日期(M月d日) 
     *  
     * @return 
     */  
    public static String getMonthDay(int diff) {  
        DateFormat df = new SimpleDateFormat("M月d日");  
        Calendar c = Calendar.getInstance();  
        c.add(Calendar.DAY_OF_YEAR, diff);  
        return df.format(c.getTime());  
    }  
	/**
	 * 获取时间
	 * @return
	 */
	public static long getCreateTime(){
		return new Date().getTime();
	}
	

	
	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss" };

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	/**
	 * 日期型字符串转化为日期 格式（"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss" ）
	 */
	public static Date parseDate(String str) {
		try {
			return parseDate(str, parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(24*60*60*1000);
	}
	
	/**
	 * s1对比s2 两个日期的大小
	 * @param s1                     日期 字符串
	 * @param s2                     日期 字符串
	 * @param pattern   格式
	 * @return          返回 负数s1小 ，返回0两数相等，返回正整数s1大
	 */
	public static int compare(String s1, String s2, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		try {
			c1.setTime(df.parse(s1));
			c2.setTime(df.parse(s2));
		} catch (Exception e) {
			System.err.println("日期格式不正确");
		}
		return c1.compareTo(c2); 
	}
	
	/********************新增时间-------------------------******************/
	
	/**
	 * 用来处理时间转换格式的方法
	 * @param formate
	 * @param time
	 * @return
	 */
	private static String getConvertDateFormat(String formate, Date time) {
		SimpleDateFormat dateFormat=new SimpleDateFormat(formate);
		String date=dateFormat.format(time);
		return date;
	}
	/**  
	 * 得到本月的第一天  
	 * @return  
	 */  
	public static String getCurrentMonthFirstDay() { 
	    Calendar calendar = Calendar.getInstance();   
	    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));   
	    return getConvertDateFormat("yyyy-MM-dd", calendar.getTime());   
	}   
	  
	/**  
	 * 得到本月的最后一天  
	 *   
	 * @return  
	 */  
	public static String getCurrentMonthLastDay() {   
	    Calendar calendar = Calendar.getInstance();   
	    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));   
	    return getConvertDateFormat("yyyy-MM-dd", calendar.getTime());   
	}   
	/**
	 * 
	 * 获取上个月的第一天
	 * 
	 * @return
	 */
	public static String getBeforeMonthFirstDay() {
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int year = 0;
		int month = cal.get(Calendar.MONTH); // 上个月月份
		int day = cal.getActualMinimum(Calendar.DAY_OF_MONTH);//起始天数

		if (month == 0) {
			year = cal.get(Calendar.YEAR) - 1;
			month = 12;
		} else {
			year = cal.get(Calendar.YEAR);
		}
		String endDay = year + "-" + month + "-" + day;
		return endDay;
	}

	/**
	 * 获取上个月的最一天
	 * 
	 * @return
	 */
	public static String getBeforeMonthLastDay() {
		//实例一个日历单例对象
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int year = 0;
		int month = cal.get(Calendar.MONTH); // 上个月月份
		// int day1 = cal.getActualMinimum(Calendar.DAY_OF_MONTH);//起始天数
		int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 结束天数

		if (month == 0) {
			//year = cal.get(Calendar.YEAR) - 1;
			month = 12;
		} else {
			year = cal.get(Calendar.YEAR);
		}
		String endDay = year + "-" + month + "-" + day;
		return endDay;
	}
	
	/**
	 * 
	 * 获取下月的第一天
	 * 
	 * @return
	 */
	public static String getNextMonthFirstDay() {
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int year = 0;
		int month = cal.get(Calendar.MONDAY)+2; // 下个月月份
		/*
		 * 如果是这样的加一的话代表本月的第一天
		 * int month = cal.get(Calendar.MONDAY)+1; 
		 * int month = cal.get(Calendar.MONTH)+1
		 */
		int day = cal.getActualMinimum(Calendar.DAY_OF_MONTH);//起始天数

		if (month == 0) {
			year = cal.get(Calendar.YEAR) - 1;
			month = 12;
		} else {
			year = cal.get(Calendar.YEAR);
		}
		String Day = year + "-" + month + "-" + day;
		return Day;
	}

	/**
	 * 获取下个月的最一天
	 * 
	 * @return
	 */
	public static String getNextMonthLastDay() {
		//实例一个日历单例对象
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int year = 0;
		int month = cal.get(Calendar.MONDAY)+2; // 下个月份
		// int day1 = cal.getActualMinimum(Calendar.DAY_OF_MONTH);//起始天数
		int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 结束天数

		if (month == 0) {
			//year = cal.get(Calendar.YEAR) - 1;
			month = 12;
		} else {
			year = cal.get(Calendar.YEAR);
		}
		String endDay = year + "-" + month + "-" + day;
		return endDay;
	}

	/**
	 * 本地时区输出当前日期 GMT时间
	 */
	public static String getLocalDate() {
		Date date = new Date();
		return date.toLocaleString();// date.toGMTString();
	}
	/**
	 * 判断客户端输入的是闰年Leap还是平年Average
	 * @return
	 */
	public static String getLeapOrAverage (int year){
		
		if((year%4==0 && year%100!=0)||year%400==0){
			return year+"闰年";
		}else{
			return year+"平年";
		}
	}
	/**
	 * 
	 * @return
	 */
	public static String getYYYYMMddHHmmss(){
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//String currentTime=df.format(new Date());
		Calendar calendar = Calendar.getInstance();
		
		return df.format(calendar.getTime());
		
	}
	public static DateFormat getYyyyMMddHHmmss(){
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df;
	}
	
	/**
	 * 传入的日期按照指定格式进行格式化
	 * @param date
	 * @param format（yyyy-MM-DD或yyyy/MM/DD或yyyy-MM-dd HH:mm:ss）
	 * @return String
	 */
	public static String formatDate(Date date, String format) {
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		return fmt.format(date);
	}
	/**
	 * 获取当前时间是本年的第几周
	 * @return
	 */
	public static String getWeeK_OF_Year(){
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int week=cal.get(Calendar.WEEK_OF_YEAR );
		return  "当日是本年的第"+week+"周";
	}
	/**
	 * 获取当日是本年的的第几天
	 * @return
	 */
	public static String getDAY_OF_YEAR(){
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int day=cal.get(Calendar.DAY_OF_YEAR );
		return  "当日是本年的第"+day+"天";
	}
	
	public static void main(String[] args) {
		System.out.println(getDate("yyyy-MM-dd"));
	}
}
