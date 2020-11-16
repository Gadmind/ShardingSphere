package com.daop.shardingsphere;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.daop.shardingsphere.mapper")
public class ShardingsphereApplication {
// 类别
    public static void main(String[] args) {
        SpringApplication.run(ShardingsphereApplication.class, args);
    }

}
