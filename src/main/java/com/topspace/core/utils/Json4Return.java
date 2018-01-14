/**
 * @author Hunter
 * TopSpace
 * 2018-1-7 下午7:17:44
 * TODO //
 */
package com.topspace.core.utils;

public class Json4Return {

    //执行结果正确与否
    private boolean success = true;
    //错误异常编码，暂时不关注
    private int code=0;
    //提示信息
    private String msg;
    //返回数据结果
    private Object result="";

    public Json4Return(boolean success, String msg) {
        super();
        this.success = success;
        this.msg = msg;
    }

    public Json4Return(boolean success, int code,String msg) {
        super();
        this.success = success;
        this.code=code;
        this.msg = msg;
    }
    
    public Json4Return(boolean success, int code,String msg, Object rst) {
        super();
        this.success = success;
        this.code=code;
        this.msg = msg;
        this.result = rst;
    }
    
    public Json4Return(boolean success, String msg, Object rst) {
        super();
        this.success = success;
        this.msg = msg;
        this.result = rst;
    }
    public Json4Return(boolean success,  Object rst) {
        super();
        this.success = success;
        this.result = rst;
    }

    public Json4Return(boolean b,int code) {
        this.success = b;
        this.code=code;
    }
    
    public Json4Return(boolean b) {
        this.success = b;
    }

    public Json4Return(Object rst) {
        this.result = rst;
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object rst) {
        this.result = rst;
    }
	

}


