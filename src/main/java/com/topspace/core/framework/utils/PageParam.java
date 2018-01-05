/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午10:14:24
 * TODO //
 */
package com.topspace.core.framework.utils;

import java.util.Map;

import com.topspace.core.framework.bo.BaseBO;


public class PageParam {


	private int pageNo; // 基准为1。页码;1,2,3,4。

	private int pageSize; // 每页记录数。
	private String orderType; // 排序类型，desc 或 asc。
	private String orderField; // 排序字段.

	private QueryParam param = QueryParam.build();

	public PageParam() {

	}

	public PageParam(int pageNo, int pageSize) {
		this(pageNo, pageSize, null, null);
	}

	public PageParam(int pageNo, int pageSize, String orderField,
			String orderType) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.orderField = orderField;
		this.orderType = orderType;
	}

	public final int getPageNo() {
		return pageNo;
	}

	public final void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public final int getPageSize() {
		return pageSize;
	}

	public final void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public final String getOrderType() {
		return orderType;
	}

	public final void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public final String getOrderField() {
		return orderField;
	}

	public final void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public QueryParam getParam() {
		return param;
	}

	

	public PageParam add(String paramName, Object paramValue) {
		this.param.add(paramName, paramValue);
		return this;
	}
	
	
	public PageParam add(Map<String, Object> map) {
		this.param.add(map);
		return this;
	}


	public PageParam add(BaseBO bo) {
		this.param.add(bo);
		return this;
	}


}


