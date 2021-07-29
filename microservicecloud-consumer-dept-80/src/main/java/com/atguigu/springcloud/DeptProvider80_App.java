package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @program: miroservicecloudM
 * @description: 主启动类
 * @author: ZX
 * @create: 2021-06-28 11:04
 * @version: 1.0
 **/
@SpringBootApplication  //启动类注解
@EnableEurekaClient
//自定义配置规则
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)
public class DeptProvider80_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider80_App.class,args);
    }
}

