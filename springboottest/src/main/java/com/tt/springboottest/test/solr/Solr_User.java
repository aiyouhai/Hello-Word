package com.tt.springboottest.test.solr;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;

public class Solr_User implements Serializable {
	@Field(value = "name")
	private String name;
	@Field(value = "age")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
