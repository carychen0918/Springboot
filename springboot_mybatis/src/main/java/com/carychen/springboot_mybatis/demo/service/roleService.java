package com.carychen.springboot_mybatis.demo.service;

import com.carychen.springboot_mybatis.demo.entity.role_info;
import com.carychen.springboot_mybatis.demo.entity.role_menu_info;

import java.util.List;

/**
 * Created by chentao
 * Date by 2019-11-19
 * 无敌太寂寞
 */
public interface roleService {
    int getCountRole(int sys_id,String name_code);

    List<role_info> getRoleAll(int sys_id,String name_code,int page,int limit);

    int saveRole(role_info roleInfo);

    int upRole(role_info roleInfo);

    int warrant(List<role_menu_info> roleMenuInfos);

    int del_warrant(int role_id);

    List<role_menu_info> getRoleMenuByRoleid(int role_id);

    List<role_info> getRoleBySysid(int sys_id);

}
