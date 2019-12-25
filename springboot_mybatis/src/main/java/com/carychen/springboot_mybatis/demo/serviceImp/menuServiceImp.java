package com.carychen.springboot_mybatis.demo.serviceImp;

import com.carychen.springboot_mybatis.demo.dao.menu_infoMapper;
import com.carychen.springboot_mybatis.demo.entity.menu_info;
import com.carychen.springboot_mybatis.demo.service.menuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class menuServiceImp implements menuService {

    @Autowired
    private menu_infoMapper menuInfoMapper;

    @Override
    public List<menu_info> getMenuInfoAll(String name, int page, int limit, int sys_id) {
        return menuInfoMapper.getMenuInfoAll(name,page,limit,sys_id);
    }

    @Override
    public int countMenu(String name, int sys_id) {
        return menuInfoMapper.countMent(name,sys_id);
    }

    @Override
    public int saveMenu(menu_info menuInfo) {
        return menuInfoMapper.saveMenu(menuInfo);
    }

    @Override
    public int upMenu(menu_info menuInfo) {
        return menuInfoMapper.upMenuByid(menuInfo);
    }

    @Override
    public int delMenu(int menu_id) {
        return menuInfoMapper.delMenuByid(menu_id);
    }

    @Override
    public List<menu_info> getTerr(int sys_id) {
        return menuInfoMapper.getTerr(sys_id);
    }

    @Override
    public menu_info getPmenu(int menu_id) {
        return menuInfoMapper.getMenuByid(menu_id);
    }

    @Override
    public List<menu_info> getTerrByUserSysId(int user_role_id) {
        return menuInfoMapper.getTerrByUserSysId(user_role_id);
    }

    public menu_info getSupMenuByPid(int p_id){
        return  menuInfoMapper.getSupMenuByPid(p_id);
    }
}
