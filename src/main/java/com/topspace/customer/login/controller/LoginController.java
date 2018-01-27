/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-28 下午8:35:54
 * TODO //
 */
package com.topspace.customer.login.controller;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JRadioButton;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.topspace.core.framework.controller.BaseController;
import com.topspace.core.framework.misc.SystemConstant;
import com.topspace.core.framework.session.SessionUtil;
import com.topspace.core.utils.Json4Return;
import com.topspace.core.utils.PKCreator;
import com.topspace.core.utils.StringUtil;
import com.topspace.core.utils.URLUtil;
import com.topspace.customer.login.entity.UserBo;
import com.topspace.customer.login.entity.UserInfoBo;
import com.topspace.customer.login.service.LoginService;
import com.topspace.customer.util.login.LoginUtil;

@SuppressWarnings("restriction")
@Controller("LoginController")
@RequestMapping("/login.do")
public class LoginController extends BaseController{

	@Resource
	LoginService LoginService;
	
	@RequestMapping(params = "p=testUserList")
	public ModelAndView testUserList() {
		ModelAndView mv = new ModelAndView("test/test");
		List<UserBo> ub = LoginService.selectUserList();
		mv.addObject("userList",ub);
		return mv;
		
	}
	
    @RequestMapping(params = "p=login", method = RequestMethod.POST)
	public ModelAndView login(UserBo ub,HttpServletRequest request) throws Exception {
    	SessionUtil.setAttribute(request, "Current_Login_UserAccount", ub);
    	String sysAccount = LoginUtil.getLoginAccount(request).getUserAccount();
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	System.out.println("账号："+sysAccount + "于"  + formatter.format(new Date()) + "登陆系统");
    	ModelAndView mv = new ModelAndView("index/index");
		return mv;
	}
    
    
    @RequestMapping(params = "p=checkUser")
    @ResponseBody
	public Json4Return checkUser(String userAccount,String userPwd){
    	System.out.println(userAccount);
    	
    	String checkUserReturn = "OK";
    	UserBo user = LoginService.selectUser(userAccount);
    	if (user == null) {
    		checkUserReturn = "hasNoUser";
		}else{
			if (!user.getUserPassword().equals(userPwd)) {
	    		checkUserReturn = "invalidPwd";
			}
		}
		Json4Return jr = new Json4Return(true,checkUserReturn);
		return jr;
	}
	
	//查看是否存在此用户
	@RequestMapping(params = "p=isHasAccount")
	@ResponseBody
	public Json4Return isHasAccount(String userAccount) {
		Json4Return jr;
		boolean hadAccount = false;
		Integer hasUser =  LoginService.findUser(userAccount);
		if(hasUser == 0){
			hadAccount = true;
		}
		jr = new Json4Return(true,hadAccount);
		return jr;
	}
	
	// 注册用户
	@RequestMapping(params = "p=register")
	public ModelAndView register(HttpServletRequest request) throws Exception {
		String userId = PKCreator.getPrimaryKey();
		UserBo user = new UserBo();
		UserInfoBo userInfo = new UserInfoBo();
		
		user.setId(userId);
		user.setUserAccount(request.getParameter("userAccount").toString());
		user.setUserPassword(request.getParameter("userPassword").toString());
		user.setRegTime(new Date());
		LoginService.insertUser(user);
		
		userInfo.setId(PKCreator.getPrimaryKey());
		userInfo.setUserId(userId);
		LoginService.insertUserInfo(userInfo);
		ModelAndView mv = new ModelAndView("index/index");
		return mv;

	}
}



