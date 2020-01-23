package com.psawesome.rabbitmqdemo.tutorials.chap5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

/**
 * package: com.psawesome.rabbitmqdemo.tutorials.chap5
 * author: PS
 * DATE: 2020-01-24 금요일 00:42
 */
@Slf4j
public class Tut5Receiver {

    // start::RabbitListener
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
        log.info("instance '{}' [x] Received '{}'", receiver, in);
        try {
            doWork(in);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        watch.stop();
        log.info("instance '{}' [x] Done in {}s", receiver, watch.getTotalTimeSeconds());
    }

    // end::RabbitListener

    private void doWork(String in) throws InterruptedException {
        for (char c : in.toCharArray()) if (c == '.') Thread.sleep(1000);
    }

}
