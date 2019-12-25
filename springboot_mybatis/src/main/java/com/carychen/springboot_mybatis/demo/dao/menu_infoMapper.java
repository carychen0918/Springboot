package com.carychen.springboot_mybatis.demo.dao;

import com.carychen.springboot_mybatis.demo.entity.menu_info;

import java.util.List;

public interface menu_infoMapper {
    int delMenuByid(Integer menuId);

    int saveMenu(menu_info record);

    menu_info getMenuByid(Integer menuId);

    int upMenuByid(menu_info record);

    List<menu_info> getMenuInfoAll(String name,int page,int limit,int sys_id);

    int countMent(String name,int sys_id);

    List<menu_info> getTerr(int sys_id);

    List<menu_info> getTerrByUserSysId(int user_role_id);

    menu_info getSupMenuByPid(int p_id);
}