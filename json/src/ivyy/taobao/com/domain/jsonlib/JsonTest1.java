package ivyy.taobao.com.domain.jsonlib;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *@Date:2015-1-5
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description£º
 */
public class JsonTest1 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String json = "[{\"goodDetail\":{\"remark\":\"1212\",\"id\":\"23\" }},{\"goodDetail\":{\"remark\":\"1212\",\"id\":\"23\" }}]";
		JSONArray arr = JSONArray.fromObject(json);
		JSONObject obj = null;
		for (int i = 0, l = arr.size(); i < l; i++) {
			obj = arr.getJSONObject(i);
			Object gd = obj.get("goodDetail");
			JSONObject jsobj = JSONObject.fromObject(gd);
			System.out.println(jsobj.get("id"));
			System.out.println(jsobj.get("remark"));
		}
		 
	}
}
