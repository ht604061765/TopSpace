/**
 * @author Hunter
 * TopSpace
 * 2018-3-29 下午9:46:08
 * TODO //
 */
package com.topspace.core.utils;

/**
 * Copyright 2010 Fuchun.
 * 
 * Licensed under the Apache License, Version 2.0 (the 'License'); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an 'AS IS' BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.type.TypeReference;

import com.topspace.core.utils.json.JsonBinder;

@SuppressWarnings("unchecked")
public class JsonUtils {

	private static ObjectMapper mapper = null;
	static {
		mapper = new ObjectMapper();
		mapper.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(
				org.codehaus.jackson.JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER,
				true);
	}

	/**
	 * 转换object to json
	 * 
	 * @param target
	 * @return
	 * @throws Exception
	 */
	public static String toJson(Object target) {
		String json = "";
		try {
			StringWriter sw = new StringWriter();
			JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
			mapper.writeValue(gen, target);
			gen.close();
			json = sw.toString();
		} catch (Exception e) {
			throw new RuntimeException("对象转换Json字符串出错," + target.toString(), e);
		}
		return json;
	}

	/**
	 * 
	 * @param target
	 * @param serializers
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String toJson(Object target, JsonSerializer... serializers) {
		if (target == null) {
			return null;
		}

		try {
			JsonBinder binder = JsonBinder.buildNormalBinder();
			binder.setJsonSerializer(serializers);
			return binder.toJson(target);
		} catch (Exception e) {
			throw new RuntimeException("对象转换Json字符串出错," + target.toString(), e);
		}
	}

	/**
	 * 转换object to json 并排除某些属性
	 * 
	 * @param target
	 * @param propertys
	 * @return
	 */
	public static String toJson(Object target, String... propertys) {
		String json = "";
		try {
			JsonBinder binder = JsonBinder.buildNormalBinder();
			binder.setSerializerIgnoreProperty(propertys);
			json = binder.toJson(target);
		} catch (Exception e) {
			throw new RuntimeException("对象转换Json字符串出错," + target.toString(), e);
		}
		return json;
	}

	/**
	 * 转换json to object
	 * 
	 * @param <T>
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> clazz) {
		try {
			JsonBinder binder = JsonBinder.buildNormalBinder();
			return binder.fromJson(json, clazz);
		} catch (Exception ex) {
			throw new RuntimeException("解析json出错,json = " + json, ex);
		}
	}

	/**
	 * 转换json to HashMap
	 * 
	 * @param json
	 * @return map
	 */
	public static <K, V> Map<K, V> fromJson(String json) {
		return fromJson(json, HashMap.class);
	}

	/**
	 * 转换json to List<Object>
	 * 
	 * @param json
	 * @return
	 */
	public static <T> List<T> fromJsonList(String json) {
		try {
			JsonBinder binder = JsonBinder.buildNormalBinder();
			return (List<T>) binder.getMapper().readValue(json,
					new TypeReference<List<T>>() {
					});
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		String jsonString = "{ruleType:\"\"}";
		JsonUtils.fromJson(jsonString);
	}
}


