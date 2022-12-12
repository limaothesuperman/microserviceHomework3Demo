package com.example.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.common", "com.example.details"})
@EnableEurekaClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DetailsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DetailsApplication.class, args);
    }

}
