package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @program: miroservicecloudM
 * @description: zuul主启动类
 * @author: ZX
 * @create: 2021-07-02 14:38
 * @version: 1.0
 **/
@SpringBootApplication
@EnableZuulProxy   //开启zuul支持
public class Zuul_9527_StartSpringCloudApp {
    public static void main(String[] args) {
        SpringApplication.run(Zuul_9527_StartSpringCloudApp.class, args);
    }
}
