/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午2:29:11
 * TODO //
 */
package com.topspace.core.framework.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class SpringBeanUtil {
	private static ApplicationContext applicationContext;

	public static void setApplicationContext(
			ApplicationContext applicationContext) {
		SpringBeanUtil.applicationContext = applicationContext;

	}

	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}

}
