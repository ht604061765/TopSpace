/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-28 下午8:35:54
 * TODO //
 */
package com.topspace.test.controlle;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
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

@SuppressWarnings("restriction")
@Controller("shishiController")
@RequestMapping("/shishi.do")
public class shishiController extends BaseController{
	
	@Resource
	LoginService LoginService;
	
	@RequestMapping(params = "p=shishiz")
	@ResponseBody
	public String xinZeng(String userAccount,String userPassword){
		Date date = new Date();
		UserBo x = new  UserBo();
		x.setId(StringUtil.toString(date));
		x.setUserAccount(userAccount);
		x.setUserPassword(userPassword);
		LoginService.insertUser(x);
		return null;
	}
	
	
//    @RequestMapping(params = "p=test")
//    @ResponseBody
//	public String checkUser(String gname,String gsex){
//    	System.out.println("++++++++++++++++++++++");
//
//    	System.out.println("gname="+gname+";gsex="+gsex);
//    	
//    	System.out.println("++++++++++++++++++++++");
//
//       return null;
//    }
//    
//    @RequestMapping(params = "p=testMvc")
//    @ResponseBody
//	public String testMvc(UserBo ub1){
//    	String aaaString = ub1.getUserAccount();
//    	ub1.setId("aaa");
//		LoginService.insertUser(ub1);
//       return null;
//    }
//   
//
// @RequestMapping(params = "p=shuuju")
// @ResponseBody
// public String shuuju(String userAccount,String userPassword){
//	 Date date = new Date();
//	 UserBo b = new  UserBo();
//	b.setUserAccount(userAccount);
//	b.setUserPassword(userPassword);
//	b.setId(StringUtil.toString(date));
//	 
//	 LoginService.insertUser(b);
//	 return null;
//   }
// 
// 
// @RequestMapping(params = "p=shuju")
// @ResponseBody
// public String shuju(UserInfoBo c){
// Date date = new Date();
// c.setId(StringUtil.toString(date));
// c.setCertEmail("1");
// c.setCertName("2");
// c.setCertNo("3");
// c.setCertPhone("4");
// c.setCertSex("5");
// c.setCertType("6");
// c.setDescription("7");
// c.setHeadPic("8");
// c.setNickName("9");
// c.setNote("10");
// c.setQq("11");
// c.setUserId("12");
// c.setWx("13");
// LoginService.insertUserInfo(c);
// return null;
//  }
}

	