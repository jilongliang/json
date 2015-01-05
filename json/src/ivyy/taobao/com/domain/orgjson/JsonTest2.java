package ivyy.taobao.com.domain.orgjson;

import org.json.JSONException;
/**
 *@Date:2015-1-5
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description£º
 */
public class JsonTest2 {

	public static void main(String[] args) throws JSONException {
		String json1 = "[{\"remark\":\"1212\",\"id\":\"23\" },{\"remark\":\"1212\",\"id\":\"23\" }]";
		
		System.out.println("====================");
		org.json.JSONArray jar = new org.json.JSONArray(json1);
		for (int i = 0; i < jar.length(); i++) {
			org.json.JSONObject job=(org.json.JSONObject) jar.get(i);
			System.out.println(job.get("remark"));
		}
	}
}
