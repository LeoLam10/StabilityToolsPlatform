package com.pupu.stability;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pupu.stability.dao")
public class PuPuStabilityToolsPlatform {

    public static void main(String[] args) {
        SpringApplication.run(PuPuStabilityToolsPlatform.class, args);
    }

}
