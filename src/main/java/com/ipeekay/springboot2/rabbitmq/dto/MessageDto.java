package com.ipeekay.springboot2.rabbitmq.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageDto implements Serializable {

	private String msgLabel;
	private String msgBody;
	private String routingKey;
  
}
