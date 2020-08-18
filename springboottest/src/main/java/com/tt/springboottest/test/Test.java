package com.tt.springboottest.test;

import java.util.List;

import com.tt.springboottest.util.DataApi;

public class Test {
	public static void main(String[] args) throws Exception {
		DataApi dateAPI = new DataApi();
		// 向工作日表插入数据，初始化时打开注释
		List<String> list = dateAPI.getWorkDays();
		for (String string : list) {
			System.out.println(string);
		}
	}
}
