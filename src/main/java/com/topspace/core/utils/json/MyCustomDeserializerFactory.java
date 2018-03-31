/**
 * @author Hunter
 * TopSpace
 * 2018-3-29 下午9:52:07
 * TODO //
 */
package com.topspace.core.utils.json;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.deser.CustomDeserializerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@SuppressWarnings("deprecation")
public class MyCustomDeserializerFactory extends CustomDeserializerFactory {

	private List<String> includeProperties = Lists.newArrayList();
	private List<String> ignoreProperties = Lists.newArrayList();
	private Map<Class<?>, Map<String, Object>> classMappings = Maps
			.newLinkedHashMap();

	public List<String> getIncludeProperties() {
		return includeProperties;
	}

	public MyCustomDeserializerFactory setIncludeProperties(
			List<String> includeProperties) {
		this.includeProperties = includeProperties;
		return this;
	}

	public List<String> getIgnoreProperties() {
		return ignoreProperties;
	}

	public MyCustomDeserializerFactory setIgnoreProperties(
			List<String> ignoreProperties) {
		this.ignoreProperties = ignoreProperties;
		return this;
	}

	public Map<Class<?>, Map<String, Object>> getClassMappings() {
		return classMappings;
	}

	public void setClassMappings(
			Map<Class<?>, Map<String, Object>> classMappings) {
		this.classMappings = classMappings;
	}

	public void addClassMappings(Class<?> clazz, Map<String, Object> map) {
		this.classMappings.put(clazz, map);
	}

	public <T> void addSpecificMapping(final Class<T> clazz,
			final Map<String, Object> map) {
		this.addSpecificMapping(clazz, new JsonDeserializer<T>() {
			@Override
			public T deserialize(JsonParser jp, DeserializationContext ctxt)
					throws IOException, JsonProcessingException {
				JsonBinder binder = JsonBinder.buildNormalBinder();
				T t = binder.getMapper().readValue(jp, clazz);
				for (Map.Entry<String, Object> set : map.entrySet()) {
					try {
						BeanUtils.setProperty(t, set.getKey(), set.getValue());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				return t;
			}
		});
	}
}


