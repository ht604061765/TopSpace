/**
 * @author Hunter
 * TopSpace
 * 2018-1-16 下午10:48:20
 * TODO //
 */
package com.topspace.core.framework.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SessionDataSet implements Serializable{

	private static final long serialVersionUID = 9090639393049520309L;
	private String sessionId;
	private Map<String, Object> sessionData = new HashMap<String, Object>();

	public SessionDataSet() {
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public SessionDataSet(String sessionId) {
		this.sessionId = sessionId;
	}

	public Object getAttribute(String key) {
		return this.sessionData.get(key);
	}

	 void setAttribute(String key, Object value) {
		this.sessionData.put(key, value);
	}

	 void removeAttribute(String key) {
		this.sessionData.remove(key);
	}
}


