package com.springbootrabbitmq.springboot.consumer;

import com.springbootrabbitmq.springboot.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {
    public static final Logger logger = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);


    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumerJsonMessage(User user) {
        logger.info(String.format("Recieved JSON Message -> %s",user.toString()));

    }

}














