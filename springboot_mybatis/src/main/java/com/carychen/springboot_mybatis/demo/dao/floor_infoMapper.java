package com.carychen.springboot_mybatis.demo.dao;

import com.carychen.springboot_mybatis.demo.entity.floor_info;

import java.util.List;

public interface floor_infoMapper {
    int delFloor(Integer f_id);

    int saveFloor(floor_info record);

    List<floor_info> getFloor();

    int upFloor(floor_info record);

    List<floor_info> getFloorAll(String name,int f_sex,int page,int limit);

    int getCount(String name,int f_sex);

    floor_info selFloorByName(String name);
}