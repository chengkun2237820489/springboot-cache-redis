package com.chengkun.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chengkun.cloud.mapper")
public class SpringbootCacheRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCacheRedisApplication.class, args);
    }

}
