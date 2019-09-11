package com.ipeekay.springboot2.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipeekay.springboot2.rabbitmq.dto.MessageDto;
import com.ipeekay.springboot2.rabbitmq.service.NotificationService;

@Configuration
@RestController
public class MessageController {

	@Autowired
	private NotificationService notificationService;

	@PostMapping(value = "send/fanout")
	public void sendMessageFanout(@RequestBody MessageDto message) {

		notificationService.sendMessageToFanOut(message);

	}

	@PostMapping(value = "send/topic")
	public void sendMessageTopic(@RequestBody MessageDto message) {

		notificationService.sendMessageToTopic(message);

	}

	@PostMapping(value = "send/direct")
	public void sendMessageDirect(@RequestBody MessageDto message) {

		notificationService.sendMessageToDirect(message);

	}

}
