package com.springboot.keyan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.springboot.keyan.mapper")
public class KeyanApplication {

    /**
     * 系统入口
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(KeyanApplication.class, args);
        System.out.println("系统启动成功");
    }

}
