package com.psawesome.rabbitmqdemo.tutorials.chap1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * package: com.psawesome.rabbitmqdemo.tutorial
 * author: PS
 * DATE: 2020-01-21 화요일 00:40
 */
@RabbitListener(queues = "hello")
@Slf4j
public class Tuto1Receiver {

    @RabbitHandler
    public void receive(String in) {
        log.info(" [x] Received '{}'",in);
    }
}
