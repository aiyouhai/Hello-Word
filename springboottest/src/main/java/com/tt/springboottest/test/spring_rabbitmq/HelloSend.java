package com.tt.springboottest.test.spring_rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSend {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void sendApiCore() {

		amqpTemplate.convertAndSend("coreExchange", "api.core.user", "hello,user");

	}

	public void sendPayMent() {

		amqpTemplate.convertAndSend("coreExchange", "api.payment.word", "hello,word");

	}

	public void sendDirect() {
		for (int i = 1; i < 100; i++) {
			String msg = "hello" + i;
			amqpTemplate.convertAndSend("directExchange", "direct", msg);
		}

	}
}
