/**
 * @author Hunter
 * TopSpace
 * 2018-1-16 下午11:27:37
 * TODO //
 */
package com.topspace.core.framework.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.topspace.core.framework.threadlocal.SystemThreadLocal;

public class SessionManager implements Serializable{

	private static final long serialVersionUID = -6417408898223212187L;
	
	  final Logger LOG = LoggerFactory.getLogger(SessionManager.class);

	    public SessionManager() {
	    }

	    private static SessionManager instance = new SessionManager();

	    public static SessionManager getInstance() {
	        return instance;
	    }

	    private int onLineUserCount = 0;
	    private Map<String, SessionDataSet> sessionMap = new HashMap<String, SessionDataSet>();

	    public void add(SessionDataSet session) {
	        sessionMap.put(session.getSessionId(), session);
	        onLineUserCount++;
	        LOG.info(" 账号 [vistor] 通过IP["+SystemThreadLocal.getInstanse().getReqIP()+"] 访问");
	        // LOG.debug("=========在线人数增加===++====目前在线人数="+getOnLineUserCount());
	    }

	    public void remove(String sessionId) {
	        sessionMap.remove(sessionId);
	        onLineUserCount--;
	        // LOG.debug("=========在线人数减少===--====目前在线人数="+getOnLineUserCount());
	    }

	    public SessionDataSet getSessionDataSet(String sessionId) {
	        return sessionMap.get(sessionId);

	    }

	    public int getOnLineUserCount() {
	        return onLineUserCount > 0 ? onLineUserCount : 0;
	    }
	    
	    public Map<String, SessionDataSet> getSessionMap() {
	    	return sessionMap;
	    }

}


