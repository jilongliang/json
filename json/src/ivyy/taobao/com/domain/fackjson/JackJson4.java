package ivyy.taobao.com.domain.fackjson;

import ivyy.taobao.com.entity.Classz;
import ivyy.taobao.com.entity.Student;
import ivyy.taobao.com.utils.JsonMapper;
/**
 *@Date:2015-1-5
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description：
 */
public class JackJson4 {  
    public static void main(String[] args) {  
    	Classz student = getClassz();  
        Long beginTime = System.currentTimeMillis();  
        String json = JsonMapper.toLogJson(student);  
        
        System.out.println("对象转换为json：" + json);  
        System.out.println("转换用时：" + (System.currentTimeMillis()-beginTime) + "ms");  
        //json2bean，需要注意：Student类和Teacher类必须有一个空的构造方法  
        beginTime = System.currentTimeMillis();  
        //JsonMapper提供了很多创建Mapper的方法，不是非要用buildNonDefaultMapper，你可以对比几种方法的转换时间，挑个最快的  
        Student student2 = JsonMapper.buildNonDefaultMapper().fromJson(json, Student.class);  
        System.out.println("json转换成对象：" + student2);  
        System.out.println("转换用时：" + (System.currentTimeMillis()-beginTime) + "ms");  
    }  
  
    /** 
     * 初始化一个student 
     * @return 
     */  
    private static Classz getClassz() {  
    	Student stu1=new Student();
		stu1.setAge(22);
		stu1.setUserName("東升布藝");
		stu1.setSex("男");
		Classz claz1=new Classz();
		claz1.getStudents().add(stu1);
        return claz1;  
    }  
}  