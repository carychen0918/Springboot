package com.carychen.springboot_mybatis.demo.service;

import com.carychen.springboot_mybatis.demo.entity.floor_info;
import com.carychen.springboot_mybatis.demo.entity.user_info;

import java.util.List;

/**
 * Created by chentao
 * Date by 2019-12-11
 * 无敌太寂寞
 */
public interface FloorService {
    List<floor_info> getFloorAll(String name,int sex,int page,int limit);

    int getCount(String name,int sex);

    int saveFloor(floor_info floorInfo);

    int delFloor(int f_id);

    int upFloor(floor_info floorInfo);

    List<user_info> getUserlistBysysid();

    floor_info selFloorByName(String name);

    List<floor_info> getFloor();
}
