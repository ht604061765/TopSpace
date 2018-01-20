/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-28 下午8:35:54
 * TODO //
 */
package com.topspace.test.controlle;

import java.io.File;
import java.io.InputStream;
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
import com.topspace.core.utils.URLUtil;
import com.topspace.customer.login.entity.UserBo;
import com.topspace.customer.login.entity.UserInfoBo;
import com.topspace.customer.login.service.LoginService;

@SuppressWarnings("restriction")
@Controller("LoginController")
@RequestMapping("/shishi.do")
public class shishiController extends BaseController{

	@Resource
	LoginService LoginService;
	
    @RequestMapping(params = "p=login", method = RequestMethod.POST)
	public ModelAndView login(UserBo ub,HttpServletRequest request) throws Exception {
    	String userAccount = ub.getUserAccount();
    	String userPassword = ub.getUserPassword();

    	SessionUtil.setAttribute(request, "CURRENT_USER_SESSION", "testtest");
    	
    	ModelAndView mv = new ModelAndView("index/index");
		return mv;
	}
    
    @RequestMapping(params = "t=test")
    @ResponseBody
	public String checkUser(String gname,String gsex){
    	system.out.println("++++++++++++++++++++++");
//    	String checkUserReturn = "OK";
//    	UserBo user = LoginService.selectUser(userAccount);
//    	if (user == null) {
//    		checkUserReturn = "hasNoUser";
//		}else{
//			if (!user.getUserPassword().equals(userPwd)) {
//	    		checkUserReturn = "invalidPwd";
//			}
//		}
//		Json4Return jr = new Json4Return(true,checkUserReturn);
//		return jr;
       return null;
    }
   
    
    public static void main(String[] args) {
    	shishiController aa = new shishiController();
    	aa.checkUser();
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
		LoginService.insertUser(user);
		
		userInfo.setId(PKCreator.getPrimaryKey());
		userInfo.setUserId(userId);
		LoginService.insertUserInfo(userInfo);
		ModelAndView mv = new ModelAndView("index");
		return mv;

	}
}


