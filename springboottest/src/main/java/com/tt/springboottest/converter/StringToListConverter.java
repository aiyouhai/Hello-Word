package com.tt.springboottest.converter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.alibaba.fastjson.JSONObject;

public class StringToListConverter<T> implements Converter<String, List<T>> {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<T> convert(String source) {
		Type type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		Class clazz = type.getClass();
		List<T> list = JSONObject.parseArray(source, clazz);
		return list;

	}

}
