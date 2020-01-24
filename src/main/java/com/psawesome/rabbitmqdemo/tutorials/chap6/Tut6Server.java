package com.psawesome.rabbitmqdemo.tutorials.chap6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * package: com.psawesome.rabbitmqdemo.tutorials.chap6
 * author: PS
 * DATE: 2020-01-24 금요일 23:51
 */
@Slf4j
public class Tut6Server {

    @RabbitListener(queues = "tut6.rpc.requests")
    public int fibonacci(int n) {
        log.info(" [x] Received request for {}", n);
        int fib = fib(n);
        log.info(" [.] Returned {}", fib);
        return fib;

    }

    private int fib(int n) {
        return n == 0 ? 0 : n == 1 ? 1 : (fib(n - 1) + fib(n - 2));
    }
}
