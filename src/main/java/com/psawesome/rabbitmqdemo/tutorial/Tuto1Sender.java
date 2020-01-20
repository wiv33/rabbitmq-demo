package com.psawesome.rabbitmqdemo.tutorial;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
import java.util.stream.Stream;

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
        String message = "Hello World : " + UUID.randomUUID();
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1L));
        Flux<Tuple2<String, Long>> defer = Flux.defer(() -> Flux.zip(Flux.fromIterable(Arrays.asList(message)), interval));
        defer.doOnNext(df -> this.rabbitTemplate.convertAndSend(queue.getName(), df.getT1() + " : " + df.getT2()));
        log.info("Queue Name= '{}' :: Send= '{}'", queue.getName(), message);
    }
}
