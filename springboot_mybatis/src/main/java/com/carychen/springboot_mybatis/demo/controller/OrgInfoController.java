package com.carychen.springboot_mybatis.demo.controller;


import com.carychen.springboot_mybatis.demo.entity.org_info;
import com.carychen.springboot_mybatis.demo.entity.retMap;
import com.carychen.springboot_mybatis.demo.entity.terr_info;
import com.carychen.springboot_mybatis.demo.service.orgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chentao
 * Date by 2019-11-20
 * 无敌太寂寞
 */
@RequestMapping("/org")
@Controller
public class OrgInfoController {

    @Autowired
    private orgService orgService;

    @RequestMapping(value = "/getOrgTerr",method = RequestMethod.GET)
    public @ResponseBody Object getOrgTerr(int sys_id){
        List<org_info> terr =orgService.getOrgIngfoBySysid(sys_id);
        List<terr_info> list = setChild(0,terr);
        retMap map = new retMap("组织机构加载成功", 0,list,0,true);
        return map.getMap();
    }

    @RequestMapping(value = "/getOrgInfoAll",method = RequestMethod.GET)
    public @ResponseBody Object getOrgInfoAll(String name,int page,int limit,int p_id,int sys_id){
        String msg ="查询成功";
        Boolean success = true;
        retMap map = new retMap(msg, 0,null,0,success);
        try {
            List<org_info> org_list = orgService.getOrgInfoAll(sys_id,name,p_id,(page-1)*limit,limit);
            int count = orgService.getCountOrg(sys_id,name,p_id);
            map.setCount(count);
            map.setData(org_list);
            return map.getMap();
        }catch (Exception e){
            System.err.println(e.toString());
            map.setMsg("查询失败"+e.toString());
            map.setSuccess(false);
            map.setCode(2000);
            return map.getMap();
        }
    }

    @RequestMapping(value = "/saveOrgInfo",method = RequestMethod.POST)
    public @ResponseBody Object saveOrgInfo(HttpServletRequest res){
        String msg = "新增成功";
        Boolean success = true;
        retMap map = new retMap();
        try{
            String code_name = res.getParameter("org_name");
            int p_id = Integer.parseInt(res.getParameter("p_id"));
            int sys_id = Integer.parseInt(res.getParameter("sel_sys"));
            String org_full_name = res.getParameter("org_full_name");
            String org_remark = res.getParameter("org_remark");
            org_info saveOrg = new org_info(code_name,p_id,sys_id,org_full_name,org_remark);
            orgService.saveOrgInfo(saveOrg);
            map.setMsg(msg);
            map.setSuccess(success);
            return map.getMap();
        }catch (Exception e){
            System.err.println("新增组织机构错误："+e.toString());
            map.setMsg("新增组织机构错误："+e.toString());
            map.setSuccess(false);
            return map.getMap();
        }
    }

    @RequestMapping(value = "/upOrgInfo",method = RequestMethod.POST)
    public @ResponseBody Object upOrgInfo(HttpServletRequest res){
        String msg = "修改成功";
        Boolean success = true;
        retMap map = new retMap();
        try{
            int id = Integer.parseInt(res.getParameter("id"));
            String code_name = res.getParameter("org_name");
            int p_id = Integer.parseInt(res.getParameter("p_id"));
            int sys_id = Integer.parseInt(res.getParameter("sel_sys"));
            String org_full_name = res.getParameter("org_full_name");
            String org_remark = res.getParameter("org_remark");
            org_info saveOrg = new org_info(id,code_name,p_id,sys_id,org_full_name,org_remark);
            int i = orgService.upOrgInfo(saveOrg);
            map.setMsg(msg);
            map.setSuccess(success);
            return map.getMap();
        }catch (Exception e){
            System.err.println("修改组织机构错误："+e.toString());
            map.setMsg("修改组织机构错误："+e.toString());
            map.setSuccess(false);
            return map.getMap();
        }
    }

    @RequestMapping(value = "/getOrgByid",method = RequestMethod.GET)
    public @ResponseBody Object getOrgByid(int id){
        String msg = "修改成功";
        Boolean success = true;
        retMap map = new retMap(msg, 0,null,0,success);
        List<org_info> orgInfo = new ArrayList<>();
        orgInfo.add(orgService.getOrgInfoByid(id));
        map.setData(orgInfo);
        return map.getMap();
    }

    /**
     *
     * @param menu_id 父节点id
     * @param org 组织机构
     * @return
     */
    public List<terr_info> setChild(int menu_id, List<org_info> org){
        List<terr_info> terr_info_list  = new ArrayList<>();
        for(int i = 0; i< org.size(); i++){//封装父节点
            if(menu_id==org.get(i).getpId()){
                terr_info terrInfo = new terr_info(org.get(i).getCodeName(),org.get(i).getId(), ""+org.get(i).getpId());
                terrInfo.setChildren(setChild(org.get(i).getId(),org));
                terr_info_list.add(terrInfo);
            }
        }
        if(terr_info_list.size()==0)return null;
        return terr_info_list;
    }
}
