package com.carychen.springboot_mybatis.demo.serviceImp;

import com.carychen.springboot_mybatis.demo.dao.dormitory_infoMapper;
import com.carychen.springboot_mybatis.demo.entity.dormitory_info;
import com.carychen.springboot_mybatis.demo.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chentao
 * Date by 2019-12-17
 * 无敌太寂寞
 */
@Service
public class DormitoyServiceImp implements DormitoryService {

    @Autowired
    private dormitory_infoMapper dormitoryInfoMapper;

    @Override
    public List<dormitory_info> getDormitoyAll(String name, int f_sex, int page, int limit) {
        return dormitoryInfoMapper.getDormitoryAll(name,f_sex,(page-1)*limit,limit);
    }

    @Override
    public int countDormitoy(String name, int f_sex) {
        return dormitoryInfoMapper.countDormitor(name,f_sex);
    }

    @Override
    public int saveDormitoy(dormitory_info dormitoryInfo) {
        return dormitoryInfoMapper.saveDormitory(dormitoryInfo);
    }

    @Override
    public int upDormitoy(dormitory_info dormitoryInfo) {
        return dormitoryInfoMapper.upDormitory(dormitoryInfo);
    }

    @Override
    public int del_Dormitoy(int d_id) {
        return dormitoryInfoMapper.delDormitory(d_id);
    }

    @Override
    public List<dormitory_info> getDormitoryByFid(int f_id) {
        return dormitoryInfoMapper.getDormitoryByFid(f_id);
    }
}
