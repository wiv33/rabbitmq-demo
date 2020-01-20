package com.psawesome.rabbitmqdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * package: com.psawesome.rabbitmqdemo
 * author: PS
 * DATE: 2020-01-21 화요일 00:56
 */
@Slf4j
public class RabbitAmqpRunner implements CommandLineRunner {

    @Value("${tutorial.client.duration:0}")
    private int duration;

    @Autowired
    private ConfigurableApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
        log.info("Ready .... running for {} ms", duration);
        Thread.sleep(duration);
        ctx.close();
    }
}
