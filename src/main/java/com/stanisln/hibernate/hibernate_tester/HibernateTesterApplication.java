package com.stanisln.hibernate.hibernate_tester;

import com.stanisln.hibernate.hibernate_tester.service.InitService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HibernateTesterApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HibernateTesterApplication.class, args);
        context.getBean(InitService.class).init();

    }

}
