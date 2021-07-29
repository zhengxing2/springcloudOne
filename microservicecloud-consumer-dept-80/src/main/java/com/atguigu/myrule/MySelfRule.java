package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: miroservicecloudM
 * @description: 自定义规则
 * @author: ZX
 * @create: 2021-06-30 15:38
 * @version: 1.0
 **/
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();   //默认是轮询，我自定义为随机
    }
}
