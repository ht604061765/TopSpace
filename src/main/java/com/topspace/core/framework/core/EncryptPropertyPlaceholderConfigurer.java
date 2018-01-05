/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-23 上午9:33:14
 * TODO //
 */
package com.topspace.core.framework.core;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.topspace.core.utils.EncryptUtil;
import com.topspace.core.utils.StringUtil;



public class EncryptPropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {

	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			Properties props) throws BeansException {
		Set<Entry<Object, Object>> entrys = props.entrySet();
		for (java.util.Map.Entry<Object, Object> e : entrys) {
			String value = (String) e.getValue();
			if (isEncrypt(value)) {
				value = descrypt(value);
				String key = e.getKey().toString();
				// System.out.println(key + " == " + value);
				props.setProperty(key, value);
			}
		}

		super.processProperties(beanFactoryToProcess, props);
	}

	private boolean isEncrypt(String value) {
		if (!StringUtil.isEmpty(value)) {
			if (value.startsWith("(") && value.endsWith(")")) {
				return true;
			}
		}
		return false;
	}

	private  String descrypt(String value) {
		if (StringUtil.isEmpty(value)) {
			return value;
		} else {
			value = value.substring(1, value.length() - 1);
			return EncryptUtil.decryptAES(value);
		}
	}
	
	public static void main(String[] args) {
//		String aaa = "(0Smzv3AMZ3HH3bmv97M1/A==)";
//		String bbb = descrypt(aaa);
		System.out.println(EncryptUtil.encryptAES("ht5828046"));
	}

}
