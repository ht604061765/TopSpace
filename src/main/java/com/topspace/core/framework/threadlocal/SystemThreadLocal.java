/**
 * @author Hunter
 * TopSpace
 * 2018-1-16 下午11:17:15
 * TODO //
 */
package com.topspace.core.framework.threadlocal;

public class SystemThreadLocal {


	private ThreadLocal<ThreadLocalVar> threadLocalVar = new ThreadLocal<ThreadLocalVar>();
	private static SystemThreadLocal local = new SystemThreadLocal();
	  public static SystemThreadLocal getInstanse() {  
	        return local;  
	    }  

	public void setLoginSysAccountId(String sysAccountId) {
		ThreadLocalVar tlv = threadLocalVar.get();
		if (tlv == null) {
			tlv = new ThreadLocalVar();
			threadLocalVar.set(tlv);
		}
		tlv.setLoginSysAccountId(sysAccountId);
		
	}

	public String getLoginSysAccountId() {
		ThreadLocalVar tlv = threadLocalVar.get();
		if (tlv != null) {
			return tlv.getLoginSysAccountId();
		}
		return null;
	}

	public void setReqIP(String ip) {
		ThreadLocalVar tlv = threadLocalVar.get();
		if (tlv == null) {
			tlv = new ThreadLocalVar();
			threadLocalVar.set(tlv);
		}
		tlv.setReqIP(ip);
		
	}

	public String getReqIP() {
		ThreadLocalVar tlv=	threadLocalVar.get();
		if(tlv!=null){
			return tlv.getReqIP();
		}
		return null;
	}
}


