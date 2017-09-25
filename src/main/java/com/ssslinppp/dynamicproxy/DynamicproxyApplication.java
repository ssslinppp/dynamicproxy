package com.ssslinppp.dynamicproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan("com.ssslinppp")
@SpringBootApplication
public class DynamicproxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicproxyApplication.class, args);
    }
}
