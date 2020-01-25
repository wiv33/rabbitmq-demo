package com.psawesome.rabbitmqdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitmqDemoApplication {

    public static void main(String[] args) {
//        tut1
//        System.setProperty("spring.profiles.active", "tut1,hello-world,receiver");
//        System.setProperty("spring.profiles.active", "tut1,hello-world,sender");

//        tut2
//        System.setProperty("spring.profiles.active", "tut2,work-queues,sender");
//        System.setProperty("spring.profiles.active", "tut2,work-queues,receiver");

//        tut3
//        System.setProperty("spring.profiles.active", "tut3,pub-sub,publish-subscribe,sender");
//        System.setProperty("spring.profiles.active", "tut3,pub-sub,publish-subscribe,receiver");

//        tut4
//        System.setProperty("spring.profiles.active", "tut4,routing,receiver");
//        System.setProperty("spring.profiles.active", "tut4,routing,sender");

//        tut5
//        System.setProperty("spring.profiles.active", "tut5,sender,topics");
//        System.setProperty("spring.profiles.active", "tut5,receiver,topics");

//        tut6
//        System.setProperty("spring.profiles.active", "tut6,server,rpc");
//        System.setProperty("spring.profiles.active", "tut6,client,rpc");

        SpringApplication.run(RabbitmqDemoApplication.class, args);

    }

//    @Profile({"sender", "client"})
    @Bean
    CommandLineRunner rabbitRunner() {
        return new RabbitAmqpRunner();
    }

}
