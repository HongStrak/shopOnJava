package com.lanqiao.domain;


/**用户表JavaBean*/
public class User {
	/** 用户id */
	private String uid;
	/** 用户昵称 */
	private String username;
	/** 真实姓名 */
	private String realname;
	/** 性别 */
	private String sex;
	/** 密码 */
	private String password;
	/** 手机号 */
	private String phone;
	/** 是否为商家 */
	private String isSell;

	public User() {
		super();
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIsSell() {
		return isSell;
	}

	public void setIsSell(String isSell) {
		this.isSell = isSell;
	}

}
