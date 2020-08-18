package com.tt.springboottest.rsa;

public interface SystemConstants {
	/**
	 * 项目存放用户session名 在接口中的只能存在常量 默认会在前面添加 public static final
	 */
	String LOGIN_USER = "LOGIN_USER";

	/**
	 * 存放RSA公钥文件路径
	 */
	String RSA_PUBLIC_KEY_PATH = "E:\\honey-blog\\public_key.txt";
	/**
	 * 存放RSA私钥文件路径
	 */
	String RSA_PRIVATE_KEY_PATH = "E:\\honey-blog\\private_key.txt";
}
