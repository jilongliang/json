package ivyy.taobao.com.utils;

import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *@Author:liangjilong
 *@Date:2015-1-4
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description
 */
public class GlobalConstants {
	
	/***
	 * 获取url连接
	 * @param page第几页
	 * @param format格式（XML、JSON）
	 * @return
	 */
	public static String getSinaNewUrl(Integer page,String format){
		StringBuffer buffer=new StringBuffer("http://api.roll.news.sina.com.cn/zt_list?channel=news");
		String url="";
		buffer.append("&cat_1=shxw");//显示新闻
		buffer.append("&cat_2==zqsk||=qwys||=shwx||=fz-shyf");
		buffer.append("&level==1||=2");//级别
		buffer.append("&show_ext=1");
		buffer.append("&show_all=1");//显示所有
		buffer.append("&show_num=22");//显示多少条
		buffer.append("&tag=1");
		buffer.append("&format="+format);
		buffer.append("&page="+page);
		buffer.append("&callback=newsloader");
		url=buffer.toString();
		return url;
	}
	
	/***
	 * 获取百度地图的url
	 * @param ak秘钥即你在百度申请的key调用访问地图的key
	 * @param location地方的经纬度
	 * @param format格式（json或者xml）
	 * @return
	 */
	public static String getBaiduMapUrl(String ak,String location,String format){
		StringBuffer buffer=new StringBuffer("http://api.map.baidu.com/geocoder/v2/?");
		String url="";
		buffer.append("ak="+ak);
		buffer.append("&callback=renderReverse");
		buffer.append("&location="+location);
		buffer.append("&output="+format);
		buffer.append("&pois=1");
		url=buffer.toString();
		
		return url;
	}
	
	/***
	 * 获取文章的内容
	 * 从新浪的网页分析，通过文章body的id就可以拿到相应的文章内容..
	 * @param url
	 * @return
	 */
	public static String getNewsContent(String url) throws Exception{
		Document doc=Jsoup.parse(new URL(url), 3000);
		if(doc!=null){
			String artibody=doc.getElementById("artibody").html();//通过网页的html的id去拿到新闻内容artibody
			return artibody;
		}else{
			return "网络异常";
		}
	}
}
