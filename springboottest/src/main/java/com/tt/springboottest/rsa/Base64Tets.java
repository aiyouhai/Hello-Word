package com.tt.springboottest.rsa;

import org.apache.commons.codec.binary.Base64;

public class Base64Tets {
	public static void main(String[] args) {
		String msg = "南海一刀";
		String encode = Base64Tets.encode(msg.getBytes());
		System.out.println(encode);
		String decode = Base64Tets.decode(encode.getBytes());
		System.out.println(decode);
	}

	public static String encode(byte[] be) {
		return new String(Base64.encodeBase64(be));
	}

	public static String decode(byte[] be) {

		return new String(Base64.decodeBase64(be));
	}

}
