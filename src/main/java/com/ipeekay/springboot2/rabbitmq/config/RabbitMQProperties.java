package com.ipeekay.springboot2.rabbitmq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@ConfigurationProperties("ipeekay.notification")
@Configuration
public class RabbitMQProperties {

	private Queue queue;
	private Fanout fanout;
	private Topic topic;
	private Direct direct;

	@Data
	public static class Queue {
		private String smsQueue;
		private String emailQueue;
		private String pagerQueue;

	}

	@Data
	public static class Fanout {
		private String fanoutEx;
	}

	@Data
	public static class Topic {
		private String topicEx;
	}

	@Data
	public static class Direct {
		private String directEx;
	}
}
