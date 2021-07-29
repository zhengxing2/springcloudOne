package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;

import java.util.List;

/**
 * @program: miroservicecloudM
 * @description: DeptService
 * @author: ZX
 * @create: 2021-06-28 10:46
 * @version: 1.0
 **/
public interface DeptService {
    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();
}
