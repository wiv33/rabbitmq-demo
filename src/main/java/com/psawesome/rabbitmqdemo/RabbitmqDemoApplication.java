package com.psawesome.rabbitmqdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitmqDemoApplication {

    public static void main(String[] args) {

//        tut2
//        System.setProperty("spring.profiles.active", "tut2,work-queues,receiver,sender");

//        tut3
//        System.setProperty("spring.profiles.active", "tut3,pub-sub,publish-subscribe,receiver,sender");

//        tut4
        System.setProperty("spring.profiles.active", "tut4,sender,receiver,routing");
        SpringApplication.run(RabbitmqDemoApplication.class, args);

    }

    @Bean
    CommandLineRunner rabbitRunner() {
        return new RabbitAmqpRunner();
    }

}
