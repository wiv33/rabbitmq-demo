package com.psawesome.rabbitmqdemo.tutorials.chap1;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * package: com.psawesome.rabbitmqdemo.tutorial
 * author: PS
 * DATE: 2020-01-21 화요일 00:36
 */
@Profile({"tut1", "hello-world"})
@Configuration
public class Tuto1Config {

    @Bean("tut1.hello")
    public Queue hello() {
        return new Queue("hello");
    }

    @Profile("receiver")
    @Bean("tut1.receiver")
    public Tuto1Receiver receiver() {
        return new Tuto1Receiver();
    }

    @Profile("sender")
    @Bean("tut1.sender")
    public Tuto1Sender sender() {
        return new Tuto1Sender();
    }
}
