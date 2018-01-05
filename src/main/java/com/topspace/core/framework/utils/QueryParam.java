/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午10:15:47
 * TODO //
 */
package com.topspace.core.framework.utils;

import java.util.HashMap;
import java.util.Map;

import com.topspace.core.framework.bo.BaseBO;
import com.topspace.core.utils.BeanUtil;



public class QueryParam {


	private Map<String, Object> param;

	// 不允许外部实例化
	private QueryParam() {
		param = new HashMap<String, Object>();
	}

	public static QueryParam build() {
		return new QueryParam();
	}

	public Map<String, Object> getParam() {
		return param;
	}

	public QueryParam add(String paramName, Object paramValue) {
		this.param.put(paramName, paramValue);
		return this;
	}

	public QueryParam add(Map<String, Object> intMap) {
		this.param.putAll(intMap);
		return this;
	}

	@SuppressWarnings("unchecked")
	public QueryParam add(BaseBO bo) {
		this.param.putAll(BeanUtil.bean2Map(bo));
		return this;
	}
	
	public QueryParam addOrderFieldByDESC(String orderField){
		this.param.put("SORT",orderField);
		this.param.put("DIR","desc");
		return this;
	}
	public QueryParam addOrderFieldByASC(String orderField){
		this.param.put("SORT",orderField);
		this.param.put("DIR","asc");
		return this;
	}
	

}


