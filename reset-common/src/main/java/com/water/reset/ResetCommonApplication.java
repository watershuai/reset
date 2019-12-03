package com.water.reset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ResetCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResetCommonApplication.class, args);
    }

}
