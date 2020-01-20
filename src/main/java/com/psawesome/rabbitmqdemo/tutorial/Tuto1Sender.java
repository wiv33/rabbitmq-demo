package com.psawesome.rabbitmqdemo.tutorial;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * package: com.psawesome.rabbitmqdemo.tutorial
 * author: PS
 * DATE: 2020-01-21 화요일 00:43
 */
@Slf4j
@NoArgsConstructor
public class Tuto1Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello World";
        this.rabbitTemplate.convertAndSend(queue.getName(), message);
        log.info(" [x] Send '{}'", message);
    }
}
