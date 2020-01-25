package com.psawesome.rabbitmqdemo.tutorials.chap2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * package: com.psawesome.rabbitmqdemo.tutorials.chap2
 * author: PS
 * DATE: 2020-01-21 화요일 21:35
 */
@Slf4j
public class Tut2Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public Tut2Sender() {
        log.info("send RUN ????");
//        send();
    }

    AtomicInteger dots = new AtomicInteger(0);

    AtomicInteger count = new AtomicInteger(0);

    @Scheduled(fixedDelay = 1000, initialDelay = 7777)
    public void send() {
        StringBuilder builder = new StringBuilder("Hello");
        if (dots.getAndIncrement() == 3) {
            dots.set(1);
        }
        for (int i = 0; i < dots.get(); i++) {
            builder.append('.');
        }
        builder.append(count.incrementAndGet());
        String message = builder.toString();
        template.convertAndSend(queue.getName(), message);
        log.info(" [x] Sent '{}'", message);
    }

//    @Scheduled(fixedDelay = 1000, initialDelay = 3333)
/*    public void send() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        Flux.defer(() -> Flux.zip(
                Flux.fromStream(Stream.iterate(new StringBuilder("Hello"), sb -> {
                    for (int i = 0; i < dots.get(); i++) {
                        sb.append(".");
                    }
                    return sb.append(count.incrementAndGet());
                }))
                , interval))
                .doOnNext(tuple -> {
                    if (dots.getAndIncrement() == 3) {
                        dots.set(1);
                    }
                    String message = tuple.getT1().toString();
                    template.convertAndSend(queue.getName(), message);
                    log.info("[x] Sent '{}'", message);
                }).subscribe()
        ;

    }*/
}
