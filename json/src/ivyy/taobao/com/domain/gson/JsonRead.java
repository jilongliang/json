package ivyy.taobao.com.domain.gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

/**
 *@DEMO:napp
 *@Author:jilongliang
 *@Date:2013-7-20
 */
public class JsonRead {
	private static Gson gson=new Gson();
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		 getJsonData();
         
        //方法二
        //String pathname="src/config/doc/json";
 		//InputStream input = new FileInputStream(new File(pathname));
 		//readJsonData(input,null);
	}
	/**
	 * 组装Json数据
	 * @throws Exception
	 */
	private static void getJsonData() throws Exception {
		/**
		  * 组装address对象的数据
		  */
		 Map<String, String> address = new HashMap <String, String>(); 
		 address.put("province", "广东省");
		 address.put("city", "云浮市");
		 address.put("district", "云城区");
		 address.put("street", "云城区闻莺路东升布艺"); 
		 /**
		  * 组装users对象的数据
		  */
		 Map<String, String> users = new HashMap <String, String>(); 
		 users.put("username", "liangjilong");
		 users.put("age", "25");
		 users.put("tel", "1369711900");
		 users.put("email", "jilongliang@sina.com"); 
		 
		 Map<Object, Object> listsObj = new HashMap <Object, Object>(); 
		 listsObj.put("address",address);//address节点
		 listsObj.put("users",users);//users节点
		 
		 Object obj=listsObj;//转换成对象
		 
		 Map<Object, Object> info = new HashMap <Object, Object>(); 
		 info.put("info", obj);//json的根节点
		 
		 
         String json=gson.toJson(info);//转换成json数据
         System.out.println(json);//打印json数据
         readJsonData(null,json);
	}
	/**
	 * 从文件读取json数据
	 * @param in
	 * @throws Exception
	 */
	public static void readJsonData(InputStream in,String json) throws Exception {
		//JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
		JsonReader reader = new JsonReader(new StringReader(json));
		try {
			reader.beginObject();
			String tagName = reader.nextName();
			if (tagName.equals("info")) {
				readInfo(reader);
			}
			reader.endObject();
		} finally {
			reader.close();
		}
	}
	/**
	 * 读取json的父(根,第一个)节点
	 * @param reader
	 * @throws Exception
	 */
	public static void readInfo(JsonReader reader) throws Exception {
		reader.beginObject();
		while (reader.hasNext()) {
			String tagName = reader.nextName();
			if (tagName.equals("address")) {
				readAddress(reader);
			} else if (tagName.equals("users")) {
				readUsers(reader);
			} 
		}
		reader.endObject();
	}
	/**
	 * 读取用户信息值
	 * @param reader
	 * @throws IOException
	 */
	public static void readUsers(JsonReader reader) throws IOException {
		reader.beginObject();
		while (reader.hasNext()) {
			String tag = reader.nextName();
			if (tag.equals("username")) {
				String username = reader.nextString();
				System.out.println("用户名:" + username);
			} else if (tag.equals("email")) {
				String email = reader.nextString();
				System.out.println("Email:" + email);
			} else if (tag.equals("tel")) {
				String tel = reader.nextString();
				System.out.println("电话:" + tel);
			}else if (tag.equals("age")) {
				String age = reader.nextString();
				System.out.println("年龄:" + age);
			} else {
				reader.skipValue();//忽略值/跳过break
			}
		}
		reader.endObject();
	}
	/**
	 * 读取地区值
	 * @param reader
	 * @throws IOException
	 */
	public static void readAddress(JsonReader reader) throws IOException {
		reader.beginObject();
		while (reader.hasNext()) {
			String tag = reader.nextName();
			if (tag.equals("province")) {
				String province = reader.nextString();
				System.out.println("省份:" + province);
			} else if (tag.equals("city")) {
				String city = reader.nextString();
				System.out.println("街道:" + city);
			} else if (tag.equals("street")) {
				String street = reader.nextString();
				System.out.println("街道:" + street);
			}else if (tag.equals("district")) {
				String district = reader.nextString();
				System.out.println("区:" + district);
			} else {
				reader.skipValue();//忽略值/跳过break
			}
		}
		reader.endObject();
	}
}

