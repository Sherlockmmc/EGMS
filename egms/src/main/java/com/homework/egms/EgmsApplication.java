package com.homework.egms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.homework.egms.mapper")
@SpringBootApplication
public class EgmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EgmsApplication.class, args);
    }

}
