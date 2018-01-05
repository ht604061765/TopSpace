/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午10:09:16
 * TODO //
 */
package com.topspace.core.framework.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.topspace.core.framework.utils.PageParam;
import com.topspace.core.utils.ParamTokenUtil;
import com.topspace.core.utils.StringUtil;



import javax.servlet.http.HttpServletRequest;


@SuppressWarnings("rawtypes")
public class BaseController {




	public final Logger LOG = LoggerFactory.getLogger(this.getClass());

	public static String failure_JspPath = "/WEB-INF/pages/o2o/common/msg/failure.jsp";
	public static String success_JspPath = "/WEB-INF/pages/o2o/common/msg/success.jsp";

	protected PageParam getPageParam(HttpServletRequest request) {
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		String orderType = request.getParameter("orderType");
		String orderFiled = request.getParameter("orderFiled");
		return new PageParam(pageNo, pageSize, orderFiled, orderType);
	}
	

	protected PageParam getPageParam(Map param) {
		int pageNo = Integer.parseInt((String)param.get("pageNo"));
		int pageSize = Integer.parseInt((String)param.get("pageSize"));
		String orderType = (String)param.get("orderType");
		String orderFiled = (String)param.get("orderFiled");
		return new PageParam(pageNo, pageSize, orderFiled, orderType);
	}

	@RequestMapping(params = "m=success4UC")
	public ModelAndView success4UC(String title, String msg, String backURL) {
		ModelAndView mv = new ModelAndView(
				"forward:/WEB-INF/pages/o2o/common/msg/success.jsp");
		mv.addObject("title", title);
		mv.addObject("msg", msg);
		if (StringUtil.isEmpty(backURL)) {
			backURL = "javascript:history.back()";
		}
		mv.addObject("backURL", backURL);
		return mv;
	}

	@RequestMapping(params = "m=failure4UC")
	public ModelAndView failure4UC(String title, String msg, String backURL) {
		ModelAndView mv = new ModelAndView(
				"forward:/WEB-INF/pages/o2o/common/msg/failure.jsp");
		mv.addObject("title", title);
		mv.addObject("msg", msg);
		if (StringUtil.isEmpty(backURL)) {
			backURL = "javascript:history.back()";
		}
		mv.addObject("backURL", backURL);
		return mv;
	}
	
	@RequestMapping(params = "p=success")
	public ModelAndView success(String title, String msg, String backURL) {
		ModelAndView mv = new ModelAndView("forward:/pages/msg/success.jsp");
		mv.addObject("title", title);
		mv.addObject("msg", msg);
		if (StringUtil.isEmpty(backURL)) {
			backURL = "javascript:history.back()";
		}
		mv.addObject("backURL", backURL);
		return mv;
	}
	
	@RequestMapping(params = "p=failure")
	public ModelAndView failure(String title, String msg, String backURL) {
		ModelAndView mv = new ModelAndView("forward:/pages/msg/failure.jsp");
		mv.addObject("title", title);
		mv.addObject("msg", msg);
		if (StringUtil.isEmpty(backURL)) {
			backURL = "javascript:history.back()";
		}
		mv.addObject("backURL", backURL);
		return mv;
	}

	/**
	 * URL请求参数加密
	 * 
	 * @param keyValue
	 *            key-value的的匹对形式,即参数必须个数为偶数
	 * @return 返回加密后的字符串
	 */
	protected String encryptUrlParamToken(String... keyValue) {
		return ParamTokenUtil.encryptUrlParamToken(keyValue);
	}

	/**
	 * 获取Token解密后的key对应的value
	 * 
	 * @param request
	 * @param key
	 * @return 返回key对应的值
	 */
	protected String getTokenValue(String token, String key) {
		return ParamTokenUtil.getTokenValue(token,key);
	}

	/**
	 * 将token解密，返回键值对。用于token中有多个参数的情况。
	 * 
	 * @param token
	 * @return
	 */
	protected Map<String, String> getTokenValue(String token) {
		return ParamTokenUtil.getTokenValue(token);
	}

}


