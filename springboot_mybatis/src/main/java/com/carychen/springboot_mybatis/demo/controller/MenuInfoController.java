package com.carychen.springboot_mybatis.demo.controller;

import com.carychen.springboot_mybatis.demo.entity.menu_info;
import com.carychen.springboot_mybatis.demo.entity.retMap;
import com.carychen.springboot_mybatis.demo.entity.terr_info;
import com.carychen.springboot_mybatis.demo.service.menuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuInfoController {

    @Autowired
    private menuService menuService;

    @RequestMapping(value = "/getMenuInfoAll",method = RequestMethod.GET)
    public @ResponseBody Object getMenuInfoAll(HttpServletRequest res){
        int page = Integer.parseInt(res.getParameter("page"))-1;
        int limit = Integer.parseInt(res.getParameter("limit"));
        String name = res.getParameter("name");
        int sys_id= Integer.parseInt(res.getParameter("sys_id"));
        int count = menuService.countMenu(name,sys_id);
        List<menu_info> menu_list = menuService.getMenuInfoAll(name,(page)*limit,limit,sys_id);
        retMap map = new retMap("查询成功",0,menu_list,count,true);
        return map.getMap();
    }

    @RequestMapping(value = "/getTerr",method = RequestMethod.GET)
    public @ResponseBody Object getTerr(HttpServletRequest res){
        int sys_id = 0;
        if(null!=res.getParameter("sys_id")&&!res.getParameter("sys_id").equals("")){
            sys_id = Integer.parseInt(res.getParameter("sys_id"));
        }
        List<menu_info> menu_info = menuService.getTerr(sys_id);
        List<terr_info> terr_list = new ArrayList<>();
        for(int i=0;i<menu_info.size();i++){//一级菜单
            terr_info terr = new terr_info(menu_info.get(i).getMenuName(),menu_info.get(i).getMenuId(),menu_info.get(i).getMenuUrl());
            System.out.println(terr.toString());
            if(menu_info.get(i).getMenuPid()==0){
                terr_list.add(terr);
            }
        }
        for (int i=0;i<terr_list.size();i++){
            if(terr_list.get(i).getUrl().trim().equals("#")){
                terr_list.get(i).setChildren(setChild(terr_list.get(i).getId(),menu_info));
            }
        }
        retMap map = new retMap("根据系统获取菜单成功",0,terr_list,0,true);
        return map.getMap();
    }

    @RequestMapping(value = "/saveMenu",method = RequestMethod.POST)
    public @ResponseBody Object saveMenu(HttpServletRequest res){
        String msg = "新增成功";
        boolean success = true;
        menu_info res_menu = new menu_info();
        String s = res.getParameter("menu_sysid");
        int sys_id = Integer.parseInt(s);
        int menu_pid = 0;
        if(null!=res.getParameter("menu_pid")&&!res.getParameter("menu_pid").equals("")){
            menu_pid = Integer.parseInt(res.getParameter("menu_pid"));
        }
        String menu_code = res.getParameter("menu_code");
        String menu_name = res.getParameter("menu_name");
        String menu_url = res.getParameter("menu_url");
        String menu_nav = res.getParameter("menu_nav");
        int menu_order = Integer.parseInt(res.getParameter("menu_order"));
        int menu_level = Integer.parseInt(res.getParameter("menu_level"));
        int menu_status = Integer.parseInt(res.getParameter("menu_status"));
        int menu_hidden = Integer.parseInt(res.getParameter("menu_hidden"));
        String menu_remark = res.getParameter("menu_remark");

        res_menu.setMenuCode(menu_code);
        res_menu.setMenuLevel(menu_level);
        res_menu.setMenuNav(menu_nav);
        res_menu.setMenuName(menu_name);
        res_menu.setMenuStatus(menu_status);
        res_menu.setMenuSysid(sys_id);
        res_menu.setMenuUrl(menu_url);
        res_menu.setMenuPid(menu_pid);
        res_menu.setMenuOrder(menu_order);
        res_menu.setMenuHidden(menu_hidden);
        res_menu.setMenuRemark(menu_remark);
        int inser_index = menuService.saveMenu(res_menu);
        if(inser_index==0){
            msg = "新增失败，相应行数为0";
            success = false;
        }
        retMap map = new retMap(msg,0,null,0,success);
        return map.getMap();
    }


    @RequestMapping(value = "/getPname",method = RequestMethod.GET)
    public @ResponseBody Object getPname(HttpServletRequest res){
        int menu_id = Integer.parseInt(res.getParameter("menu_id"));
        menu_info pmenu = menuService.getPmenu(menu_id);
        List<menu_info> list = new ArrayList<>();
        list.add(pmenu);
        retMap map = new retMap("",0,list,0,true);
        return map.getMap();
    }


    @RequestMapping(value = "/upMenu",method = RequestMethod.POST)
    public @ResponseBody Object upMenu(HttpServletRequest res){
        String msg = "修改成功";
        boolean success = true;
        menu_info res_menu = new menu_info();
        int menu_id = Integer.parseInt(res.getParameter("menu_id"));
        String s = res.getParameter("menu_sysid");
        int sys_id = Integer.parseInt(s);
        int menu_pid = 0;
        if(null!=res.getParameter("menu_pid")&&!res.getParameter("menu_pid").equals("")){
            menu_pid = Integer.parseInt(res.getParameter("menu_pid"));
        }
        String menu_code = res.getParameter("menu_code");
        String menu_name = res.getParameter("menu_name");
        String menu_url = res.getParameter("menu_url");
        String menu_nav = res.getParameter("menu_nav");
        int menu_order = Integer.parseInt(res.getParameter("menu_order"));
        int menu_level = Integer.parseInt(res.getParameter("menu_level"));
        int menu_status = Integer.parseInt(res.getParameter("menu_status"));
        int menu_hidden = Integer.parseInt(res.getParameter("menu_hidden"));
        String menu_remark = res.getParameter("menu_remark");

        res_menu.setMenuId(menu_id);
        res_menu.setMenuCode(menu_code);
        res_menu.setMenuLevel(menu_level);
        res_menu.setMenuNav(menu_nav);
        res_menu.setMenuName(menu_name);
        res_menu.setMenuStatus(menu_status);
        res_menu.setMenuSysid(sys_id);
        res_menu.setMenuUrl(menu_url);
        res_menu.setMenuPid(menu_pid);
        res_menu.setMenuOrder(menu_order);
        res_menu.setMenuHidden(menu_hidden);
        res_menu.setMenuRemark(menu_remark);
        int i =menuService.upMenu(res_menu);
        if(i<=0){
            msg = "修改失败，相应行数为0";
            success = false;
        }
        retMap map = new retMap(msg,0,null,0,success);
        return map.getMap();

    }

    public @ResponseBody Object delMenu(String menu_id){
        String msg = "删除成功";
        boolean success = true;
        int menuid = Integer.parseInt(menu_id);
        int i = menuService.delMenu(menuid);
        if(i==0){
            msg = "删除失败，相应行数为0";
            success = false;
        }
        retMap map = new retMap(msg,0,null,0,success);
        return map.getMap();
    }

    /**
     *
     * @param menu_id 父节点id
     * @param menu_info 菜单集合
     * @return
     */
    public List<terr_info> setChild(int menu_id,List<menu_info> menu_info){
        List<terr_info> terr_info_list  = new ArrayList<>();
        for(int i=0;i<menu_info.size();i++){//封装子菜单
            if(menu_id==menu_info.get(i).getMenuPid()&&menu_id!=menu_info.get(i).getMenuId()){
                terr_info_list.add(new terr_info(menu_info.get(i).getMenuName(),menu_info.get(i).getMenuId(),menu_info.get(i).getMenuUrl()));
            }
        }

        for(terr_info menu:terr_info_list){//判断子菜单是否为最后一级
            if(menu.getUrl().trim().equals("#")){//有上级菜单的，路径为#
                menu.setChildren(setChild(menu.getId(),menu_info));
            }
        }
        if(terr_info_list.size()==0)return null;
        return terr_info_list;
    }
}
