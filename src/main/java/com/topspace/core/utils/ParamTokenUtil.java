/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-22 下午10:31:22
 * TODO //
 */
package com.topspace.core.utils;

import java.util.HashMap;
import java.util.Map;

import com.topspace.core.framework.exception.BusiRuntimeException;


public class ParamTokenUtil {

	private final static String URL_PARAM_SPLIT = "|";
	private final static String URL_KEY_VALUE_SPLIT = "=";

	/**
	 * URL请求参数加密
	 * 
	 * @param keyValue
	 *            key-value的的匹对形式,即参数必须个数为偶数
	 * @return 返回加密后的字符串
	 */
	public static String encryptUrlParamToken(String... keyValue) {
		if (keyValue.length % 2 != 0) {
			throw new BusiRuntimeException("参数错误,参数不是匹配对");
		}

		StringBuilder sb = new StringBuilder(256);

		for (int i = 0; i < keyValue.length; i = i + 2) {
			String key = keyValue[i];
			String value = keyValue[i + 1];
			checkParam(key, value);

			if (i < (keyValue.length - 2)) {
				sb.append(key).append(URL_KEY_VALUE_SPLIT).append(value)
						.append(URL_PARAM_SPLIT);
			} else {
				sb.append(key).append(URL_KEY_VALUE_SPLIT).append(value);
			}

		}
		return EncryptUtil.encryptURL(sb.toString());
	}

	private static void checkParam(String key, String value) {
		if (StringUtil.isEmpty(key)) {
			throw new BusiRuntimeException("参数错误，参数key不能为空");
		}
		if (key == null || key.indexOf(URL_KEY_VALUE_SPLIT) > 0) {
			throw new BusiRuntimeException("参数错误，参数key不能存在特殊字符  等号 = ");
		}

		if (value != null && value.indexOf(URL_KEY_VALUE_SPLIT) > 0) {
			throw new BusiRuntimeException("参数错误，参数value不能存在特殊字符  等号 = ");
		}

		if (key == null || key.indexOf(URL_PARAM_SPLIT) > 0) {
			throw new BusiRuntimeException("参数错误，参数key不能存在特殊字符  竖线 | ");
		}

		if (value != null && value.indexOf(URL_PARAM_SPLIT) > 0) {
			throw new BusiRuntimeException("参数错误，参数value不能存在特殊字符  竖线 | ");
		}
	}

	/**
	 * 获取Token解密后的key对应的value
	 * 
	 * @param request
	 * @param key
	 * @return 返回key对应的值
	 */
	public static String getTokenValue(String token, String key) {
		String token_dec = EncryptUtil.decryptURL(token);// 解密后的token字符串
		String tokens[] = StringUtil.split(token_dec, URL_PARAM_SPLIT);// 分隔符切分

		for (int i = 0; i < tokens.length; i++) {
			String keyValue[] = StringUtil
					.split(tokens[i], URL_KEY_VALUE_SPLIT);
			if (key.equalsIgnoreCase(keyValue[0])) {
				return keyValue.length == 2 ? keyValue[1] : "";
			}
		}
		return null;
	}

	/**
	 * 将token解密，返回键值对。用于token中有多个参数的情况。
	 * 
	 * @param token
	 * @return
	 */
	public static Map<String, String> getTokenValue(String token) {
		token = EncryptUtil.decryptURL(token);
		String tokens[] = StringUtil.split(token, URL_PARAM_SPLIT);

		Map<String, String> tokenMap = new HashMap<String, String>();
		for (int i = 0; i < tokens.length; i++) {
			String keyValue[] = StringUtil
					.split(tokens[i], URL_KEY_VALUE_SPLIT);
			if (keyValue != null && keyValue.length == 2) {
				tokenMap.put(keyValue[0], keyValue[1]);
			}
		}
		return tokenMap;
	}

}


