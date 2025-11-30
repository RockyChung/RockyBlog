package com.rocky.blogapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.rocky.blogapi.util.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@MapperScan("com.rocky.blogapi.mapper") // <--- 加入這一行，指向你的 mapper 包
@SpringBootApplication
@EnableConfigurationProperties({JwtUtils.class}) // <--- 加入這一行！
public class BlogApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApiApplication.class, args);
    }

}
