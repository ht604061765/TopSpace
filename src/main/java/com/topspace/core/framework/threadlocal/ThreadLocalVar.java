/**
 * @author Hunter
 * TopSpace
 * 2018-1-16 下午11:22:54
 * TODO //
 */
package com.topspace.core.framework.threadlocal;

public class ThreadLocalVar {

	/**
	 * 系统登录账号Id
	 */
	private String loginSysAccountId;
	/**
	 * 系统请求IP
	 */
	private String reqIP;

	
	public String getLoginSysAccountId() {
		return loginSysAccountId;
	}

	public void setLoginSysAccountId(String loginSysAccountId) {
		this.loginSysAccountId = loginSysAccountId;
	}
	public String getReqIP() {
		return reqIP;
	}
	public void setReqIP(String reqIP) {
		this.reqIP = reqIP;
	}

}


