/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-28 下午8:35:54
 * TODO //
 */
package com.topspace.test.controlle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.topspace.core.framework.controller.BaseController;
import com.topspace.core.utils.PKCreator;
import com.topspace.core.utils.StringUtil;
import com.topspace.customer.login.entity.UserBo;
import com.topspace.customer.login.service.LoginService;
import com.topspace.test.service.ShishiService;

@SuppressWarnings("restriction")
@Controller("ShishiController")
@RequestMapping("/shishi.do")
public class shishiController extends BaseController{
	
	@Resource
	ShishiService ShishiService;
	
	@Resource
	LoginService LoginService;

	@RequestMapping(params = "p=shishiz")
	public ModelAndView xingzen(String userAccount,String userPassword) throws Exception{
		UserBo X= new UserBo();
		String id_1 = PKCreator.getPrimaryKey();
		X.setId(id_1);
		X.setUserAccount(userAccount);
	    X.setUserPassword(userPassword);
	    X.setRegTime(new Date());
	    LoginService.insertUser(X);
	    ModelAndView mv = new ModelAndView("index/index");
		return mv;
	}
	
//	@RequestMapping(params = "p=shishic1")
//	public String chaXun() throws Exception{
//		List<UserBo> ub1 = shishiService.selectUserList();
//		System.out.println(StringUtil.toString(ub1));
//		return "111";
//	}
	@RequestMapping(params = "p=shishic")
	public ModelAndView testUserList() {
		ModelAndView mv = new ModelAndView("test/test1");
		List<UserBo> ub = LoginService.selectUserList();
		mv.addObject("userList",ub);
		return mv;
		
	}
	@RequestMapping(params = "p=shishis")
	public ModelAndView shanchu(String id) throws Exception{
		ShishiService.deleteUser(id);
		ModelAndView mv = new ModelAndView("test/test1");
		List<UserBo> ub = LoginService.selectUserList();
		mv.addObject("userList",ub);
		return mv;
		
}
	@RequestMapping(params = "p=shishig")
	public ModelAndView xiugai(String id,String userAccount) throws Exception{
		UserBo X= new UserBo();
		X.setId(id);
		X.setUserAccount(userAccount);
		ShishiService.mixUser(X);
		ModelAndView mv = new ModelAndView("test/test1");
		List<UserBo> ub = LoginService.selectUserList();
		mv.addObject("userList",ub);
		return mv;
		
}
}	
//	public static void main(String[] args) throws Exception{
//		shishiController aa = new shishiController();
//		aa.chaXun();
//	}



	