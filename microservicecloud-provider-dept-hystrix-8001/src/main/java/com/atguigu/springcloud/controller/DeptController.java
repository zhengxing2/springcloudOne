package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    public Dept get(@PathVariable("id") Long id) {
        Dept dept =  this.service.get(id);
        if(null == dept)
        {
            throw new RuntimeException("该ID："+id+"没有没有对应的信息");
        }
        return dept;
    }//通过 @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中

    public Dept processHystrix_Get(@PathVariable("id") Long id){
        return new Dept().setDeptno(id)
                .setDname("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return service.list();
    }

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println(list);
        List<ServiceInstance> srvlist = client.getInstances("microservicecloud-dept");
        for (ServiceInstance serviceInstance : srvlist) {
            System.out.println(serviceInstance.getServiceId() + "/t" + serviceInstance.getHost() +
                    "/t" + serviceInstance.getUri());
        }
        return this.client;
    }
}
