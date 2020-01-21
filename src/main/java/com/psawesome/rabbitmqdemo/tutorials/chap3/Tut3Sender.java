package com.psawesome.rabbitmqdemo.tutorials.chap3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * package: com.psawesome.rabbitmqdemo.tutorials.chap3
 * author: PS
 * DATE: 2020-01-21 화요일 23:03
 */
@Slf4j
public class Tut3Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private FanoutExchange fanout;

    AtomicInteger dots = new AtomicInteger(0);
    AtomicInteger count = new AtomicInteger(0);

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        StringBuilder sb = new StringBuilder("Hello");
        if (dots.getAndIncrement() == 3) {
            dots.set(1);
        }
        for (int i = 0; i < dots.get(); i++) {
            sb.append(".");
        }
        sb.append(count.incrementAndGet());
        String msg = sb.toString();
        template.convertAndSend(fanout.getName(), "", msg);
        log.info(" [x] Sent '{}'", msg);
    }
}
