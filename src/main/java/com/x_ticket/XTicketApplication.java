package com.x_ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class XTicketApplication {
    public static void main(String[] args) {
        SpringApplication.run(XTicketApplication.class, args);
    }
}
