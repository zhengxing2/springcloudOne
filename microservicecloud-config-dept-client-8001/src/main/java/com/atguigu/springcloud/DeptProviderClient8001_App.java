package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: miroservicecloudM
 * @description: 主启动类
 * @author: ZX
 * @create: 2021-06-28 11:04
 * @version: 1.0
 **/
@SpringBootApplication  //启动类注解
@EnableEurekaClient  //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient  //服务发现
public class DeptProviderClient8001_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderClient8001_App.class,args);
    }
}
