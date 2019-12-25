package com.carychen.springboot_mybatis.demo.service;

import com.carychen.springboot_mybatis.demo.entity.dormitory_info;

import java.util.List;

/**
 * Created by chentao
 * Date by 2019-12-17
 * 无敌太寂寞
 */
public interface DormitoryService {
    List<dormitory_info> getDormitoyAll(String name,int f_sex,int page, int limit);

    int countDormitoy(String name,int f_sex);

    int saveDormitoy(dormitory_info dormitoryInfo);

    int upDormitoy(dormitory_info dormitoryInfo);

    int del_Dormitoy(int d_id);

    List<dormitory_info> getDormitoryByFid(int f_id);
}
