/**
 * @author Hunter
 * TopSpace
 * 2018-1-22 下午9:54:50
 * TODO //
 */
package com.topspace.customer.util.login;

import javax.servlet.http.HttpServletRequest;

import com.topspace.core.framework.session.SessionUtil;
import com.topspace.customer.login.entity.UserBo;

public class LoginUtil {
	final static String Current_Login_UserAccount = "Current_Login_UserAccount";
	
	public static boolean isLogin(HttpServletRequest request) {
		return SessionUtil.isContentKey(request, Current_Login_UserAccount);
	}
	
	public static UserBo getLoginAccount(HttpServletRequest request) {
		return (UserBo) SessionUtil.getAttribute(request,
				Current_Login_UserAccount);
	}
}


