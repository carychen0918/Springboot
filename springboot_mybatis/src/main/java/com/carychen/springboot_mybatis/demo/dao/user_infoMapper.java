package com.carychen.springboot_mybatis.demo.dao;

import com.carychen.springboot_mybatis.demo.entity.user_info;

import java.util.List;

public interface user_infoMapper {
    int delUserInfo(Integer id);

    int saveUserInfo(user_info record);

    int upUserInfo(user_info record);

    List<user_info> getUserInfoAll(String name, int sys_id, int org_id,int page,int limit);

    int getUserCount(String name, int sys_id, int org_id);

    user_info login(String user_long, String user_paw);

    List<user_info> getUserListBySysid(int sys_id);
}