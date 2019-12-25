package com.carychen.springboot_mybatis.demo.controller;

import com.carychen.springboot_mybatis.demo.entity.dormitory_info;
import com.carychen.springboot_mybatis.demo.entity.floor_info;
import com.carychen.springboot_mybatis.demo.entity.retMap;
import com.carychen.springboot_mybatis.demo.service.DormitoryService;
import com.carychen.springboot_mybatis.demo.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by chentao
 * Date by 2019-12-17
 * 无敌太寂寞
 */
@Controller
@RequestMapping("/dormitory")
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;

    @Autowired
    private FloorService floorService;

    @RequestMapping(value = "/getDormitoryAll",method = RequestMethod.GET)
    public @ResponseBody Object getDormitoryAll(String name,int f_sex,int page,int limit){
        retMap map = new retMap();
        String msg = "查询成功";
        try {
            List<dormitory_info> getDormitory = dormitoryService.getDormitoyAll(name,f_sex,page,limit);
            int count = dormitoryService.countDormitoy(name,f_sex);
            map.setCount(count);
            map.setData(getDormitory);
        }catch (Exception e){
            System.err.println("获取宿舍信息失败:"+e.toString());
            msg="获取宿舍信息失败:"+e.toString();
            map.setCode(2000);
            map.setData(null);
        }
        map.setMsg(msg);
        return  map.getMap();
    }

    @RequestMapping(value = "/getFloor",method = RequestMethod.GET)
    public @ResponseBody Object getFloor(){
        retMap map = new retMap();
        String msg = "获取楼层成功";
        boolean suce = true;
        try {
            List<floor_info> floorInfos = floorService.getFloor();
            map.setData(floorInfos);
        }catch (Exception e){
            System.err.println("获取漏楼层失败"+e.toString());
            msg="获取漏楼层失败"+e.toString();
            suce = false;
        }
        map.setMsg(msg);
        map.setSuccess(suce);
        return map.getMap();
    }

    @RequestMapping(value = "/saveDormitory",method = RequestMethod.POST)
    public @ResponseBody Object saveDormitory(HttpServletRequest res){
        retMap map = new retMap();
        String msg = "新增成功";
        boolean suce = true;
        try {
            int f_id = Integer.parseInt(res.getParameter("f_id"));
            int max_number = Integer.parseInt(res.getParameter("max_number"));
            String d_number = res.getParameter("d_number");
            dormitory_info saveDormitory = new dormitory_info(f_id,max_number,d_number,0);
            int i = dormitoryService.saveDormitoy(saveDormitory);
            if(i<=0){
                msg = "新增失败,相应行数小于1";
                suce =false;
            }
        }catch (Exception e){
            System.err.println("新增宿舍信息失败:"+e.toString());
            msg = "新增失败";
            suce =false;
        }
        map.setMsg(msg);
        map.setSuccess(suce);
        return map.getMap();
    }

    @RequestMapping(value = "/upDormitory",method = RequestMethod.POST)
    public @ResponseBody Object upDormitory(HttpServletRequest res){
        retMap map = new retMap();
        String msg = "修改成功";
        boolean suce = true;
        try {
            int d_id = Integer.parseInt(res.getParameter("d_id"));
            int f_id = Integer.parseInt(res.getParameter("f_id"));
            int max_number = Integer.parseInt(res.getParameter("max_number"));
            String d_number = res.getParameter("d_number");
            dormitory_info upDormitory = new dormitory_info(d_id,f_id,max_number,d_number,0);
            dormitoryService.upDormitoy(upDormitory);
        }catch (Exception e){
            System.err.println("修改宿舍信息失败:"+e.toString());
            msg = "修改失败";
            suce =false;
        }
        map.setSuccess(suce);
        map.setMsg(msg);
        return  map.getMap();
    }

}
