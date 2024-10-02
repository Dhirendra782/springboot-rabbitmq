package com.springbootrabbitmq.springboot.controller;

import com.springbootrabbitmq.springboot.producer.RabbitMqProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RabbitMqController {

    private RabbitMqProducer rabbitMqProducer;
    public RabbitMqController(RabbitMqProducer rabbitMqProducer) {
        this.rabbitMqProducer = rabbitMqProducer;
    }

    //http://localhost:8080/api/publish?message=hello
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        rabbitMqProducer.sendMessage(message);
        return new ResponseEntity<>("Message sent to RabbitMQ...", HttpStatus.OK);
    }


}










