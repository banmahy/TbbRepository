package com.yehy.tbbserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yehy.tbbserver.mapper")
public class TbbServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TbbServerApplication.class, args);
    }

}
