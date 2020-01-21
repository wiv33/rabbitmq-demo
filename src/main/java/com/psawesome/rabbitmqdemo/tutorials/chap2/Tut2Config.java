package com.psawesome.rabbitmqdemo.tutorials.chap2;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * package: com.psawesome.rabbitmqdemo.tutorials.chap2
 * author: PS
 * DATE: 2020-01-21 화요일 21:25
 */
@Profile({"tut2", "work-queues"})
@Configuration
public class Tut2Config {

    @Bean("tut2.hello")
    public Queue hello() {
        return new Queue("tut2.hello");
    }

    @Profile("receiver")
    private static class ReceiverConfig {

        @Bean
        public Tut2Receiver receiver1() {
            return new Tut2Receiver(1);
        }

        @Bean
        public Tut2Receiver receiver2() {
            return new Tut2Receiver(2);
        }
    }

    @Profile("sender")
    @Bean("tut2.sender")
    public Tut2Sender sender() {
        return new Tut2Sender();
    }
}
