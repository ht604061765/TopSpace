/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-19 下午2:13:18
 * TODO //
 */
package com.topspace.test.controlle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


import com.topspace.core.framework.controller.BaseController;
import com.topspace.test.service.testService;



@SuppressWarnings("restriction")
@Controller("TestController")
@RequestMapping("/Test.do")
public class testController extends BaseController {

	@Resource
	testService testService;
	
	@RequestMapping(params = "p=test")
	public String Test() throws Exception {
		testService.testInsert();
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		testController aa = new testController();
		aa.Test();
	}
}

