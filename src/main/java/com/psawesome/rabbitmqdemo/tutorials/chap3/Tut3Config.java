package com.psawesome.rabbitmqdemo.tutorials.chap3;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * package: com.psawesome.rabbitmqdemo.tutorials.chap3
 * author: PS
 * DATE: 2020-01-21 화요일 22:50
 */
@Profile({"tut3", "pub-sub", "publish-subscribe"})
@Configuration
public class Tut3Config {

    @Bean("tut3.fanout")
    public FanoutExchange fanout() {
        return new FanoutExchange("tut3.fanout");
    }

    @Profile("receiver")
    private static class ReceiverConfig {

        @Bean("tut3.autoDeleteQueue1")
        public Queue autoDeleteQueue1() {
            return new AnonymousQueue();
        }

        @Bean("tut3.autoDeleteQueue2")
        public Queue autoDeleteQueue2() {
            return new AnonymousQueue();
        }

        @Bean("tut3.binding1")
        public Binding binding1(FanoutExchange fanout, Queue autoDeleteQueue1) {
            // (Queue) fanout -> (Exchange) autoDeleteQueue1
            return BindingBuilder.bind(autoDeleteQueue1).to(fanout);
        }

        @Bean("tut3.binding2")
        public Binding binding2(FanoutExchange fanout, Queue autoDeleteQueue2) {
            // (Queue) fanout -> (Exchange) autoDeleteQueue2
            return BindingBuilder.bind(autoDeleteQueue2).to(fanout);
        }

        @Bean
        public Tut3Receiver receiver() {
            return new Tut3Receiver();
        }
    }

    @Profile("sender")
    @Bean("tut3.sender")
    public Tut3Sender sender() {
        return new Tut3Sender();
    }
}
