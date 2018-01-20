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
@Controller("shishiController")
@RequestMapping("/shishi.do")
public class shishiController extends BaseController{
	
    @RequestMapping(params = "p=test")
    @ResponseBody
	public String checkUser(String gname,String gsex){
    	System.out.println("++++++++++++++++++++++");

    	System.out.println("gname="+gname+";gsex="+gsex);
    	
    	System.out.println("++++++++++++++++++++++");
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
   
}



