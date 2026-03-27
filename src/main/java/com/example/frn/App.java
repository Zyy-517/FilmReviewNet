package com.example.frn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.frn.dao")
public class App {
    public static void main(String[] args) {
        //运行spring应用程序
        SpringApplication.run(App.class,args);
    }
}
