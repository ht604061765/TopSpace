/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-27 上午9:39:20
 * TODO //
 */
package com.topspace.customer.login.entity;

import java.io.Serializable;
import java.util.Date;

import com.topspace.core.framework.bo.BaseBO;

public class UserBo extends BaseBO implements Serializable{

	private static final long serialVersionUID = -450377521358661730L;
	
	private String id;				//id
	private String userAccount; 	//账户
	private String userCode;		//（备用字段）
	private String userPassword; 	//密码
	private Date regTime;			//注册时间
	private String isCert;			//是否认证
	private String description;		//描述
	private String note;			//备注
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date date) {
		this.regTime = date;
	}
	public String getIsCert() {
		return isCert;
	}
	public void setIsCert(String isCert) {
		this.isCert = isCert;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	
}


