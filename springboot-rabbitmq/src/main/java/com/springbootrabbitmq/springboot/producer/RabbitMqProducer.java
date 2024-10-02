package com.springbootrabbitmq.springboot.producer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {
    public static final Logger logger = LoggerFactory.getLogger(RabbitMqProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private RabbitTemplate rabbitTemplate;
    public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    //create method send message
    public void sendMessage(String message) {
        logger.info(String.format("Message sent -> %s",message));
        rabbitTemplate.convertAndSend(exchange,routingKey,message);
    }

}



















