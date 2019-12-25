package com.carychen.springboot_mybatis.demo.controller;

import com.carychen.springboot_mybatis.demo.entity.floor_info;
import com.carychen.springboot_mybatis.demo.entity.retMap;
import com.carychen.springboot_mybatis.demo.entity.user_info;
import com.carychen.springboot_mybatis.demo.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chentao
 * Date by 2019-12-11
 * 无敌太寂寞
 */
@Controller
@RequestMapping("/floor")
public class FloorController {

    @Autowired
    private FloorService floorService;

    @RequestMapping(value = "/getFloorAll",method = RequestMethod.GET)
    public @ResponseBody Object getFloorAll(String name,int f_sex,int page,int limit){
        retMap map = new retMap();
        String msg = "查询成功";
        Boolean suces = true;
        try {
            List<floor_info> floorInfoList = floorService.getFloorAll(name,f_sex,page,limit);
            int count = floorService.getCount(name,f_sex);
            map.setData(floorInfoList);
            map.setCount(count);
        }catch (Exception e){
            System.err.println(e);
            msg="查询楼层失败："+e.toString();
            suces =false;
            map.setCode(1000);
            map.setData(null);
        }
        map.setSuccess(suces);
        map.setMsg(msg);
        return  map.getMap();
    }

    @RequestMapping(value = "/getUserLis",method = RequestMethod.GET)
    public @ResponseBody Object getUserLis(){
        retMap map = new retMap();
        String msg = "获取宿舍管理员成功";
        Boolean suces = true;
        try {
            List<user_info> userInfoList = floorService.getUserlistBysysid();
            map.setData(userInfoList);
        }catch (Exception e){
            msg="获取宿舍管理员失败："+e.toString();
            suces =false;
            map.setData(null);
        }
        map.setSuccess(suces);
        map.setMsg(msg);
        return  map.getMap();
    }

    @RequestMapping(value = "/saveFloor",method = RequestMethod.POST)
    public @ResponseBody Object saveFloor(HttpServletRequest res, HttpServletResponse req){
        retMap map = new retMap();
        String msg = "新增成功";
        Boolean suces = true;
        try {
            int u_id = Integer.parseInt(res.getParameter("u_id"));
            String add_time =new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date());
            int add_by = ((user_info)res.getSession().getAttribute("user_info")).getId();
            int f_sex = Integer.parseInt(res.getParameter("f_sex"));
            int f_number = res.getParameter("f_number")==""?0:Integer.parseInt(res.getParameter("f_number"));
            String f_name = res.getParameter("f_name");
            floor_info savefloor = new floor_info(u_id,add_time,add_by,null,null,f_sex,f_number,f_name);
            int i = floorService.saveFloor(savefloor);
            if(i<=0){
                msg ="新增失败，相应行数为0";
                suces = false;
            }
        }catch (Exception e){
            System.err.println(e);
            msg ="新增失败:"+e.toString();
            suces = false;
        }
        map.setMsg(msg);
        map.setSuccess(suces);
        return map.getMap();
    }

    @RequestMapping(value = "/upFloor",method = RequestMethod.POST)
    public @ResponseBody Object upFloor(HttpServletRequest res){
        retMap map = new retMap();
        String msg = "修改成功";
        Boolean suces = true;
        try {
            int f_id = Integer.parseInt(res.getParameter("f_id"));
            int u_id = Integer.parseInt(res.getParameter("u_id"));
            String up_date =new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date());
            int up_by = ((user_info)res.getSession().getAttribute("user_info")).getId();
            int f_sex = Integer.parseInt(res.getParameter("f_sex"));
            int f_number = res.getParameter("f_number")==""?6:Integer.parseInt(res.getParameter("f_number"));
            String f_name = res.getParameter("f_name");
            floor_info upfloor = new floor_info(f_id,u_id,null,null,up_date,up_by,f_sex,f_number,f_name);
            floorService.upFloor(upfloor);
        }catch (Exception e){
            msg="修改失败："+e.toString();
            suces = false;
        }
        map.setSuccess(suces);
        map.setMsg(msg);
        return map.getMap();
    }
}
