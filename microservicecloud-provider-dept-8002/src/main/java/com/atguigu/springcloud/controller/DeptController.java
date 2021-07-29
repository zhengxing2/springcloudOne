package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: miroservicecloudM
 * @description: DeptController
 * @author: ZX
 * @create: 2021-06-28 10:52
 * @version: 1.0
 **/
@RestController
//@RestController注解相当于@ResponseBody ＋ @Controller
//使用@RestController这个注解，就不能返回jsp,html页面
public class DeptController {

    @Autowired //可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
    private DeptService service;
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public Boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }//通过 @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return service.list();
    }

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println(list);
        List<ServiceInstance> srvlist = client.getInstances("microservicecloud-dept");
        for (ServiceInstance serviceInstance : srvlist){
            System.out.println(serviceInstance.getServiceId() + "/t" + serviceInstance.getHost() +
                    "/t" + serviceInstance.getUri());
        }
        return this.client;
    }
}
