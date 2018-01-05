/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-23 下午11:21:54
 * TODO //
 */
package com.topspace.core.framework.dao.page;

public interface Dialect {

	public boolean supportsLimit();

	public String getLimitString(String sql, boolean hasOffset);

	public String getLimitString(String sql, int offset, int limit);

	public boolean supportsLimitOffset();

}


