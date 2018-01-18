/**
 * @author Hunter
 * TopSpace
 * 2018-1-18 下午10:29:42
 * TODO //
 */
package com.topspace.core.framework.session;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	SessionManager sm = SessionManager.getInstance();

	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		SessionDataSet s=new SessionDataSet(session.getId());
		session.setAttribute("CURRENT_USER_SESSION", s);
		sm.add(s);
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		sm.remove(session.getId());
	}

}


