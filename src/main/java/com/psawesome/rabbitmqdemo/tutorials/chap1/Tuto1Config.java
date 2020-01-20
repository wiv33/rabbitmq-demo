package com.psawesome.rabbitmqdemo.tutorials.chap1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;

/**
 * package: com.psawesome.rabbitmqdemo.tutorial
 * author: PS
 * DATE: 2020-01-21 화요일 00:36
 */
@Configuration
public class Tuto1Config {

    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    @Bean
    public Tuto1Receiver receiver() {
        return new Tuto1Receiver();
    }

    @Bean
    public Tuto1Sender sender() {
        return new Tuto1Sender();
    }
}
