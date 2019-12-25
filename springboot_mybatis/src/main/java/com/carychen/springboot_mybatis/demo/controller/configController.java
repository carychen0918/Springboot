package com.carychen.springboot_mybatis.demo.controller;

import com.carychen.springboot_mybatis.demo.entity.user_info;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by chentao
 * Date by 2019-11-28
 * 无敌太寂寞
 */
@Controller
public class configController {



    @RequestMapping("/Cary")
    public  String Holle(){
        return "/default/login";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest res){
        String indexPath = (String)res.getSession().getAttribute("sys_url");
        System.out.println(indexPath);
        user_info user_info = (user_info) res.getSession().getAttribute("user_info");
        if (null ==user_info){
            return "default/login";
        }
        return indexPath;
    }
}
