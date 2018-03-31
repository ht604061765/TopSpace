/**
 * @author Hunter
 * TopSpace
 * 2018-3-31 上午11:15:10
 * TODO //
 */
package com.topspace.customer.weight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topspace.core.utils.Json4Return;

@SuppressWarnings("restriction")
@Controller("WeightController")
@RequestMapping("/weight.do")
public class WeightController {
	
	@RequestMapping(params = "p=save")
	public Json4Return weightSave() {
		
		return null;
		
	}
}


