package com.ipeekay.springboot2.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeekay.springboot2.rabbitmq.config.RabbitMQProperties;
import com.ipeekay.springboot2.rabbitmq.dto.MessageDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificationService {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private RabbitMQProperties rabbitMQProperties;

	public void sendMessageToFanOut(MessageDto message) {

		log.info("Routing key is {}  ", message.getRoutingKey());

		rabbitTemplate.convertAndSend(rabbitMQProperties.getFanout().getFanoutEx(), message.getRoutingKey(), message);

	}

	public void sendMessageToTopic(MessageDto message) {

		log.info("Routing key is {} ", message.getRoutingKey());

		rabbitTemplate.convertAndSend(rabbitMQProperties.getTopic().getTopicEx(), message.getRoutingKey(), message);

	}

	public void sendMessageToDirect(MessageDto message) {

		log.info("Routing key is {} ", message.getRoutingKey());

		rabbitTemplate.convertAndSend(rabbitMQProperties.getDirect().getDirectEx(), message.getRoutingKey(), message);

	}
}
