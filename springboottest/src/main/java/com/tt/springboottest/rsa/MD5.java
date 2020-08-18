package com.tt.springboottest.rsa;

import org.springframework.util.DigestUtils;

public class MD5 {
	public static void main(String[] args) {
		String md5 = getMd5("18538570979123456", "", 1);

		System.out.println(md5);

	}

	public static String getMd5(String s1, String salt, int t) {
		String md5DigestAsHex = "";
		for (int i = 0; i < t; i++) {
			md5DigestAsHex += DigestUtils.md5DigestAsHex((s1 + salt).getBytes());
		}

		return md5DigestAsHex;
	}
}
