package com.carychen.springboot_mybatis.demo.service;

import com.carychen.springboot_mybatis.demo.entity.menu_info;

import java.util.List;

public interface menuService {

    List<menu_info> getMenuInfoAll(String name, int page, int limit, int sys_id);

    int countMenu(String name,int sys_id);

    int saveMenu(menu_info menuInfo);

    int upMenu(menu_info menuInfo);

    int delMenu(int menu_id);

    List<menu_info> getTerr(int sys_id);

    menu_info getPmenu(int menu_id);

    List<menu_info> getTerrByUserSysId(int user_sys_id);

    menu_info getSupMenuByPid(int p_id);
}
