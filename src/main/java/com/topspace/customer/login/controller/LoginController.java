/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-28 下午8:35:54
 * TODO //
 */
package com.topspace.customer.login.controller;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topspace.core.framework.controller.BaseController;
import com.topspace.core.framework.misc.SystemConstant;
import com.topspace.core.utils.PKCreator;
import com.topspace.core.utils.URLUtil;
import com.topspace.customer.login.entity.UserBo;
import com.topspace.customer.login.entity.UserInfoBo;
import com.topspace.customer.login.service.LoginService;

@SuppressWarnings("restriction")
@Controller("LoginController")
@RequestMapping("/login.do")
public class LoginController extends BaseController{

	@Resource
	LoginService LoginService;
	
	//查看是否存在此用户
	public Boolean isHasAccount(String userAccount) {
		Boolean had = false;
		
		
		return had;
	}
	
	@RequestMapping(params = "p=register")
	public void register(HttpServletRequest request) throws Exception {
		String userId = PKCreator.getPrimaryKey();
		UserBo user = new UserBo();
		UserInfoBo userInfo = new UserInfoBo();
		
		Map map1 = request.getParameterMap();
		
		user.setId(userId);
		user.setUserAccount(request.getParameter("userAccount").toString());
		user.setUserPassword(request.getParameter("userPassword").toString());
		LoginService.insertUser(user);
		
		userInfo.setId(PKCreator.getPrimaryKey());
		userInfo.setUserId(userId);
		LoginService.insertUserInfo(userInfo);

	}
}



