package com.carychen.springboot_mybatis.demo.serviceImp;

import com.carychen.springboot_mybatis.demo.dao.floor_infoMapper;
import com.carychen.springboot_mybatis.demo.dao.user_infoMapper;
import com.carychen.springboot_mybatis.demo.entity.floor_info;
import com.carychen.springboot_mybatis.demo.entity.user_info;
import com.carychen.springboot_mybatis.demo.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chentao
 * Date by 2019-12-11
 * 无敌太寂寞
 */
@Service
public class FloorServiceImp implements FloorService {

    @Autowired
    private floor_infoMapper floorInfoMapper;

    @Autowired
    private user_infoMapper userInfoMapper;

    @Override
    public List<floor_info> getFloorAll(String name, int sex, int page, int limit) {
        return floorInfoMapper.getFloorAll(name,sex,(page-1)*limit,limit);
    }

    @Override
    public int getCount(String name, int sex) {
        return floorInfoMapper.getCount( name, sex);
    }

    @Override
    public int saveFloor(floor_info floorInfo) {
        return floorInfoMapper.saveFloor(floorInfo);
    }

    @Override
    public int delFloor(int f_id) {
        return floorInfoMapper.delFloor(f_id);
    }

    @Override
    public int upFloor(floor_info floorInfo) {
        return floorInfoMapper.upFloor(floorInfo);
    }

    @Override
    public List<user_info> getUserlistBysysid() {
        return userInfoMapper.getUserListBySysid(1);
    }

    @Override
    public floor_info selFloorByName(String name) {
        return floorInfoMapper.selFloorByName(name);
    }

    @Override
    public List<floor_info> getFloor() {
        return floorInfoMapper.getFloor();
    }

}
