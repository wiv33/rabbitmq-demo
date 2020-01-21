package com.psawesome.rabbitmqdemo.tutorials.chap3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

/**
 * package: com.psawesome.rabbitmqdemo.tutorials.chap3
 * author: PS
 * DATE: 2020-01-21 화요일 22:57
 */
@Slf4j
public class Tut3Receiver {

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receive1(String in) {
        receive(in, 1);
    }

    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void receive2(String in) {
        receive(in, 2);
    }

    private void receive(String in, int receiver) {
        StopWatch watch = new StopWatch();
        watch.start();
        log.info("instance: '{}', [x] Received '{}'", receiver, in);
        try {
            doWork(in);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        watch.stop();
        log.info("instance: '{}', [x] Done in {}s", receiver, watch.getTotalTimeSeconds());
    }

    private void doWork(String in) throws InterruptedException {
        for (char ch : in.toCharArray()) {
            if (ch == '.') Thread.sleep(1000);
        }
    }
}
