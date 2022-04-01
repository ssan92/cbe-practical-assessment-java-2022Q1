package com.miguelmejia.q12022;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Q12022Application {

    public static void main(String[] args) {
        SpringApplication.run(Q12022Application.class, args);
    }

}
