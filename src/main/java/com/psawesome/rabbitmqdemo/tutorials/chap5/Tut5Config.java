package com.psawesome.rabbitmqdemo.tutorials.chap5;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import reactor.core.publisher.Flux;

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

    @Profile("receiver")
    private static class ReceiverConfig {
        // receiver
        @Bean
        public Tut5Receiver receiver() {
            return new Tut5Receiver();
        }

        // start::org.springframework.amqp.core.Queue
        @Bean
        public Queue autoDeleteQueue1() {
            return new AnonymousQueue();
        }

        @Bean
        public Queue autoDeleteQueue2() {
            return new AnonymousQueue();
        }
        // end::org.springframework.amqp.core.Queue

        // start::org.springframework.amqp.core.Binding
        @Bean
        public Binding binding1a(TopicExchange topicExchange, Queue autoDeleteQueue1) {
            return BindingBuilder.bind(autoDeleteQueue1).to(topicExchange).with("*.orange.*");
        }

        @Bean
        public Binding binding1b(TopicExchange topicExchange, Queue autoDeleteQueue2) {
            return BindingBuilder.bind(autoDeleteQueue2).to(topicExchange).with("*.*.rabbit");
        }

        @Bean
        public Binding binding2b(TopicExchange topicExchange, Queue autoDeleteQueue2) {
            return BindingBuilder.bind(autoDeleteQueue2).to(topicExchange).with("lazy.#");
        }
        // end::org.springframework.amqp.core.Binding
    }

}
