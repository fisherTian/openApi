package com.haoyun.model;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;

public class SysUser {
	
	public final static String DEFAULT_PASSWORD = "123456";

	private Long userId;
	private String account;
	private String password;
	private String name;
	private String mail;
	private String phone;
	private String desc;
	private String avatar;
	
	
	

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long aUserId) {
		this.userId = aUserId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String aAccount) {
		this.account = aAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String aPassword) {
		this.password = aPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String aName) {
		this.name = aName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String aMail) {
		this.mail = aMail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String aPhone) {
		this.phone = aPhone;
	}
}
