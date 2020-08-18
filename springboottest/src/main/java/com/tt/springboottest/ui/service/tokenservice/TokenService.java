package com.tt.springboottest.ui.service.tokenservice;

public interface TokenService {
	String getToken();

	boolean checkToken(String token);
}
