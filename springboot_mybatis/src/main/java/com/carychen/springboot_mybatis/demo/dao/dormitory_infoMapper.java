package com.carychen.springboot_mybatis.demo.dao;

import com.carychen.springboot_mybatis.demo.entity.dormitory_info;

import java.util.List;

public interface dormitory_infoMapper {
    int delDormitory(Integer d_id);

    int saveDormitory(dormitory_info record);

    List<dormitory_info> getDormitoryByFid(Integer f_id);

    int upDormitory(dormitory_info record);

    List<dormitory_info> getDormitoryAll(String name,int f_sex,int page,int limit);

    int countDormitor(String name,int f_sex);
}