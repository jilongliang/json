package ivyy.taobao.com.domain.gson;

import ivyy.taobao.com.entity.Address;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
/**
 *@Date:2015-1-5
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description：
 */
@SuppressWarnings("all")
public class GsonWriterReader {
	private static Gson gson = new Gson();
	public static void main(String[] args) throws Exception {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map map1 = new HashMap();
		map1.put("country", "中国");
		map1.put("province", "广东省");
		map1.put("city", "云浮市");
		map1.put("district", "云城区闻莺路东升布艺");
		map1.put("street", "闻莺路");
		
		Map map2 = new HashMap();
		map2.put("country", "中国");
		map2.put("province", "广东省");
		map2.put("city", "广州市");
		map2.put("district", "越秀区");
		map2.put("street", "五羊新邨");
		
		list.add(map1);
		list.add(map2);
		
		String[] str = new String[2];
		str[0]="中国";
		str[1]="美国";
		 
		Address add = new Address(1, "中国");
		
		List<Map> mapList = printlnJsonInfo(list, map1, str, add);
		
		/**写*/
		File file = writerJsonToFile(gson, mapList);
		/***读*/
		readJsonFromFile(gson, file);
	}

	/**
	 * 打印Json信息
	 * @param list
	 * @param map1
	 * @param str
	 * @param add
	 * @return
	 */
	private static List<Map> printlnJsonInfo(List<Map<String, String>> list, Map map1,String[] str, Address add) {
		String listsJson = gson.toJson(list);// 集合转json
		String mapJson = gson.toJson(map1);// map转json
		String arrayJson = gson.toJson(str);// 数组转json
		String ObjJson = gson.toJson(add);// 对象转json

		System.out.println("->********************Object to JSON********************->");
		System.out.println("list -> 转Json: " + listsJson);
		System.out.println("Map对象 -> 转Json: " + mapJson);
		System.out.println("String数组 -> 转Json: " + arrayJson);
		System.out.println("Object -> 转Json: " + ObjJson);
		System.out.println("->********************JSON to Object  ********************->");
		
		List<Address> listUser = new ArrayList<Address>();
		//从str遍历添加了多个对象
		for (int i = 0; i<str.length; i++) {
			listUser.add(new Address(i,str[i]));
		}
		String listJson = gson.toJson(listUser);
		System.out.println("Json-> 转泛型集合: " + listJson);
		List<Address> listAdd = gson.fromJson(listJson,new TypeToken<List<Address>>() {}.getType());
				
		for (Address addr : listAdd) {
			System.out.println("国家：" + addr.getCountry());
		}
		System.out.println("Json -> 转泛型集合List<Map<String,String>>: " + listsJson);
		List<Map> mapList = gson.fromJson(listsJson,new TypeToken<List<Map<String, String>>>() {}.getType());
				
		for (Map map : mapList) {
			System.out.println("地区:" + map.get("street"));
		}
		System.out.println("Json -> 转Oject: " + listsJson);
		Address ad = gson.fromJson(ObjJson, Address.class);
		System.out.println("国家:"+ad.getCountry());
		return mapList;
	}

	/**
	 * JsonWriter
	 * 把Json数据写入文件里面
	 * @param gson
	 * @param mapList
	 * @return
	 * @throws Exception
	 */
	private static File writerJsonToFile(Gson gson, List<Map> mapList)throws Exception {
		File file = new File("gson");// 把json保存项目根目录下无后缀格式的文本
		OutputStream out = new FileOutputStream(file);
		JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));//设置编码
		gson.toJson(mapList, new TypeToken<List<Map<String, String>>>() {}.getType(), writer);//把值写进去
		writer.flush();
		writer.close();
		return file;
	}

	/**
	 * JsonReader
	 * 读取从本地文件的Json数据
	 * @param gson
	 * @param file
	 * @throws Exception
	 */
	private static void readJsonFromFile(Gson gson, File file)throws Exception {
		InputStream input = new FileInputStream(file);
		JsonReader reader = new JsonReader(new InputStreamReader(input));
		List<Map> content = gson.fromJson(reader,new TypeToken<List<Map<String, String>>>() {}.getType());
		//List<Map> content = gson.fromJson(new InputStreamReader(input),new TypeToken<List<Map<String, String>>>() {}.getType());
		for (Map map : content) {
			System.out.println("地区:" + map.get("street"));
		}
		reader.close();
	}

}