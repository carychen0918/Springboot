package com.carychen.springboot_mybatis.demo.service;

import com.carychen.springboot_mybatis.demo.entity.org_info;

import java.util.List;

/**
 * Created by chentao
 * Date by 2019-11-20
 * 无敌太寂寞
 */
public interface orgService {
    List<org_info> getOrgIngfoBySysid(int sys_id);

    List<org_info> getOrgInfoAll(int sys_id,String name,int p_id,int page,int limit);

    int getCountOrg(int sys_id,String name,int p_id);

    int saveOrgInfo(org_info orgInfo);

    int upOrgInfo(org_info orgInfo);

    org_info getOrgInfoByid(int id);

}
