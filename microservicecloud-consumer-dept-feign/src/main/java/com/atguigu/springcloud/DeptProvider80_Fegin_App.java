package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @program: miroservicecloudM
 * @description: 主启动类
 * @author: ZX
 * @create: 2021-06-28 11:04
 * @version: 1.0
 **/
@SpringBootApplication  //启动类注解
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.atguigu.springcloud"})
//@ComponentScan("com.atguigu.springcloud")
public class DeptProvider80_Fegin_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider80_Fegin_App.class,args);
    }
}

