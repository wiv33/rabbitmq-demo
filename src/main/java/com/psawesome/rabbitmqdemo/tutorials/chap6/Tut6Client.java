package com.psawesome.rabbitmqdemo.tutorials.chap6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * package: com.psawesome.rabbitmqdemo.tutorials.chap6
 * author: PS
 * DATE: 2020-01-24 금요일 23:57
 */
@Slf4j
public class Tut6Client {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DirectExchange directExchange;

    int start = 0;

    @Scheduled(fixedDelay = 1000, initialDelay = 7777)
    public void send() {
        log.info(" [x] Requesting fib({})", start);
        Integer response = (Integer) template.convertSendAndReceive(directExchange.getName(), "rpc", start++);
        log.info(" [.] Got '{}'", response);

    }
}
