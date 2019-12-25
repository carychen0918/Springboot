package com.carychen.springboot_mybatis.demo.service;

import com.carychen.springboot_mybatis.demo.entity.user_info;

import java.util.List;

public interface user_service {

    int saveUser_info(user_info user);

    int UpUser_info(user_info user);

    int delUser_info(int user_id);

    user_info getUserInfoById(String user_long,String user_paw);

    List<user_info> getUserInfoAll(String name,int sys_id,int org_id,int page,int limit);

    int getUserCount(String name,int sys_id,int org_id);
}
