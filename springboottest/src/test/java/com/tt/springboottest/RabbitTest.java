package com.tt.springboottest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tt.springboottest.test.spring_rabbitmq.HelloSend;

@SpringBootTest(classes = SpringBootTestApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RabbitTest {

	@Autowired
	private HelloSend helloSend;

	@Test
	public void sendRabbit1() {
		helloSend.sendApiCore();
	}

	@Test
	public void sendRabbit2() {
		helloSend.sendPayMent();
	}

	@Test
	public void sendRabbit3() {
		helloSend.sendDirect();
	}
}
