package ivyy.taobao.com.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *@Author:liangjilong
 *@Date:2015-1-5
 *@Version:1.0
 *@Description:
 */
public class IoUtils {

	/**
	 * 读文件流
	 * 
	 * @param formPath从哪里读取的文件路径
	 * @return
	 */
	public static String reader(String formPath) {
		String content="";
		FileReader read = null;
		BufferedReader reader = null;
		try {
			read = new FileReader(new File(formPath));
			reader = new BufferedReader(read);
			StringBuffer buffer = new StringBuffer("");
			content = reader.readLine();
			while (content != null) {
				buffer.append(content).append("\n");
				content = reader.readLine();
			}
			return content = buffer.toString();// 返回
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (read != null)
					read.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";// 没值就返回空
	}
	
	/**
	 * 处理文件写
	 * @param content
	 * @param htmlPath
	 * @return
	 */
	public static boolean write(String content, String htmlPath) {  
        boolean flag = true;  
        try {  
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlPath), "utf-8"));  
            out.write("\n" + content);  
            out.close();  
        } catch (Exception ex) {  
            ex.printStackTrace();  
            return false;  
        }  
        return flag;  
    } 
}
