/**
 * @author Hunter
 * TopSpaceMaven
 * 2018-1-1 下午10:00:16
 * TODO //
 */
package com.topspace.core.system.task.bo;

import com.topspace.core.framework.bo.BaseBO;

@SuppressWarnings("serial")
public class TaskBo extends BaseBO {
	private String id;		//id
	private String code;	//任务编码
	private String name;	//任务名称
	private String rule;	//执行规则
	private String imp;		//实现类
	private int isOpen;		//是否启用
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getImp() {
		return imp;
	}
	public void setImp(String imp) {
		this.imp = imp;
	}
	public int getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(int isOpen) {
		this.isOpen = isOpen;
	}
	
	@Override
	public String toString() {
		return "taskBo [id=" + id + ", code=" + code + ", name=" + name
				+ ", rule=" + rule + ", imp=" + imp + ", isOpen=" + isOpen
				+ "]";
	}

}


