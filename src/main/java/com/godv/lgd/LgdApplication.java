package com.godv.lgd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class LgdApplication {

    public static void main(String[] args) {
        SpringApplication.run(LgdApplication.class, args);
    }

}
