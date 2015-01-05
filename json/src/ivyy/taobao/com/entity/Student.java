package ivyy.taobao.com.entity;

import java.io.Serializable;

/**
 *@Author:liangjl
 *@Date:2014-12-19
 *@Version:1.0
 *@Description:
 */
public class Student implements Serializable{
	private Integer age;
	private String sex;
	private String userName;
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
