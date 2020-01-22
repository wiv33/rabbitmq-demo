package com.psawesome.rabbitmqdemo.tutorials.chap4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * package: com.psawesome.rabbitmqdemo.tutorials.chap4
 * author: PS
 * DATE: 2020-01-23 목요일 00:33
 */
@Slf4j
public class Tut4Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DirectExchange directExchange;

    AtomicInteger index = new AtomicInteger(0);
    AtomicInteger count = new AtomicInteger(0);

    private final List<String> keys = Arrays.asList("orange", "black", "green");

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        StringBuilder sb = new StringBuilder("Hello to ");
        if (this.index.incrementAndGet() == 3) {
            this.index.set(0);
        }
        String key = keys.get(this.index.get());
        sb.append(key).append(" ");
        sb.append(this.count.incrementAndGet());
        String message = sb.toString();
        template.convertAndSend(directExchange.getName(), key, message);
        log.info("key={}, [x] Sent '{}'", key, message);
    }
}
