package com.tt.springboottest.ui.service.tokenservice;

import org.springframework.stereotype.Service;

import com.tt.springboottest.test.jwt.JWTUtils;
import com.tt.springboottest.test.jwt.User;

import io.jsonwebtoken.Claims;

@Service
public class TokenServiceImpl implements TokenService {

	@Override
	public String getToken() {
		User user = new User();
		user.setName("shizhenjie");
		user.setPwd("123");
		String token = JWTUtils.getToken(user);
		return token;

	}

	@Override
	public boolean checkToken(String token) {
		Claims checkToken = JWTUtils.checkToken(token);
		if (checkToken != null) {
			return true;
		}
		return false;
	}

}
