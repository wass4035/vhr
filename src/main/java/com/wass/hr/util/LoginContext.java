package com.wass.hr.util;

import java.io.Serializable;
/**
 * 
 * 登录会话信息
 * @author wass
 *
 */
public class LoginContext implements Serializable {

	private static final long serialVersionUID = -1515624004457415761L;
	/**登录帐号ID*/
	private Long userId;
	/**登录帐号*/
	private String account;
	/**用户姓名*/
	private String userName;
	/**用户电话*/
	private String userPhone;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
}
