package com.zhang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhang.mapper")
public class SpringbootVuePermissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootVuePermissionApplication.class, args);
    }

}
