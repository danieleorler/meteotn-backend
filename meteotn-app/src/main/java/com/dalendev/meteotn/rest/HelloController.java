package com.dalendev.meteotn.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value(value = "${meteotrentino.base_url}")
    private String url;

    @RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot! " + url;
    }
}
