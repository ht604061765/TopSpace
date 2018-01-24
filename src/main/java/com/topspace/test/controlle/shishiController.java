/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-28 下午8:35:54
 * TODO //
 */
package com.topspace.test.controlle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.topspace.core.framework.controller.BaseController;
import com.topspace.core.utils.StringUtil;
import com.topspace.customer.login.entity.UserBo;
import com.topspace.test.service.ShishiService;

@SuppressWarnings("restriction")
@Controller("ShishiController")
@RequestMapping("/shishi.do")
public class shishiController extends BaseController{
	
	@Resource
	ShishiService shishiService;
	
	@RequestMapping(params = "p=shishic")
	public String chaXun() throws Exception{
		List<UserBo> ub1 = shishiService.selectUser();
		System.out.println(StringUtil.toString(ub1));
		return "111";
	}
	
	public static void main(String[] args) throws Exception{
		shishiController aa = new shishiController();
		aa.chaXun();
	}
}


	