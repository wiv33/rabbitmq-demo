package com.psawesome.rabbitmqdemo.tutorials.chap6;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * package: com.psawesome.rabbitmqdemo.tutorials.chap6
 * author: PS
 * DATE: 2020-01-24 금요일 23:43
 */

@Profile({"tut6", "rpc"})
@Configuration
public class Tut6Config {

    @Profile("client")
    private class ClientConfig {
        @Bean
        public DirectExchange exchange() {
            return new DirectExchange("tut6.rpc");
        }

        @Bean
        public Tut6Client client() {
            return new Tut6Client();
        }
    }

    @Profile("server")
    private class ServerConfig {
        @Bean
        public Queue queue() {
            return new Queue("tut6.rpc.requests");
        }

        @Bean
        public DirectExchange exchange () {
            return new DirectExchange("tut6.rpc");
        }

        @Bean
        public Binding binding(DirectExchange exchange, Queue queue) {
            return BindingBuilder.bind(queue).to(exchange).with("rpc");
        }

        @Bean
        public Tut6Server server() {
            return new Tut6Server();
        }
    }
}
