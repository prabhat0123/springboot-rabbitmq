package com.ipeekay.springboot2.rabbitmq.listner;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.ipeekay.springboot2.rabbitmq.dto.MessageDto;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmailListener {

	@RabbitListener(queues = "emailQueue")
	public void receiveEmail(MessageDto message) {
		log.info("Received in EMAIL <" + message + ">");

		log.info("Message processed...");
	}

}
