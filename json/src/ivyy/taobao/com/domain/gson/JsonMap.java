package ivyy.taobao.com.domain.gson;

import ivyy.taobao.com.entity.Address;
import ivyy.taobao.com.utils.GlobalConstants;
import ivyy.taobao.com.utils.HttpRequestUtils;
import ivyy.taobao.com.utils.IoUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
@SuppressWarnings("all")
/**
 *@Date:2015-1-5
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description：
 */
public class JsonMap {
	private static Gson gson=new Gson();
	//jsonmap.json文件
	public static void main(String[] args) throws Exception {
		//也可以从jsonmap.json通过文件流读取
		//setDataByGson();
		//getDataByGson("URL");
		getDataByGson("FILE");
		//getStrToJsonByGson();
		//getObjectToJsonByGson();
		//getArrayToJsonByGson();
		///////////////////////////////////
	}


	/**
	 * ByGson把字符串转换成Json数据
	 * @throws Exception
	 */
	private static void getStrToJsonByGson()throws Exception
	{
		//String jsonStr="{\"city\":\"广州市\",\"province\":\"广东省\"}"; //这本身是json数据,也是字符串!
		 String jsonStr="{city:广州市,province:广东省}"; 
		 Address addr =gson.fromJson(jsonStr,Address.class);//把字符串转换成Json
		 String json=gson.toJson(addr);//把对象转换成json
		 System.out.println(json);
		 System.out.println(addr.getProvince()+"\t"+addr.getCity());
	}

	/**
	 * Gson结合反射对象,把对象转换成Json数据
	 * @throws Exception
	 */
	private static void getObjectToJsonByGson()throws Exception
	{
		 Address addr = new Address(); 
		 addr.setProvince("广东省");
		 addr.setCity("广州市");
		 String json=gson.toJson(addr);//把对象转换成Json
		 //创建一个JsonParser对象
		 //JsonParser parser = new JsonParser();  
		 //创建一个JsonElement对象
         //JsonElement jsonEl = parser.parse(json);  
		 Type type = new TypeToken<Address>(){}.getType();//通过反射
		 Address add= gson.fromJson(json,type);
		 //Address add= gson.fromJson(jsonEl,type);
		 System.out.println(add.getProvince()+"\t"+add.getCity());
	}
	
	
	
	
	
	/**
	 * 通过Gson把数组转换成Json数据
	 * @param url
	 * @throws Exception
	 */
	private static void getArrayToJsonByGson()throws Exception
	{
		List<Address> lists=new ArrayList<Address>();
		for (int i = 1; i <=12; i++) {
			Address addr = new Address(); 
			addr.setProvince("第"+i+"个省份");
			addr.setCity("第"+i+"个城市");
			lists.add(addr);
		}
		String json=gson.toJson(lists);//把数组对象转换成Json
		Type type = new TypeToken<List<Address>>(){}.getType();//通过反射
		List<Address> adds= gson.fromJson(json,type);
		for (Address a:adds) {
			System.out.println(a.getCity());
		}
	}
	/**
	 * 通过Gson组装Json数据
	 */
	private  static void setDataByGson(){
		///////////////////组装json////////////////////
		 JsonObject jsonObject=new JsonObject();
		 Map<String, String> lists = new HashMap <String, String>(); 
		 
		 lists.put("country", "中国");
		 lists.put("province", "广东省");
		 lists.put("city", "云浮市");
		 lists.put("district", "云城区闻莺路东升布艺");
		 lists.put("street", "闻莺路");
			
         String json=gson.toJson(lists);//转换成json数据
         System.out.println(json); //输出json
         
         ///////////////////获取json////////////////////
         JsonParser parser = new JsonParser();
		 JsonElement jsonEl = parser.parse(json);
         JsonObject jsonObjRoot = null;
         jsonObjRoot = jsonEl.getAsJsonObject();
         if(jsonObjRoot.isJsonObject()&&jsonObjRoot.get("district")!=null &&jsonObjRoot.get("street").getAsString()!=""){
        	 String district=jsonObjRoot.get("district").getAsString();
        	 System.out.println(district);
         }
	} 
	
	/**
	 * 用gson去解析数据
	 * @param url网止连接
	 * @throws Exception
	 */
	private static void getDataByGson(String flg) throws Exception {
		//PostMethod method = new PostMethod(url);
		String responseData="";
		if(flg.equals("URL")){
			//北京市的经纬度39.983424,116.322987
			String url=GlobalConstants.getBaiduMapUrl("你的key", "39.983424,116.322987", "json");
			responseData = HttpRequestUtils.HttpURLConnRequest(url, "GET");
		}else if(flg.equals("FILE")){
			String jsonData="ivyy/taobao/com/domain/gson/jsonmap.json";
			String path = JsonMap.class.getClassLoader().getResource(jsonData).getPath();
			responseData=IoUtils.reader(path);
		}
		
		//处理页面的json数据
		int start = responseData.indexOf("(") + 1;
		responseData = responseData.substring(start, responseData.lastIndexOf(")"));
		
		// 创建一个JsonParser
		JsonParser parser = new JsonParser();
		JsonElement jsonEl = parser.parse(responseData);
		// 把JsonElement对象转换成JsonObject
		JsonObject jsonObjRoot = null;
		if (jsonEl.isJsonObject()) {
			 jsonObjRoot = jsonEl.getAsJsonObject();
			 String status="",result="",lat="",lng="",formatted_address="",business="",city="",district="",province="",street="",street_number="",cityCode="";
			 //String status=gson.toJson(jsonObjRoot.get("status"));//方法一
			 status=jsonObjRoot.get("status").getAsString();//方法二
			 JsonElement resultEl=jsonObjRoot.get("result");//result节点
			 
			 JsonElement locationEl=resultEl.getAsJsonObject().get("location");//location节点
			 
			 lat=locationEl.getAsJsonObject().get("lat").getAsString();
			 lng=locationEl.getAsJsonObject().get("lng").getAsString();
			 	
			 
		     formatted_address=resultEl.getAsJsonObject().get("formatted_address").getAsString();//formatted_address节点
		     business=resultEl.getAsJsonObject().get("business").getAsString();//business节点
			 cityCode=resultEl.getAsJsonObject().get("cityCode").getAsString();//cityCode节点

			 JsonElement compEl=resultEl.getAsJsonObject().get("addressComponent");//addressComponent节点
			 
			 city=compEl.getAsJsonObject().get("city").getAsString();
			 district=compEl.getAsJsonObject().get("district").getAsString();
			 province=compEl.getAsJsonObject().get("province").getAsString();
			 street=compEl.getAsJsonObject().get("street").getAsString();
			 street_number=compEl.getAsJsonObject().get("street_number").getAsString();
			 
			 JsonElement poisEl=resultEl.getAsJsonObject().get("pois");//pois节点
			 boolean flag=poisEl.isJsonArray();//是否为Json数组
			 if(flag){
				// System.out.println(poisEl.getAsJsonArray());
				 JsonArray jsonArray= poisEl.getAsJsonArray();//转为数组
				 String addr="",cp="",distance="",name="",poiType="",tel="",uid="",zip="",x="",y="";
				 //方法一
				 /*for(Iterator iter=jsonArray.iterator();iter.hasNext();){
					 JsonObject jop=(JsonObject) iter.next();
					 addr=jop.get("addr").getAsString();
					 x=jop.get("point").getAsJsonObject().get("x").getAsString();//x节点
					 System.out.println(jop.get("point").getAsJsonObject());
					 System.out.println("address"+addr+"\t\tx="+x);
				 }
				 */
				 //方法二
				 for (int i = 0; i < jsonArray.size(); i++) {
					 JsonObject jop=(JsonObject)jsonArray.get(i);
					 addr=jop.get("addr").getAsString();
					 cp=jop.get("cp").getAsString();
					 distance=jop.get("distance").getAsString();
					 name=jop.get("name").getAsString();
					 poiType=jop.get("poiType").getAsString();
					 tel=jop.get("tel").getAsString();
					 uid=jop.get("uid").getAsString();
					 zip=jop.get("zip").getAsString();
					
					 if(jop.get("point").getAsJsonObject().isJsonObject())
					 {
						// System.out.println(jop.get("point").getAsJsonObject());
						 x=jop.get("point").getAsJsonObject().get("x").getAsString();//x节点
						 y=jop.get("point").getAsJsonObject().get("y").getAsString();//y节点
						 System.out.println(x);
					 }
				 }
			 }
		}
	}
	
}