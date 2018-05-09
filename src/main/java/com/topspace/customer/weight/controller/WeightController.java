/**
 * @author Hunter
 * TopSpace
 * 2018-3-31 上午11:15:10
 * TODO //
 */
package com.topspace.customer.weight.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topspace.core.framework.controller.BaseController;
import com.topspace.core.utils.Json4Return;

import com.topspace.customer.weight.service.WeightService;
import com.topspace.customer.weight.entity.WeightBo;
import com.topspace.core.utils.PKCreator;

@SuppressWarnings("restriction")
@Controller("WeightController")
@RequestMapping("/weight.do")
public class WeightController extends BaseController {
	
	@Resource
	WeightService WeightService;

	@RequestMapping(params = "p=save")
	public String weightSave(String memberName,String weight) {
		WeightBo X= new WeightBo();
		String id_1 = PKCreator.getPrimaryKey();
	    X.setId(id_1);
	    X.setMemberName(memberName);
	    X.setWeight(weight);
//	    X.setWeightTime(weightTime);
	    WeightService.weightinsert(X);
		return null;
		
	}
}

//package com.topspace.test.controlle;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.topspace.core.framework.controller.BaseController;
//import com.topspace.core.utils.PKCreator;
//import com.topspace.core.utils.StringUtil;
//import com.topspace.customer.login.entity.UserBo;
//import com.topspace.customer.login.service.LoginService;
//import com.topspace.test.service.ShishiService;
//
//@SuppressWarnings("restriction")
//@Controller("ShishiController")
//@RequestMapping("/shishi.do")
//public class shishiController extends BaseController{
//	
//	@Resource
//	ShishiService ShishiService;
//	
//	@Resource
//	LoginService LoginService;
