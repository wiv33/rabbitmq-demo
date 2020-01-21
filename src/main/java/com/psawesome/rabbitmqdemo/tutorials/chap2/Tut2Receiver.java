package com.psawesome.rabbitmqdemo.tutorials.chap2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

/**
 * package: com.psawesome.rabbitmqdemo.tutorials.chap2
 * author: PS
 * DATE: 2020-01-21 화요일 21:29
 */
@RabbitListener(queues = "tut2.hello")
@Slf4j
public class Tut2Receiver {

    public final int instance;
    public Tut2Receiver(int instance) {
        this.instance = instance;
    }

    @RabbitHandler
    public void receive(String in) {
        StopWatch watch = new StopWatch();
        watch.start();
        log.info("instance: {}, [x] Received '{}'", this.instance, in);
        try {
            doWork(in);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        watch.stop();
        log.info("instance: {}, [x] Done in {}s", this.instance, watch.getTotalTimeSeconds());
    }

    private void doWork(String in) throws InterruptedException {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }
}
