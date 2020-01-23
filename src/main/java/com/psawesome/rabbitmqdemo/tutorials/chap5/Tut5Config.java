package com.psawesome.rabbitmqdemo.tutorials.chap5;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * package: com.psawesome.rabbitmqdemo.tutorials.chap5
 * author: PS
 * DATE: 2020-01-24 금요일 00:28
 */
@Profile({"tut5", "topics"})
@Configuration
public class Tut5Config {

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("tut5.topic");
    }


}
