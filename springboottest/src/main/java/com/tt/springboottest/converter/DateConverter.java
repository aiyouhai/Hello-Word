package com.tt.springboottest.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class DateConverter implements Converter<String, Date> {
	private static final SimpleDateFormat DATE = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat DATE_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public Date convert(String source) {
		if (StringUtils.isEmpty(source)) {
			return null;
		}
		Date date = null;
		try {
			// 根据字符串长度尝试进行日期转换
			if (10 == source.length()) {
				date = DATE.parse(source);
			} else {
				date = DATE_TIME.parse(source);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return date;
	}

}
