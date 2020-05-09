package com.springtransactions.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class TestingTransactionsApplication {

    public static void main(String[] args) {

        ApplicationContext ac=SpringApplication.run(TestingTransactionsApplication.class, args);
    }

}
