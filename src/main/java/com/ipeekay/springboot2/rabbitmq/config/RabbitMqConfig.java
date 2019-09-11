package com.ipeekay.springboot2.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

	@Autowired
	private RabbitMQProperties rabbitMQProperties;

	// declare fanout exchange
	
	@Bean
	public Exchange fanoutExchange() {
		return new FanoutExchange(rabbitMQProperties.getFanout().getFanoutEx());
	}

	// declare topic exchange
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(rabbitMQProperties.getTopic().getTopicEx());
	}
	
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(rabbitMQProperties.getDirect().getDirectEx());
	}
	
	
	// declaring queues 

	@Bean
	public Queue queueSMS() {
		return new Queue(rabbitMQProperties.getQueue().getSmsQueue());
	}

	@Bean
	public Queue queueEMAIL() {
		return new Queue(rabbitMQProperties.getQueue().getEmailQueue());
	}

	@Bean
	public Queue queuePAGER() {

		return new Queue(rabbitMQProperties.getQueue().getPagerQueue());
	}

	
	// binding queues to fanout
	@Bean
	public Binding bindingSMS(final Queue queueSMS, final Exchange fanoutExchange) {
		return BindingBuilder.bind(queueSMS).to(fanoutExchange).with("*").noargs();
	}

	@Bean
	public Binding bindingEMAIL(final Queue queueEMAIL, final Exchange fanoutExchange) {
		return BindingBuilder.bind(queueEMAIL).to(fanoutExchange).with("*").noargs();
	}

	@Bean
	public Binding bindingPAGER(final Queue queuePAGER, final Exchange fanoutExchange) {
		return BindingBuilder.bind(queuePAGER).to(fanoutExchange).with("*").noargs();
	}

	
	// binding queues to topic 
	
	@Bean
	Binding bindingTopicSMS(final Queue queueSMS, final TopicExchange topicExchange) {
		return BindingBuilder.bind(queueSMS).to(topicExchange).with("*."+rabbitMQProperties.getQueue().getSmsQueue()+".*");
	}
	
	@Bean
	Binding bindingTopicEMAIL(final Queue queueEMAIL, final TopicExchange topicExchange) {
		return BindingBuilder.bind(queueEMAIL).to(topicExchange).with("*."+rabbitMQProperties.getQueue().getEmailQueue()+".*");
	}
	
	@Bean
	Binding bindingTopicPager(final Queue queuePAGER, final TopicExchange topicExchange) {
		return BindingBuilder.bind(queuePAGER).to(topicExchange).with("*."+rabbitMQProperties.getQueue().getPagerQueue()+".*");
	}
	
	
	
	// binding queues to direct 
	
	@Bean
	Binding bindingDirectSMS(final Queue queueSMS, final Exchange directExchange) {
		return BindingBuilder.bind(queueSMS).to(directExchange).with("SMS").noargs();
	}
	
	@Bean
	Binding bindingDirectEMAIL(final Queue queueEMAIL, final Exchange directExchange) {
		return BindingBuilder.bind(queueEMAIL).to(directExchange).with("EMAIL").noargs();
	}
	
	@Bean
	Binding bindingDirectPager(final Queue queuePAGER, final Exchange directExchange) {
		return BindingBuilder.bind(queuePAGER).to(directExchange).with("PAGER").noargs();
	}
	
	
}
