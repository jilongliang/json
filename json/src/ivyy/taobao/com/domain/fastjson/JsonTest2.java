package ivyy.taobao.com.domain.fastjson;

import ivyy.taobao.com.entity.Classz;
import ivyy.taobao.com.entity.Student;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


/**
 * @Author:liangjl
 * @Date:2014-12-19
 * @Version:1.0
 * @Description:
 */
public class JsonTest2 {
	public static void main(String[] args) { 
		
		Student stu1=new Student();
		stu1.setAge(22);
		stu1.setUserName("xiaoliang");
		stu1.setSex("ÄÐ");
		
		Classz claz1=new Classz();
		claz1.getStudents().add(stu1);
		
		String jsonStr=JSON.toJSONString(claz1);
		
		JSONObject jsonObj=new JSONObject();
		
		Object obj=jsonObj.parse(jsonStr);
		
		System.out.println(obj);
		
		Classz clz=JSON.parseObject(jsonStr, Classz.class);
		
		Student st=clz.getStudents().get(0);
		System.out.println(st.getSex());
		
	}
}
