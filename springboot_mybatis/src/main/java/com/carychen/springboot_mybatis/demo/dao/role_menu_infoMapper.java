package com.carychen.springboot_mybatis.demo.dao;

import com.carychen.springboot_mybatis.demo.entity.role_info;
import com.carychen.springboot_mybatis.demo.entity.role_menu_info;

import java.util.List;

public interface role_menu_infoMapper {
    int delRoleMenuByid(Integer id);

    int saveRoleMenu(role_menu_info record);

    role_menu_info getRoleMenuByid(Integer id);

    int upRoleMenu(role_menu_info record);

    int delWarrant(int role_id);

    int warrant(List<role_menu_info> roleMenuInfo);

    List<role_menu_info> getRoleMenuByRoleid(int role_id);


}