/**
 * @author Hunter
 * TopSpace
 * 2018-1-22 下午9:38:58
 * TODO //
 */
package com.topspace.customer.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.topspace.core.filter.BaseFilter;
import com.topspace.core.framework.threadlocal.SystemThreadLocal;
import com.topspace.core.utils.StringUtil;
import com.topspace.customer.util.login.LoginUtil;

public class ThreadLocalFilter extends BaseFilter{
	private static final Logger LOG = LoggerFactory.getLogger(ThreadLocalFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOG.debug("====== ThreadLocalFilter Init ======");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String ip = SystemThreadLocal.getInstanse().getReqIP();
		if (StringUtil.isEmpty(ip)){
			SystemThreadLocal.getInstanse().setReqIP(req.getLocalAddr());
		}else {
			boolean isLogin = LoginUtil.isLogin(req);
			if(isLogin){
				if (StringUtil.isEmpty(SystemThreadLocal.getInstanse().getLoginSysAccountId())) {
					SystemThreadLocal.getInstanse().setLoginSysAccountId(LoginUtil.getLoginAccount(req).getUserAccount());
				}
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		LOG.debug("====== ThreadLocalFilter Destroy ======");
	}

}

