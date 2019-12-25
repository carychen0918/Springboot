package com.carychen.springboot_mybatis.demo.util;

import com.carychen.springboot_mybatis.demo.entity.menu_info;
import com.carychen.springboot_mybatis.demo.entity.terr_info;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chentao
 * Date by 2019-12-03
 * 无敌太寂寞
 */
public class setTerr {
    public List<terr_info> setChild(int menu_id, List<menu_info> menu_info){
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
