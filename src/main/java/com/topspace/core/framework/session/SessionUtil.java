/**
 * @author Hunter
 * TopSpace
 * 2018-1-16 下午10:31:37
 * TODO //
 */
package com.topspace.core.framework.session;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.topspace.core.framework.threadlocal.SystemThreadLocal;
import com.topspace.customer.login.entity.UserBo;

public class SessionUtil {


	
	static Logger LOG = LoggerFactory.getLogger(SessionUtil.class);

	public static void invalidate(HttpServletRequest request) {
		request.getSession().invalidate();
	}

	public static Object getAttribute(HttpServletRequest request, String key) {
		SessionDataSet s = getSessionDataSet(request);
		if (s == null) {
			return null;
		} else {
			
			return s.getAttribute(key);
		}

	}

	

	public static void setAttribute(HttpServletRequest request, String key, Object value) {
		SessionDataSet s = getSessionDataSet(request);
		s.setAttribute(key, value);
		 request.getSession().setAttribute("CURRENT_USER_SESSION",s); //要刷新下原生session，否则其不知道修改
		 String account = "";
		 if(value instanceof UserBo) {
			 account = ((UserBo)value).getUserAccount();
		 } 
		 String loginIpString = getIpAddr(request);
//		 LOG.info(" 账号 ["+account+"] 通过IP["+SystemThreadLocal.getInstanse().getReqIP()+"] 访问");
		 LOG.info(" 账号 ["+account+"] 通过IP["+loginIpString+"] 访问");
	}
	

	public static boolean isContentKey(HttpServletRequest request, String key) {
		Object v = SessionUtil.getAttribute(request, key);
		if (v == null) {
			return false;
		}
		return true;
	}

	
	public static boolean remove(HttpServletRequest request, String key) {
		SessionDataSet s = getSessionDataSet(request);
		if (s != null) {
			s.removeAttribute(key);
		}
		return true;
	}
	
	private static SessionDataSet getSessionDataSet(HttpServletRequest request) {
		SessionDataSet s = SessionManager.getInstance().getSessionDataSet(request.getSession().getId());
	
		if (s == null) {//如果session为空
			s = (SessionDataSet) request.getSession().getAttribute("CURRENT_USER_SESSION");
			if(s==null){
			}else{
				SessionManager.getInstance().add(s);
			}
		}
		return s;
	}
	
	/**
	 * 获取登录用户IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.equals("0:0:0:0:0:0:0:1")) {
			ip = "本地";
		}
		return ip;
	}

}


