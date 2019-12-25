package com.carychen.springboot_mybatis.demo.dao;

import com.carychen.springboot_mybatis.demo.entity.system_info;

import java.util.List;

public interface system_infoMapper {
    int deSystemByid(Integer id);

    int saveSystem(system_info record);

    system_info getSystmByid(Integer id);

    int upSystem(system_info record);

    List<system_info> getSystemAll(Integer page,Integer limit,String Name);

    int selectCount(String Name);

    List<system_info> getSystemInfo();

}