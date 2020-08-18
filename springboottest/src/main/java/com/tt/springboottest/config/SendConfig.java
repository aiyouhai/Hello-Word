package com.tt.springboottest.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendConfig {
	@Bean
	public Queue coreQueue() {
		return new Queue("q_test_02", true, false, false);
	}

	@Bean
	public Queue paymentQueue() {
		return new Queue("q_test_03");
	}

	@Bean
	public Queue directQueue() {
		return new Queue("q_test_04");
	}

	/**
	 * TopicExchange
	 * 
	 * @return
	 */
	@Bean
	public TopicExchange coreExchange() {
		return new TopicExchange("coreExchange");
	}

	/**
	 * DirectExchange
	 * 
	 * @return
	 */
	@Bean
	public DirectExchange paymentExchange() {
		return new DirectExchange("directExchange");
	}

	/***
	 * 绑定queue到exchange
	 * 
	 * @param directQueue
	 * @param directExchange
	 * @return
	 */
	@Bean
	public Binding bindingDirectExchange(Queue directQueue, DirectExchange directExchange) {
		return BindingBuilder.bind(directQueue).to(directExchange).with("direct");
	}

	/***
	 * 绑定queue到exchange
	 * 
	 * @param coreQueue
	 * @param coreExchange
	 * @return
	 */
	@Bean
	public Binding bindingCoreExchange(Queue coreQueue, TopicExchange coreExchange) {
		return BindingBuilder.bind(coreQueue).to(coreExchange).with("api.core.*");
	}

	@Bean
	public Binding bindingPaymentExchange(Queue paymentQueue, TopicExchange coreExchange) {
		return BindingBuilder.bind(paymentQueue).to(coreExchange).with("api.payment.#");
	}
}
