package com.ipeekay.springboot2.rabbitmq.listner;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.ipeekay.springboot2.rabbitmq.dto.MessageDto;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SMSListener {
	
	@RabbitListener(queues = "smsQueue")
	public void receiveSMS(MessageDto message) {
		log.info("Received in SMS <" + message + ">");

		log.info("Message processed...");
	}

}
