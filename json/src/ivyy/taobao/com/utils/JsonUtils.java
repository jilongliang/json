package ivyy.taobao.com.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 *@Author:jilongliang
 *@Email:jilongliang@sina.com
 *@Date:2015-1-5
 *@CopyRight:liangjilong
 *@Description:
 */
public class JsonUtils {
	/**
	 * 格式JSON,使Json美化
	 * @param content
	 * @return
	 */
	public static String formatAsJSON(String content){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jsonPar = new JsonParser();
        JsonElement jsonEl = jsonPar.parse(content);
        String prettyJson = gson.toJson(jsonEl);
        return prettyJson;

	}
}