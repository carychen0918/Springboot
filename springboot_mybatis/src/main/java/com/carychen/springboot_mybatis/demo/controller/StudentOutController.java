package com.carychen.springboot_mybatis.demo.controller;

import com.carychen.springboot_mybatis.demo.entity.retMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chentao
 * Date by 2019-12-20
 * 无敌太寂寞
 */
@Controller
@RequestMapping("/student_out")
public class StudentOutController {


    @RequestMapping(value = "/getStudentOutAll",method = RequestMethod.GET)
    public @ResponseBody Object getStudentOutAll(String name,int c_id,String d_number,String out_time,int page,int limit){
        retMap map = new retMap();
        String msg ="查询迁出信息成功";
        try {

        }catch (Exception e){
            System.err.println("查询迁出信息失败："+e.toString());
            msg ="查询迁出信息失败："+e.toString();
            map.setCode(2000);
        }
        return map.getMap();
    }
}
