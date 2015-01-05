package ivyy.taobao.com.entity;

import java.io.Serializable;

/**
 *@Author:liangjilong
 *@Date:2015-1-5
 *@Version:1.0
 *@Description:
 */
public class User implements Serializable
{
	private Integer age;
	private String sex;
	private String userName;
	private String address;
	private String taobao;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTaobao() {
		return taobao;
	}
	public void setTaobao(String taobao) {
		this.taobao = taobao;
	}

	//age":22,"sex":"ÄÐ","userName"
}
