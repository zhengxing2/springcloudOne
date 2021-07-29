package com.atguigu.springcloud.cfgbeans;

import com.atguigu.myrule.RandomRule_ZX;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: miroservicecloudM
 * @description: ConfigBean
 * @author: ZX
 * @create: 2021-06-28 14:12
 * @version: 1.0
 **/

//RestTemplate提供了多种便捷访问远程Http服务的方法，
//是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集
@Configuration
public class ConfigBean
//boot优化spring中的applicationContext.xml文件，使用@Configuration注解
//ConfigBean == applicationContext.xml
{
    @Bean
    @LoadBalanced  //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端       负载均衡的工具。
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        //return new RoundRobinRule();  //轮询算法
        //return new RandomRule();   //用重新选择的随机算法代替默认的轮询算法，查找服务
        return new RandomRule_ZX();  //我自定义为每台机器5次
    }
}

//@Bean
//public UserService getUserService(){
//    return new UserServiceImpl();
//}
//applicationContext.xml == ConfigBean(@Configuration)
//<bean id = "userService" class="com.atguigu.service.UserServiceImpl">
