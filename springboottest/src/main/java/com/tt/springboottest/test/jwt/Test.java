package com.tt.springboottest.test.jwt;

import io.jsonwebtoken.Claims;

public class Test {
	public static void main(String[] args) {
		Claims checkToken = JWTUtils.checkToken(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzaGl6aGVuamllIiwibmFtZSI6InNoaXpoZW5qaWUiLCJwd2QiOiIxMjMiLCJpYXQiOjE1OTYxMDE1NDksImV4cCI6MTU5NjEwMTU1OX0.XBgg2JhFS9eXqboO8FmmnQGmZD_z7Cp15hkW2NZ00MM");
		System.out.println(checkToken.get("name"));

	}
}
