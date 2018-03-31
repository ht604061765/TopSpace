/**
 * @author Hunter
 * TopSpace
 * 2018-3-29 下午9:52:41
 * TODO //
 */
package com.topspace.core.utils.json;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.BeanPropertyWriter;
import org.codehaus.jackson.map.ser.BeanSerializerBuilder;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class MyCustomSerializerFactory extends CustomSerializerFactory {

	private List<String> ignoreProperty = Lists.newArrayList();

	private List<String> includeProperty = Lists.newArrayList();

	private Map<Class<?>, List<String>> classMappings = Maps.newLinkedHashMap();

	public List<String> getIgnoreProperty() {
		return ignoreProperty;
	}

	public MyCustomSerializerFactory setIgnoreProperties(
			List<String> ignoreProperties) {
		this.ignoreProperty = ignoreProperties;
		return this;
	}

	/**
	 * 设置Serializer时不序列化的属性
	 * 
	 * @param property
	 *            可变的string参数
	 * @return
	 */
	public MyCustomSerializerFactory setIgnoreProperty(String... property) {
		return setIgnoreProperties(Lists.newArrayList(property));
	}

	public List<String> getIncludeProperty() {
		return includeProperty;
	}

	public MyCustomSerializerFactory setIncludeProperty(
			List<String> includeProperty) {
		this.includeProperty = includeProperty;
		return this;
	}

	/**
	 * 设置Serializer时输出指定属性
	 * 
	 * @param properties
	 *            可变的String参数
	 * @return
	 */
	public MyCustomSerializerFactory setIncludeProperty(String... propertys) {
		return setIncludeProperty(Lists.newArrayList(propertys));

	}

	public Map<Class<?>, List<String>> getClassMappings() {
		return classMappings;
	}

	public void setClassMappings(Map<Class<?>, List<String>> classMappings) {
		this.classMappings = classMappings;
	}

	public MyCustomSerializerFactory addClassMappings(Class<?> clazz,
			String... fields) {
		return addClassMappings(clazz, Lists.newArrayList(fields));
	}

	public MyCustomSerializerFactory addClassMappings(Class<?> clazz,
			List<String> fieldList) {
		this.classMappings.put(clazz, fieldList);
		return this;
	}

	public <T> void addGenericMapping(Class<? extends T> clazz,
			final List<String> fieldList) {
		this.addGenericMapping(clazz, new JsonSerializer<T>() {
			@Override
			public void serialize(T value, JsonGenerator jgen,
					SerializerProvider provider) throws IOException,
					JsonProcessingException {
				Map<String, Object> map = Maps.newHashMap();
				for (String field : fieldList) {
					try {
						map.put(field, BeanUtils.getProperty(value, field));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				jgen.writeObject(map);
			}
		});

	}

	//
	// protected BeanSerializer processViews(SerializationConfig config,
	// BasicBeanDescription beanDesc,
	// BeanSerializer ser, List<BeanPropertyWriter> props) {
	// ser = super.processViews(config, beanDesc, ser, props);
	// super.processViews(arg0, arg1)
	// BeanPropertyWriter[] writers = props.toArray(new
	// BeanPropertyWriter[props.size()]);
	// for (int i = 0; i < writers.length; ++i) {
	// String pname = writers[i].getName();
	// //如果有设置includeProperties那么outputProperties优先
	// if (!includeProperty.isEmpty()) {
	// if (includeProperty.contains(pname)) {
	// writers[i] = new FilteredWriter(writers[i]);
	// } else {
	// writers[i] = null;
	// }
	// } else if (ignoreProperty.contains(pname)) {
	// writers[i] = null;
	// } else {
	// writers[i] = new FilteredWriter(writers[i]);
	// }
	// }
	// ser.withFiltered(filtered)
	// ser = ser.withFiltered(writers);
	// return ser;
	// }

	@Override
	protected void processViews(SerializationConfig config,
			BeanSerializerBuilder builder) {
		// Let's use default serializer modification as the baseline
		super.processViews(config, builder);

		/*
		 * And only change handling of that one bean (more likely, you would
		 * want to handle all classes in a package, or with some name -- this
		 * would be less work than having separate custom serializer for all
		 * classes)
		 */
		List<BeanPropertyWriter> props = builder.getProperties();
		BeanPropertyWriter[] writers = props
				.toArray(new BeanPropertyWriter[props.size()]);
		for (int i = 0; i < writers.length; ++i) {
			String pname = writers[i].getName();
			// 如果有设置includeProperties那么outputProperties优先
			if (!includeProperty.isEmpty()) {
				if (includeProperty.contains(pname)) {
					writers[i] = new FilteredWriter(writers[i]);
				} else {
					writers[i] = null;
				}
			} else if (ignoreProperty.contains(pname)) {
				writers[i] = null;
			} else {
				writers[i] = new FilteredWriter(writers[i]);
			}
		}
		// Important: update builder with filtered property definitions
		builder.setFilteredProperties(writers);
	}

	/**
	 * And then custom bean property writer that implements custom serialization
	 * functionality for one of properties
	 */
	class FilteredWriter extends BeanPropertyWriter {
		final BeanPropertyWriter _writer;

		public FilteredWriter(BeanPropertyWriter w) {
			super(w);
			_writer = w;
		}

		public FilteredWriter(BeanPropertyWriter w, JsonSerializer<Object> ser) {
			super(w);
			_writer = w;
		}

		@Override
		public BeanPropertyWriter withSerializer(JsonSerializer<Object> ser) {
			return new FilteredWriter(_writer, ser);
		}

		@Override
		public void serializeAsField(Object bean, JsonGenerator jgen,
				SerializerProvider prov) throws Exception {
			super.serializeAsField(bean, jgen, prov);
			// We know the type (although interface can't expose it)
			// String value = ((ViewBean) bean).name;
			// Convert nulls to "", otherwise upper case
			// value = (value == null) ? "" : value.toUpperCase();
			// jgen.writeStringField("name", value);
		}

	}
}


