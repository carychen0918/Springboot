package com.carychen.springboot_mybatis.demo.serviceImp;

import com.carychen.springboot_mybatis.demo.dao.org_infoMapper;
import com.carychen.springboot_mybatis.demo.entity.org_info;
import com.carychen.springboot_mybatis.demo.service.orgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chentao
 * Date by 2019-11-20
 * 无敌太寂寞
 */
@Service
public class OrgSerivceImp implements orgService{

    @Autowired
    private org_infoMapper orgInfoMapper;

    @Override
    public List<org_info> getOrgIngfoBySysid(int sys_id) {
        return orgInfoMapper.getOrgIngfoBySysid(sys_id);
    }

    @Override
    public List<org_info> getOrgInfoAll(int sys_id, String name,int p_id, int page, int limit) {
        return orgInfoMapper.getOrgInfoAll(sys_id,name,p_id,page,limit);
    }

    @Override
    public int getCountOrg(int sys_id, String name,int p_id) {
        return orgInfoMapper.getCountOrg(sys_id,name,p_id);
    }

    @Override
    public int saveOrgInfo(org_info orgInfo) {
        return orgInfoMapper.saveOrgInfo(orgInfo);
    }

    @Override
    public int upOrgInfo(org_info orgInfo) {
        return orgInfoMapper.upOrgInfo(orgInfo);
    }

    @Override
    public org_info getOrgInfoByid(int id) {
        return orgInfoMapper.getOrgInfoById(id);
    }
}
