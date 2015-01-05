 package ivyy.taobao.com.domain.fastjson;

import java.util.Iterator;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


/**
 * @Author:liangjl
 * @Date:2014-12-19
 * @Version:1.0
 * @Description:fastjson和json-lib，gson都支持’如：
 *正确：jsonStr="[{\"age\":22,\"sex\":\"男\",\"userName\":\"xiaoliang\"},{\"age\":22,\"sex\":\"男\",\"userName\":\"xiaoliang\"}]";
 *正确：jsonStr="[{'age':22,'sex':'男','userName':'xiaoliang'},{'age':22,'sex':'男','userName':'xiaoliang'}]";
 */
public class JsonTest1 {
	public static void main(String[] args) {
		 
		//[{"age":22,"sex":"男","userName":"xiaoliang"},{"age":22,"sex":"男","userName":"xiaoliang"}]
		//jsonStr="[{'age':22,'sex':'男','userName':'xiaoliang'},{'age':22,'sex':'男','userName':'xiaoliang'}]";
		StringBuffer buff=new StringBuffer();
		
		buff.append("[");
			buff.append("{");
				buff.append("'weixin'").append(":").append("'YFDSBUYI'").append(",");
				buff.append("'weibo'").append(":").append("'http://weibo.com/resourceljl'").append(",");
				buff.append("'qq'").append(":").append("'1302128216'").append(",");
				buff.append("'email'").append(":").append("'buyee_hr@126.com'").append(",");
				buff.append("'address'").append(":").append("'广东省云浮市云城区闻莺路39号'").append("");
			buff.append("}");
			buff.append(",");//第一个数组结尾
			buff.append("{");
				buff.append("'weixin'").append(":").append("'YFDSBUYI'").append(",");
				buff.append("'weibo'").append(":").append("'http://weibo.com/resourceljl'").append(",");
				buff.append("'qq'").append(":").append("'1302128216'").append(",");
				buff.append("'email'").append(":").append("'buyee_hr@126.com'").append(",");
				buff.append("'address'").append(":").append("'广东省云浮市云城区闻莺路39号'").append("");
			buff.append("}");
		buff.append("]");
		
		String  jsonStr=buff.toString();
		
		
		JSONArray jarr=JSONArray.parseArray(jsonStr);//JSON.parseArray(jsonStr);
		for (Iterator iterator = jarr.iterator(); iterator.hasNext();) {
			JSONObject job=(JSONObject)iterator.next();
			String weibo=job.get("weibo").toString();
			System.out.println(weibo);
		}
	}
}

