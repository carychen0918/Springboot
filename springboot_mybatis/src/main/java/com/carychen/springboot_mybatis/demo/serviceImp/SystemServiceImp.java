package com.carychen.springboot_mybatis.demo.serviceImp;

import com.carychen.springboot_mybatis.demo.dao.system_infoMapper;
import com.carychen.springboot_mybatis.demo.entity.system_info;
import com.carychen.springboot_mybatis.demo.service.system_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemServiceImp implements system_service {

    @Autowired
    private system_infoMapper system_infoDao;

    @Override
    public int save_systemInfo(system_info system_info) {
        int insertIndex = system_infoDao.saveSystem(system_info);
        return insertIndex;
    }

    @Override
    public List<system_info> getSystemAll(String Name, int page, int limit) {
        return system_infoDao.getSystemAll(page,limit,Name);
    }

    @Override
    public int selectCount(String Name) {
        return system_infoDao.selectCount(Name);
    }


    @Override
    public int UpSystemInfo(system_info system_info) {
        return system_infoDao.upSystem(system_info);
    }

    @Override
    public List<system_info> getSystemInfo() {
        return system_infoDao.getSystemInfo();
    }

    @Override
    public system_info getSystemByid(int sys_id) {
        return system_infoDao.getSystmByid(sys_id);
    }

}
