package com.carychen.springboot_mybatis.demo.service;

import com.carychen.springboot_mybatis.demo.entity.system_info;

import java.util.List;

public interface system_service {

    int save_systemInfo(system_info system_info);

    List<system_info> getSystemAll(String Name,int page,int limit);

    int selectCount(String Name);


    int UpSystemInfo(system_info system_info);

    List<system_info> getSystemInfo();

    system_info getSystemByid(int sys_id);

}
