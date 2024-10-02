package com.springbootrabbitmq.springboot.controller;

import com.springbootrabbitmq.springboot.dto.User;
import com.springbootrabbitmq.springboot.producer.RabbitMQJsonProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RabbitMQJsonController {
    public static final Logger logger = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    private RabbitMQJsonProducer rabbitMQJsonProducer;
    public RabbitMQJsonController(RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        rabbitMQJsonProducer.sendJsonMessage(user);
        return new ResponseEntity<>("Json Message sent to RabbitMQ...", HttpStatus.CREATED);

    }

}
