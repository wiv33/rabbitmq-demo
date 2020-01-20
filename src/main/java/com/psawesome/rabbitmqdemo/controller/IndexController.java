package com.psawesome.rabbitmqdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

/**
 * package: com.psawesome.rabbitmqdemo.controller
 * author: PS
 * DATE: 2020-01-20 월요일 23:49
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String indexPage() {
        return "index";
    }
}
