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
 *@Description:DateUtil������
 */
public class DateUtil extends org.apache.commons.lang.time.DateUtils{
	/**
	 * ��΢����Ϣ�е�CreateTimeת���ɱ�׼��ʽ��ʱ�䣨yyyy-MM-dd HH:mm:ss��
	 * 
	 * @param createTime
	 *            ��Ϣ����ʱ��
	 * @return
	 */
	public static String formatTime(String createTime) {
		// ��΢�Ŵ����CreateTimeת����long���ͣ��ٳ���1000
		long msgCreateTime = Long.parseLong(createTime) * 1000L;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date(msgCreateTime));
	}
	/** 
     * ��ȡǰ/��n������(M��d��) 
     *  
     * @return 
     */  
    public static String getMonthDay(int diff) {  
        DateFormat df = new SimpleDateFormat("M��d��");  
        Calendar c = Calendar.getInstance();  
        c.add(Calendar.DAY_OF_YEAR, diff);  
        return df.format(c.getTime());  
    }  
	/**
	 * ��ȡʱ��
	 * @return
	 */
	public static long getCreateTime(){
		return new Date().getTime();
	}
	

	
	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss" };

	/**
	 * �õ���ǰ�����ַ��� ��ʽ��yyyy-MM-dd��
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
	/**
	 * �õ���ǰ�����ַ��� ��ʽ��yyyy-MM-dd�� pattern����Ϊ��"yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	 * �õ������ַ��� Ĭ�ϸ�ʽ��yyyy-MM-dd�� pattern����Ϊ��"yyyy-MM-dd" "HH:mm:ss" "E"
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
	 * �õ���ǰʱ���ַ��� ��ʽ��HH:mm:ss��
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * �õ���ǰ���ں�ʱ���ַ��� ��ʽ��yyyy-MM-dd HH:mm:ss��
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * �õ���ǰ����ַ��� ��ʽ��yyyy��
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * �õ���ǰ�·��ַ��� ��ʽ��MM��
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * �õ������ַ��� ��ʽ��dd��
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * �õ���ǰ�����ַ��� ��ʽ��E�����ڼ�
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	/**
	 * �������ַ���ת��Ϊ���� ��ʽ��"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss" ��
	 */
	public static Date parseDate(String str) {
		try {
			return parseDate(str, parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * ��ȡ��ȥ������
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(24*60*60*1000);
	}
	
	/**
	 * s1�Ա�s2 �������ڵĴ�С
	 * @param s1                     ���� �ַ���
	 * @param s2                     ���� �ַ���
	 * @param pattern   ��ʽ
	 * @return          ���� ����s1С ������0������ȣ�����������s1��
	 */
	public static int compare(String s1, String s2, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		try {
			c1.setTime(df.parse(s1));
			c2.setTime(df.parse(s2));
		} catch (Exception e) {
			System.err.println("���ڸ�ʽ����ȷ");
		}
		return c1.compareTo(c2); 
	}
	
	/********************����ʱ��-------------------------******************/
	
	/**
	 * ��������ʱ��ת����ʽ�ķ���
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
	 * �õ����µĵ�һ��  
	 * @return  
	 */  
	public static String getCurrentMonthFirstDay() { 
	    Calendar calendar = Calendar.getInstance();   
	    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));   
	    return getConvertDateFormat("yyyy-MM-dd", calendar.getTime());   
	}   
	  
	/**  
	 * �õ����µ����һ��  
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
	 * ��ȡ�ϸ��µĵ�һ��
	 * 
	 * @return
	 */
	public static String getBeforeMonthFirstDay() {
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int year = 0;
		int month = cal.get(Calendar.MONTH); // �ϸ����·�
		int day = cal.getActualMinimum(Calendar.DAY_OF_MONTH);//��ʼ����

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
	 * ��ȡ�ϸ��µ���һ��
	 * 
	 * @return
	 */
	public static String getBeforeMonthLastDay() {
		//ʵ��һ��������������
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int year = 0;
		int month = cal.get(Calendar.MONTH); // �ϸ����·�
		// int day1 = cal.getActualMinimum(Calendar.DAY_OF_MONTH);//��ʼ����
		int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // ��������

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
	 * ��ȡ���µĵ�һ��
	 * 
	 * @return
	 */
	public static String getNextMonthFirstDay() {
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int year = 0;
		int month = cal.get(Calendar.MONDAY)+2; // �¸����·�
		/*
		 * ����������ļ�һ�Ļ������µĵ�һ��
		 * int month = cal.get(Calendar.MONDAY)+1; 
		 * int month = cal.get(Calendar.MONTH)+1
		 */
		int day = cal.getActualMinimum(Calendar.DAY_OF_MONTH);//��ʼ����

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
	 * ��ȡ�¸��µ���һ��
	 * 
	 * @return
	 */
	public static String getNextMonthLastDay() {
		//ʵ��һ��������������
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int year = 0;
		int month = cal.get(Calendar.MONDAY)+2; // �¸��·�
		// int day1 = cal.getActualMinimum(Calendar.DAY_OF_MONTH);//��ʼ����
		int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // ��������

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
	 * ����ʱ�������ǰ���� GMTʱ��
	 */
	public static String getLocalDate() {
		Date date = new Date();
		return date.toLocaleString();// date.toGMTString();
	}
	/**
	 * �жϿͻ��������������Leap����ƽ��Average
	 * @return
	 */
	public static String getLeapOrAverage (int year){
		
		if((year%4==0 && year%100!=0)||year%400==0){
			return year+"����";
		}else{
			return year+"ƽ��";
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
	 * ��������ڰ���ָ����ʽ���и�ʽ��
	 * @param date
	 * @param format��yyyy-MM-DD��yyyy/MM/DD��yyyy-MM-dd HH:mm:ss��
	 * @return String
	 */
	public static String formatDate(Date date, String format) {
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		return fmt.format(date);
	}
	/**
	 * ��ȡ��ǰʱ���Ǳ���ĵڼ���
	 * @return
	 */
	public static String getWeeK_OF_Year(){
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int week=cal.get(Calendar.WEEK_OF_YEAR );
		return  "�����Ǳ���ĵ�"+week+"��";
	}
	/**
	 * ��ȡ�����Ǳ���ĵĵڼ���
	 * @return
	 */
	public static String getDAY_OF_YEAR(){
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int day=cal.get(Calendar.DAY_OF_YEAR );
		return  "�����Ǳ���ĵ�"+day+"��";
	}
	
	public static void main(String[] args) {
		System.out.println(getDate("yyyy-MM-dd"));
	}
}
