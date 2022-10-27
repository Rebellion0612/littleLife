package com.phoenix.littlelife;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.phoenix.littlelife.repository.mapper")
@SpringBootApplication
public class LittleLifeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LittleLifeApplication.class, args);
    }

}
