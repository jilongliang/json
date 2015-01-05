package ivyy.taobao.com.domain.gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.stream.JsonReader;

/**
 *@Date:2015-1-5
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description：
 */
public class GsonTreeReader {
	private static Gson gson = new Gson();
	public static void main(String[] args) throws Exception {
		/**
		  * 组装address对象的数据
		  */
		 Map<String, String> address = new HashMap <String, String>(); 
		 
		 address.put("country", "中国");
		 address.put("province", "广东省");
		 address.put("city", "云浮市");
		 address.put("district", "云城区闻莺路东升布艺");
		 address.put("street", "闻莺路");
			
		 /**
		  * 组装users对象的数据
		  */
		 Map<String, String> users = new HashMap <String, String>(); 
		 users.put("username", "liangjilong");
		 users.put("age", "25");
		 users.put("tel", "12396878");
		 users.put("email", "jilongliang@sina.com"); 
		 
		 Map<Object, Object> listsObj = new HashMap <Object, Object>(); 
		 listsObj.put("address",address);//address节点
		 listsObj.put("users",users);//users节点
		 
		 Object obj=listsObj;//转换成对象
		 
		 Map<Object, Object> info = new HashMap <Object, Object>(); 
		 info.put("info", obj);//json的根节点
		 
		 
        String json=gson.toJson(info);//转换成json数据
        System.out.println(json);//打印json数据
		
		readJsonData(json);
		
	}
	/**JsonReader
	 * JsonTreeReader从文件读取json数据
	 * @param in
	 * @throws Exception
	 */
	public static void readJsonData(String json) throws Exception {
		//创建JsonParser对象
		JsonParser parser = new JsonParser();
		JsonElement jsonEl = parser.parse(json);
		//创建一个JsonTreeReader对像用JsonReader
		JsonReader reader = new JsonTreeReader(jsonEl);
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
