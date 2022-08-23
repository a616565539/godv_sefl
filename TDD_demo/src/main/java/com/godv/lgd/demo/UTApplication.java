package com.godv.lgd.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class UTApplication {

    public static void main(String[] args) {
        SpringApplication.run(UTApplication.class, args);
    }

}
