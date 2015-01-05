package ivyy.taobao.com.entity;

import java.io.Serializable;

/**
 *@Author:liangjilong
 *@Date:2015-1-5
 *@Version:1.0
 *@Description:
 */
public class ResultInfo implements Serializable{

	private About about;
	private User user;
	
	public About getAbout() {
		return about;
	}
	public void setAbout(About about) {
		this.about = about;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
