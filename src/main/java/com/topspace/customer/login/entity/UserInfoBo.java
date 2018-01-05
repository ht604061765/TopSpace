/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-27 上午9:39:39
 * TODO //
 */
package com.topspace.customer.login.entity;

import java.io.Serializable;

import com.topspace.core.framework.bo.BaseBO;

public class UserInfoBo extends BaseBO implements Serializable{

	private static final long serialVersionUID = -7186536087512207665L;

	private String id;				//id
	private String userId;			//用户id
	private String nickName;		//昵称
	private String headPic;			//投降地址
	private String certName;		//实名认证名称
	private String certSex;			//实名认证性别
	private String certType;		//实名认证类型
	private String certNo;			//实名认证类型
	private String certPhone;		//认证电话
	private String certEmail;		//认证邮箱
	private String qq;				//qq号码
	private String wx;				//微信号码（备选登陆用）
	private String description;		//描述
	private String note;			//备注
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getHeadPic() {
		return headPic;
	}
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	public String getCertName() {
		return certName;
	}
	public void setCertName(String certName) {
		this.certName = certName;
	}
	public String getCertSex() {
		return certSex;
	}
	public void setCertSex(String certSex) {
		this.certSex = certSex;
	}
	public String getCertType() {
		return certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getCertPhone() {
		return certPhone;
	}
	public void setCertPhone(String certPhone) {
		this.certPhone = certPhone;
	}
	public String getCertEmail() {
		return certEmail;
	}
	public void setCertEmail(String certEmail) {
		this.certEmail = certEmail;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWx() {
		return wx;
	}
	public void setWx(String wx) {
		this.wx = wx;
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


