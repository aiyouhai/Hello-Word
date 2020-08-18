package com.tt.springboottest.test.mail;

import java.io.UnsupportedEncodingException;

import org.springframework.messaging.MessagingException;

public class Test {
	public static void main(String[] args)
			throws MessagingException, UnsupportedEncodingException, javax.mail.MessagingException {
		Mailutil.sendMail("1253054193@qq.com", "hello");
	}
}
