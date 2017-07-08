package com.chinasofti.pageModel;

public class UserInfo implements java.io.Serializable {

	private static final long serialVersionUID = 966757370209717019L;

	private String userId;// 用户ID
	private String userName;// 用户登录名称
	private String userPassword;// 登录密码
	private String ip;// IP地址

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
