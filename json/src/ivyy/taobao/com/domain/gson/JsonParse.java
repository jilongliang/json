package ivyy.taobao.com.domain.gson;  
 
import ivyy.taobao.com.entity.Address;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *@DEMO:napp
 *@Author:jilongliang
 *@Date:2013-7-20
 */
public class JsonParse {  
	private static Gson gson=new Gson();
    /**
	 * 通过JsonLib把数组转换成Json数据
	 * @param url
	 * @throws Exception
	 */
	private static JSONArray getArrayToJsonByJsonLib()throws Exception
	{
		JSONArray jsonArr=null;
		List<Address> lists=new ArrayList<Address>();
		for (int i = 1; i <=12; i++) {
			Address addr = new Address(); 
			addr.setProvince("第"+i+"个省份");
			addr.setCity("第"+i+"个城市");
			addr.setCityCode("130"+i);
			addr.setStreet("街道"+i);
			addr.setStreetNumber("街道号码"+i);
			lists.add(addr);
		}
		jsonArr = JSONArray.fromObject(lists);  //把对象转换成Json对象
		return jsonArr;
	}
	
	public static void main(String[] args)throws Exception{
		getJsonGson(); 
		
	}
	
	/**
	 * 利用Json-lib封装数组Json数据,Gson解析Json数据.
	 * @throws Exception
	 */
	private static void getJsonGson() throws Exception {
		//Json-lib的JSONArray数组对象
		JSONArray  JsonArray =getArrayToJsonByJsonLib();
		String jsonData=JsonArray.toString();
		/*
		 * 自己组装成一个json格式，格式必须为{,,}才能为JsonElement对象的parse方法解析不是否则
		 * 会报错com.google.gson.JsonSyntaxException: java.io.EOFException: End of input at line 1 column 1307
		 */
		String json="{status:1,address:"+jsonData+"}";

		// 创建一个JsonParser
		JsonParser parser = new JsonParser();
		JsonElement jsonEl = parser.parse(json);
		
		JsonObject jsonObj = null;
		jsonObj = jsonEl.getAsJsonObject();//转换成Json对象
		String status=jsonObj.get("status").getAsString();//status节点
		//System.out.println(status);
		
		JsonElement addressEl=jsonObj.get("address");//address节点
		if(addressEl.isJsonArray()){//判断是否为Json数组
			JsonArray jsonArray= addressEl.getAsJsonArray();//转为数组
			for(Iterator iter=jsonArray.iterator();iter.hasNext();){
				JsonObject obj=(JsonObject) iter.next();
				//String city=obj.get("city").getAsString();//方法一：根据key形势取值
				System.out.println(obj);
				Address add=gson.fromJson(obj, Address.class);//方法二：灵活使用Gson取数据
				System.out.println(add.getProvince()+"\t"+add.getCity());
			 }
		}
	}
	 
 } 