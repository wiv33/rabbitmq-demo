package com.psawesome.rabbitmqdemo.tutorials.chap5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * package: com.psawesome.rabbitmqdemo.tutorials.chap5
 * author: PS
 * DATE: 2020-01-24 금요일 00:42
 */
@Slf4j
public class Tut5Sender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private TopicExchange topic;

    AtomicInteger index = new AtomicInteger(0);

    AtomicInteger count = new AtomicInteger(0);

    private final List<String> keys = Arrays.asList("quick.orange.rabbit", "lazy.orange.elephant",
            "quick.orange.fox", "lazy.brown.fox", "lazy.pink.rabbit", "quick.brown.fox");

    @Scheduled(fixedDelay = 10000, initialDelay = 500)
    public void send() {
        int keyLength = keys.size();
        Flux.interval(Duration.ofSeconds(3))
                .map(c -> index.getAndIncrement() % keyLength)
                .flatMap(m -> Flux.zip(Flux.just(keys.get(m)), Flux.just("Hello Tut5 to " + count.incrementAndGet())))
                .subscribe(c -> {
                    log.info("key={}, [x] Sent '{}'", c.getT1(), c.getT2());
                    template.convertAndSend(topic.getName(), c.getT1(), c.getT2());
                });
    }
}
