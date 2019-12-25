package com.carychen.springboot_mybatis.demo.dao;

import com.carychen.springboot_mybatis.demo.entity.org_info;

import java.util.List;

public interface org_infoMapper {

    int saveOrgInfo(org_info record);

    org_info getOrgInfoById(Integer id);

    int upOrgInfo(org_info record);

    List<org_info> getOrgIngfoBySysid(int sys_id);

    List<org_info> getOrgInfoAll(int sys_id,String name,int p_id,int page,int limit);

    int getCountOrg(int sys_id,String name,int p_id);


}