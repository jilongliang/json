package ivyy.taobao.com.domain.fackjson;

import ivyy.taobao.com.entity.About;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *@Author:liangjl
 *@Date:2015-1-5
 *@Version:1.0
 *@Description:
 */
public class JackJson2 {
	private static ObjectMapper objMapper=new ObjectMapper();
	
	public static void main(String[] args)throws Exception {
		
		/***
		 * 第一个对象
		 */
		Map<String,String> about=new HashMap<String, String>();
		about.put("weixin", "YFDSBUYI");
		about.put("weibo", "http://weibo.com/resourcesljl");
		about.put("email", "buyee_hr@126.com");
		about.put("qq", "1302128216");
		about.put("address", "广东省云浮市云城区闻莺路39号");
		
 
		/***
		 * 第二个对象
		 */
		Map<String,String> user=new HashMap<String, String>();
		user.put("age", "25");
		user.put("sex", "女士");
		user.put("userName", "小陈");
		user.put("taobao", "http://ivyy.taobao.com");
		user.put("address", "广东省云浮市云城区闻莺路39号");
		
		
		Map<Object,Object> listObj=new HashMap<Object, Object>();
		
		
		listObj.put("about", about);
		listObj.put("user", user);
		
	/*	String path="d:/test/json.txt";
		
		File f=new File(path);
		
		if(!f.exists()){
			f.createNewFile();
			objMapper.writeValue(f, listObj);//jackjson是以json形式写入文件
		}
		*/
		
		String jsonStr=listObj.toString().replaceAll("=", ":");
		
		System.out.println(jsonStr);
		
		 
	}
}
