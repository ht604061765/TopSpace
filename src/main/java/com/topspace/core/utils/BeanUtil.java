/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午10:18:25
 * TODO //
 */
package com.topspace.core.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.topspace.core.framework.exception.BusiRuntimeException;


@SuppressWarnings({"rawtypes","unchecked"})
public class BeanUtil {

	private BeanUtil() {
	}

	private static final Logger LOG = LoggerFactory.getLogger(BeanUtil.class);

	public static Object Map2Bean(Class type, Map map) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type);
			Object obj = type.newInstance();
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; ++i) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();

				if (!(map.containsKey(propertyName))) {
					continue;
				}

				Object value = map.get(propertyName);
				BeanUtils.setProperty(obj, propertyName, value);
			}
			return obj;
		} catch (Exception e) {
			throw new BusiRuntimeException(e.getMessage(), e);
		}
	}


	public static Map bean2Map(Object bean) {
		try {
			if (bean instanceof Map) {// 如果是Map,直接返回
				return (Map) bean;
			}
			Class type = bean.getClass();

			Map returnMap = new HashMap();
			BeanInfo beanInfo = Introspector.getBeanInfo(type);

			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; ++i) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!(propertyName.equals("class"))) {
					Method readMethod = descriptor.getReadMethod();
					Object result = readMethod.invoke(bean, new Object[0]);
					if (result != null) {
						returnMap.put(propertyName, result);
					} else {
						returnMap.put(propertyName, "");
					}
				}
			}
			return returnMap;
		} catch (Exception e) {
			throw new BusiRuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * 获取对象的属性名称
	 * 
	 * @param obj
	 * @return
	 * @discription 只获取类型为基本类型、字符串类型和日期类型的属性名称
	 */
	public static String[] getFieldsName(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		String[] fieldsName = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			Class fieldtype = fields[i].getType();
			if (!fieldtype.isPrimitive()) {
				Object fieldTypeObj = null;
				try {
					fieldTypeObj = fieldtype.newInstance();
				} catch (InstantiationException excp) {
					LOG.error(excp.getMessage(), excp);
					continue;
				} catch (IllegalAccessException excp) {
					LOG.error(excp.getMessage(), excp);
					continue;
				}
				if (!(fieldTypeObj instanceof String || fieldTypeObj instanceof java.util.Date)) {
					continue;
				}
			}
			String fieldName = fields[i].getName();
			fieldsName[i] = fieldName;
		}
		return fieldsName;
	}

	/**
	 * JavaBean属性的拷贝 前提：属性的名称要一一对应，并且类型要相同
	 * 
	 * @param target
	 * @param source
	 */
	public static void copyProperties(Object target, Object source) {
		try {
			BeanUtils.copyProperties(target, source);
		} catch (Exception e) {
			throw new BusiRuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * 获取对象的属性值
	 * 
	 * @param target
	 * @param filedName
	 * @throws Exception
	 */
	public static String getProperty(Object target, String filedName) {
		try {
			return BeanUtils.getProperty(target, filedName);
		} catch (Exception e) {
			throw new BusiRuntimeException(e.getMessage(), e);
		}

	}

}


