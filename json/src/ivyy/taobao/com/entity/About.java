package ivyy.taobao.com.entity;

import java.io.Serializable;

/**
 *@Author:liangjilong
 *@Date:2015-1-5
 *@Version:1.0
 *@Description:
 */
public class About implements Serializable {

	private String weixin;
	private String weibo;
	private String email;
	private String qq;
	private String address;
	
	
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getWeibo() {
		return weibo;
	}
	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
