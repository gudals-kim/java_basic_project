package com.example.myservlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 서블릿 자동등록
@SpringBootApplication
public class MyservletApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyservletApplication.class, args);
    }

}
