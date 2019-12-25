package com.carychen.springboot_mybatis.demo.serviceImp;

import com.carychen.springboot_mybatis.demo.dao.role_infoMapper;
import com.carychen.springboot_mybatis.demo.dao.role_menu_infoMapper;
import com.carychen.springboot_mybatis.demo.entity.role_info;
import com.carychen.springboot_mybatis.demo.entity.role_menu_info;
import com.carychen.springboot_mybatis.demo.service.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chentao
 * Date by 2019-11-19
 * 无敌太寂寞
 */
@Service
public class RoleServiceImp implements roleService {

    @Autowired
    private role_infoMapper roleInfoMapper;

    @Autowired
    private role_menu_infoMapper roleMenuInfoMapper;

    @Override
    public int getCountRole(int sys_id, String name_code) {
        return roleInfoMapper.getCountRole(sys_id,name_code);
    }

    @Override
    public List<role_info> getRoleAll(int sys_id, String name_code, int page, int limit) {
        return roleInfoMapper.getRoleAll(sys_id,name_code,page,limit);
    }

    @Override
    public int saveRole(role_info roleInfo) {
        return roleInfoMapper.saveRoleInfo(roleInfo);
    }

    @Override
    public int upRole(role_info roleInfo) {
        return roleInfoMapper.upRoleInfo(roleInfo);
    }

    @Override
    @Transactional
    public int warrant(List<role_menu_info> roleMenuInfos) {
        return roleMenuInfoMapper.warrant(roleMenuInfos);
    }

    @Override
    @Transactional
    public int del_warrant(int role_id) {
        return roleMenuInfoMapper.delWarrant(role_id);
    }

    @Override
    public List<role_menu_info> getRoleMenuByRoleid(int role_id) {
        return roleMenuInfoMapper.getRoleMenuByRoleid(role_id);
    }

    @Override
    public List<role_info> getRoleBySysid(int sys_id) {
        return roleInfoMapper.getRoleBySysid(sys_id);
    }
}
