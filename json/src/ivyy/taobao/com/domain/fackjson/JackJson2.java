package ivyy.taobao.com.domain.fackjson;

import ivyy.taobao.com.entity.ResultInfo;

import java.io.File;
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
 *@Description:http://jilongliang.iteye.com/blog/1924212
 */
public class JackJson2 {
	private static ObjectMapper mapper=new ObjectMapper();
	
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
		
		Object obj=listObj;//转换成对象
		
		Map<Object, Object> info = new HashMap <Object, Object>();   
        info.put("info", obj);//json的根节点  
         
		//String jsonStr=listObj.toString().replaceAll("=", ":");
		
	 	String path="d:/test/json1.txt";
		
		File f=new File(path);
		
		if(!f.exists()){
			f.createNewFile();
			mapper.writeValue(f, listObj);//jackjson是以json形式写入文件
		}
		 
		//String newJson=new Gson().toJson(info);  
		String newJson=mapper.writeValueAsString(info);
	    int start=newJson.indexOf(":")+1;  
	    int end=newJson.lastIndexOf("}");  
	    String jsonsText="["+newJson.substring(start, end)+"]";//组装JackSon支持的格式.   
        
		JsonFactory factory = new JsonFactory();//实例JSON工程对象  
        JsonParser jp = factory.createJsonParser(jsonsText);  
        jp.nextToken();//下一个JsonToken  
        while (jp.nextToken() == JsonToken.START_OBJECT) {  
        	ResultInfo inf = mapper.readValue(jp, ResultInfo.class);//对象化  
            System.out.println(inf.getAbout().getAddress());//获取Address对象的值  
            System.out.println(inf.getUser().getUserName());//获取User的值  
        }    
		
	}
}
