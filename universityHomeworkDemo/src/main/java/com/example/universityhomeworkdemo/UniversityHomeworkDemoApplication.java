package com.example.universityhomeworkdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UniversityHomeworkDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniversityHomeworkDemoApplication.class, args);
    }

}
