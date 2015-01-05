package ivyy.taobao.com.domain.orgjson;

import org.json.JSONException;
import org.json.JSONObject;
/**
 *@Date:2015-1-5
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description£º
 */
public class JsonTest1 {

	public static void main(String[] args) throws JSONException {
		 
		JSONObject jsonObject=new JSONObject();
		
		jsonObject.put("weibo", "http://weibo.com/resourceljl");
		
		System.out.println(jsonObject.get("weibo"));
	}
}
