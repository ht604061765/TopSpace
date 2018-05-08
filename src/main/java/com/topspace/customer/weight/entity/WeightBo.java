/**
 * @author Hunter
 * TopSpace
 * 2018-3-31 上午10:52:06
 * TODO //
 */
package com.topspace.customer.weight.entity;

import java.io.Serializable;
import java.util.Date;

import com.topspace.core.framework.bo.BaseBO;

public class WeightBo extends BaseBO implements Serializable{

	/**
	 * @author Hunter
	 * WeightBo.java
	 * 2018-3-31 上午10:52:27
	 * TODO
	 */
	private static final long serialVersionUID = 4024238523929124508L;

	private String id;					//id
	private String memberId; 			//成员ID
	private String memberName;			//成员名字
	private String weight; 				//体重
	private Date weightTime;			//体重时间
	private String statusCode;			//状态编码
	private String statusName;			//状态名称
	private String createMemberId;		//创建人Id
	private String creatememberName;	//创建人名字
	private Date createTime;			//创建时间
	private String description;			//描述
	private String note;				//备注
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public Date getWeightTime() {
		return weightTime;
	}
	public void setWeightTime(Date weightTime) {
		this.weightTime = weightTime;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getCreateMemberId() {
		return createMemberId;
	}
	public void setCreateMemberId(String createMemberId) {
		this.createMemberId = createMemberId;
	}
	public String getCreatememberName() {
		return creatememberName;
	}
	public void setCreatememberName(String creatememberName) {
		this.creatememberName = creatememberName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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


