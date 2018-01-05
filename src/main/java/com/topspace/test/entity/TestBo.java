/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-25 上午9:36:54
 * TODO //
 */
package com.topspace.test.entity;

import java.io.Serializable;

import com.topspace.core.framework.bo.BaseBO;

public class TestBo extends BaseBO implements Serializable{
	private static final long serialVersionUID = 8492343775698021371L;

	private java.lang.String id;

	private java.lang.String name;

	private java.lang.String sex;

	private java.lang.String age;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getSex() {
		return sex;
	}

	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}

	public java.lang.String getAge() {
		return age;
	}

	public void setAge(java.lang.String age) {
		this.age = age;
	}

}


