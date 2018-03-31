/**
 * @author Hunter
 * TopSpace
 * 2018-3-29 下午9:49:51
 * TODO //
 */
package com.topspace.core.utils.json;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.deser.StdDeserializerProvider;

import com.google.common.collect.Lists;

/**
 * Jackson的简单封装.
 * 
 */
@SuppressWarnings("deprecation")
public class JsonBinder {

	private ObjectMapper mapper;

	public JsonBinder(Inclusion inclusion) {
		mapper = new ObjectMapper();
		// 设置输出包含的属性
		mapper.getSerializationConfig().setSerializationInclusion(inclusion);
		// 设置输入时忽略JSON字符串中存在而Java对象实际没有的属性
		mapper.getDeserializationConfig()
				.set(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
						false);
		mapper.setSerializerFactory(new MyCustomSerializerFactory());
		mapper.configure(
				org.codehaus.jackson.JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER,
				true);
	}

	/**
	 * 创建输出全部属性到Json字符串的Binder.
	 */
	public static JsonBinder buildNormalBinder() {
		return new JsonBinder(Inclusion.ALWAYS);
	}

	/**
	 * 创建只输出非空属性到Json字符串的Binder.
	 */
	public static JsonBinder buildNonNullBinder() {
		return new JsonBinder(Inclusion.NON_NULL);
	}

	/**
	 * 创建只输出初始值被改变的属性到Json字符串的Binder.
	 */
	public static JsonBinder buildNonDefaultBinder() {
		return new JsonBinder(Inclusion.NON_DEFAULT);
	}

	/**
	 * 如果JSON字符串为Null或"null"字符串,返回Null. 如果JSON字符串为"[]",返回空集合.
	 * 
	 * 如需读取集合如List/Map,且不是List<String>这种简单类型时使用如下语句: List<MyBean> beanList =
	 * binder.getMapper().readValue(listString, new
	 * TypeReference<List<MyBean>>() {});
	 */
	public <T> T fromJson(String jsonString, Class<T> clazz) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}

		try {
			return mapper.readValue(jsonString, clazz);
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * 如果对象为Null,返回"null". 如果集合为空集合,返回"[]".
	 */
	public String toJson(Object object) {

		try {
			return mapper.viewWriter(object.getClass()).writeValueAsString(
					object);
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * 设置转换日期类型的format pattern,如果不设置默认打印Timestamp毫秒数.
	 */
	public void setDateFormat(String pattern) {
		if (StringUtils.isNotBlank(pattern)) {
			DateFormat df = new SimpleDateFormat(pattern);
			mapper.getSerializationConfig().setDateFormat(df);
			mapper.getDeserializationConfig().setDateFormat(df);
		}
	}

	/**
	 * 取出Mapper做进一步的设置或使用其他序列化API.
	 */
	public ObjectMapper getMapper() {
		return mapper;
	}

	/**
	 * 设置Serializer时不序列化的属性
	 * 
	 * @param property
	 *            可变的string参数
	 * @return
	 */
	public JsonBinder setSerializerIgnoreProperty(String... property) {
		return setSerializerIgnoreProperty(Lists.newArrayList(property));
	}

	/**
	 * 设置Serializer时不序列化的属性
	 * 
	 * @param ignoreProperty
	 * @return
	 */
	public JsonBinder setSerializerIgnoreProperty(List<String> ignoreProperty) {
		mapper.setSerializerFactory(new MyCustomSerializerFactory()
				.setIgnoreProperties(ignoreProperty));
		mapper.getSerializationConfig().setSerializationView(String.class);
		return this;
	}

	/**
	 * 设置Serializer时输出指定属性
	 * 
	 * @param properties
	 *            可变的String参数
	 * @return
	 */
	public JsonBinder setSerializerIncludeProperty(String... propertys) {
		return setSerializerIncludeProperty(Lists.newArrayList(propertys));

	}

	/**
	 * 设置Serializer时输出指定属性
	 * 
	 * @param includeProperties
	 * @return
	 */
	// includeProperties
	public JsonBinder setSerializerIncludeProperty(List<String> includeProperty) {
		MyCustomSerializerFactory sf = new MyCustomSerializerFactory()
				.setIncludeProperty(includeProperty);
		mapper.setSerializerFactory(sf);
		mapper.getSerializationConfig().setSerializationView(String.class);
		return this;
	}

	public JsonBinder setSerializerFactory(MyCustomSerializerFactory sf) {
		Map<Class<?>, List<String>> map = sf.getClassMappings();
		for (Map.Entry<Class<?>, List<String>> cm : map.entrySet()) {
			sf.addGenericMapping(cm.getKey(), cm.getValue());
		}
		mapper.setSerializerFactory(sf);
		mapper.getSerializationConfig().setSerializationView(String.class);
		return this;
	}

	// /
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JsonBinder setJsonSerializer(JsonSerializer... serializers) {
		MyCustomSerializerFactory sf = new MyCustomSerializerFactory();
		for (JsonSerializer serializer : serializers) {
			sf.addGenericMapping(serializer.handledType(), serializer);
		}
		mapper.setSerializerFactory(sf);
		mapper.getSerializationConfig().setSerializationView(String.class);
		return this;
	}

	/**
	 * 设置Deserializer时只包含的属性，如果不在includeProperties内都忽视
	 * 
	 * @param properties
	 *            可变的String参数
	 * @return
	 */
	public JsonBinder setDeserializerIncludeProperty(String... properties) {
		return setDeserializerIncludeProperty(Lists.newArrayList(properties));
	}

	/**
	 * 设置Deserializer时只包含的属性，如果不在includeProperties内都忽视
	 * 
	 * @param includeProperties
	 * @return
	 */
	public JsonBinder setDeserializerIncludeProperty(
			List<String> includeProperties) {
		MyCustomDeserializerFactory sf = new MyCustomDeserializerFactory();
		sf.setIncludeProperties(includeProperties);
		mapper.setDeserializerProvider(new StdDeserializerProvider(sf));
		return this;
	}

	/**
	 * 设置Deserializer时无视的属性
	 * 
	 * @param properties
	 *            可变的String参数
	 * @return
	 */
	public JsonBinder setDeserializerIgnoreProperty(String... properties) {
		return setDeserializerIgnoreProperty(Lists.newArrayList(properties));
	}

	/**
	 * 设置Deserializer时无视的属性
	 * 
	 * @param ignoreProperties
	 * @return
	 */
	public JsonBinder setDeserializerIgnoreProperty(
			List<String> ignoreProperties) {
		MyCustomDeserializerFactory sf = new MyCustomDeserializerFactory();
		mapper.setDeserializerProvider(new StdDeserializerProvider(sf));
		sf.setIgnoreProperties(ignoreProperties);
		return this;
	}

	public JsonBinder setDeserializerFactory(MyCustomDeserializerFactory df) {
		Map<Class<?>, Map<String, Object>> map = df.getClassMappings();
		for (Map.Entry<Class<?>, Map<String, Object>> set : map.entrySet()) {
			df.addSpecificMapping(set.getKey(), set.getValue());
		}
		mapper.setDeserializerProvider(new StdDeserializerProvider(df));
		return this;
	}

}



