package com.edumind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EduMindApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduMindApplication.class, args);
        System.out.println("Congrats😄! EduMind 后端系统启动成功！");
    }
}
