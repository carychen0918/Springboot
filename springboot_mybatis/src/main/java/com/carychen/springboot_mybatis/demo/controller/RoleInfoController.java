package com.carychen.springboot_mybatis.demo.controller;

import com.carychen.springboot_mybatis.demo.entity.retMap;
import com.carychen.springboot_mybatis.demo.entity.role_info;
import com.carychen.springboot_mybatis.demo.entity.role_menu_info;
import com.carychen.springboot_mybatis.demo.service.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chentao
 * Date by 2019-11-19
 * 无敌太寂寞
 */
@Controller
@RequestMapping("/role")
public class RoleInfoController {

    @Autowired
    private roleService roleservice;

    @RequestMapping(value = "/getRoleInfoAll",method = RequestMethod.GET)
    public @ResponseBody Object getRoleInfoAll(int sys_id,String name,int page,int limit){
        String msg = "查询成功";
        int code = 0;
        Boolean success = true;
         List<role_info> roleInfoList = roleservice.getRoleAll(sys_id,name,(page-1)*limit,limit);
        int count = roleservice.getCountRole(sys_id,name);
        retMap map = new retMap(msg,code,roleInfoList,count,success);
        return map.getMap();
    }

    @RequestMapping(value = "/saveRole",method = RequestMethod.POST)
    public @ResponseBody Object saveRole(HttpServletRequest res){
        String msg = "查询成功";
        Boolean success = true;
        String role_code= res.getParameter("role_code");
        String role_name = res.getParameter("role_name");
        int role_state = Integer.parseInt(res.getParameter("role_status"));
        int sys_id = Integer.parseInt(res.getParameter("sys_id"));
        int role_order = Integer.parseInt(res.getParameter("role_order"));
        String role_remark = res.getParameter("role_remark");
        role_info saveRole = new role_info(role_code,role_name,role_state,sys_id,role_order,role_remark);
        int i = roleservice.saveRole(saveRole);
        if(i<=0){
            msg = "新增失败，首先应行数为0";
            success = false;
        }
        retMap map = new retMap(msg,0,null,0,success);
        return map.getMap();
    }

    @RequestMapping(value = "/getRoleMenuByRoleid",method = RequestMethod.GET)
    public @ResponseBody Object getRoleMenuByRoleid(int role_id){
        String msg = "查询成功";
        Boolean success = true;
        List<role_menu_info> roleMenuInfos = roleservice.getRoleMenuByRoleid(role_id);
        retMap map = new retMap(msg,0,roleMenuInfos,0,success);
        return map.getMap();
    }

    @RequestMapping(value = "/setWarranty",method = RequestMethod.POST)
    public @ResponseBody Object setWarranty(int role_id, @RequestParam(required = false,value ="menu_id[]") List<Integer> menu_id){
        String msg = "授权成功";
        Boolean success = true;
        try {
            roleservice.del_warrant(role_id);
            List<role_menu_info> roleMenuInfoList = new ArrayList<>();
            for(int i=0;i< menu_id.size();i++){
                role_menu_info roleMenuInfo = new role_menu_info(role_id,menu_id.get(i));
                roleMenuInfoList.add(roleMenuInfo);
            }
            int i = roleservice.warrant(roleMenuInfoList);
        }catch (Exception e){
            msg = "授权失败"+e;
            success = false;
            System.err.println(e.toString());
        }
        retMap map = new retMap(msg,0,null,0,success);
        return map.getMap();

    }

    @RequestMapping(value = "/upRole",method = RequestMethod.POST)
    public @ResponseBody Object upRole(HttpServletRequest res){
        String msg = "查询成功";
        Boolean success = true;
        int id =Integer.parseInt(res.getParameter("id"));
        String role_code= res.getParameter("role_code");
        String role_name = res.getParameter("role_name");
        int role_state = Integer.parseInt(res.getParameter("role_status"));
        int sys_id = Integer.parseInt(res.getParameter("sys_id"));
        int role_order = Integer.parseInt(res.getParameter("role_order"));
        String role_remark = res.getParameter("role_remark");
        role_info upRole = new role_info(id,role_code,role_name,role_state,sys_id,role_order,role_remark);
        int i = roleservice.upRole(upRole);
        if(i<=0){
            msg = "新增失败，首先应行数为0";
            success = false;
        }
        retMap map = new retMap(msg,0,null,0,success);
        return map.getMap();
    }

    @RequestMapping(value = "/getRoleBySysid",method = RequestMethod.GET)
    public @ResponseBody Object getRoleBySysid(int sys_id){
        String msg = "查询成功";
        Boolean success = true;
        List<role_info> role_infos =roleservice.getRoleBySysid(sys_id);
        retMap map = new retMap(msg,0,role_infos,0,success);
        return map.getMap();
    }

}
