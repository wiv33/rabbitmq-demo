package com.psawesome.rabbitmqdemo.tutorials.chap1;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Arrays;
import java.util.UUID;

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

    @Scheduled(fixedDelay = 10000, initialDelay = 500)
    public void send() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1L));
        Flux<Object> generate = Flux.generate(sink -> sink.next("Hello World : " + UUID.randomUUID()));
        Flux.zip(generate, interval)
                .map(Tuple2::getT1)
                .subscribe(con -> {
                    log.info("Queue Name= '{}' :: Sent= '{}'", queue.getName(), con);
                    this.rabbitTemplate.convertAndSend(queue.getName(), con);
                });

    }

}
