package com.carychen.springboot_mybatis.demo.dao;

import com.carychen.springboot_mybatis.demo.entity.role_info;

import java.util.List;

public interface role_infoMapper {
    int delRoleInfoByid(Integer id);

    int saveRoleInfo(role_info record);

    role_info getRoleInfoByid(Integer id);

    int upRoleInfo(role_info record);

    int getCountRole(int sys_id,String name);

    List<role_info> getRoleAll(int sys_id,String name,int page,int limit);

    List<role_info> getRoleBySysid(int sys_id);
}