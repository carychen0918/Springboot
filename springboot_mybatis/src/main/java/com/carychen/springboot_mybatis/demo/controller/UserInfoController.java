package com.carychen.springboot_mybatis.demo.controller;

import com.carychen.springboot_mybatis.demo.entity.*;
import com.carychen.springboot_mybatis.demo.service.menuService;
import com.carychen.springboot_mybatis.demo.service.roleService;
import com.carychen.springboot_mybatis.demo.service.system_service;
import com.carychen.springboot_mybatis.demo.service.user_service;
import com.carychen.springboot_mybatis.demo.util.PasswordMD5;
import com.carychen.springboot_mybatis.demo.util.setTerr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private user_service userService;

    @Autowired
    private roleService roleService;

    @Autowired
    private system_service systemService;

    @Autowired
    private menuService menuService;

    @Autowired
    private RedisTemplate<Object, Object>  redisTemplate;

    @Value("#{'${ignore_url}'.split(',')}")
    private List<String> ignore_url;//能够请求的页面

    private setTerr setTerr = new setTerr();

    public PasswordMD5 password = new PasswordMD5();

    @RequestMapping(value = "/userlogin",method = RequestMethod.GET)
    public @ResponseBody Object login(HttpServletRequest res, HttpServletResponse req) throws IOException {
        retMap map = new retMap();
        String user_login = res.getParameter("user_login");
        String login_passeord = res.getParameter("login_password");
        login_passeord = password.setPassword(login_passeord);
        System.out.println("加密后的密码"+login_passeord);
        String user_key = "user_"+user_login;
//        boolean hasKey = redisTemplate.hasKey(user_key);
//            this.redisTemplate.opsForValue().set(user_key, log_user);
//            redisTemplate.opsForValue().set("menu_"+user_login,role_mune);
        user_info log_user = userService.getUserInfoById(user_login,login_passeord);
        if(log_user==null){
                map.setMsg("登录失败：用户名或密码错误");
                map.setSuccess(false);
                return map.getMap();
            }else{
            if(log_user.getUserStatus()==0){
                map.setMsg("登录失败：用户已被禁用，请联系管理员");
                map.setSuccess(false);
                return map.getMap();
            }
        }
        system_info systemInfo = systemService.getSystemByid(log_user.getUserSys());//系统
//        List<role_menu_info> role_mune =  roleService.getRoleMenuByRoleid(log_user.getRoleId());//角色菜单权限
        List<menu_info> menu_info = menuService.getTerrByUserSysId(log_user.getRoleId());//获取权限的菜单信息
        List<String> fuis_url = new ArrayList<>();
        for(int i=0;i<menu_info.size();i++){
            fuis_url.add(menu_info.get(i).getMenuUrl());
        }
        fuis_url.add(systemInfo.getSysMainUrl());
        res.getSession().setAttribute("fuis_url",fuis_url);
        List<terr_info> terr_info= setTerr.setChild(0,menu_info);
        res.getSession().setAttribute("user_info",log_user);
        res.getSession().setAttribute("indexPath",systemInfo.getSysMainUrl());
        res.getSession().setAttribute("sys_url",systemInfo.getSysUrl());
        res.getSession().setAttribute("system_name",systemInfo.getSysName());
        res.getSession().setAttribute("menu_info",terr_info);
        map.setSuccess(true);

        return map.getMap();
    }

    @RequestMapping("/CancellationLogin")
    public String CancellationLogin(HttpServletRequest res){
        res.getSession().invalidate();
        return "default/login";
    }

    @RequestMapping("/toHtml")
    public String toHtml(String url,HttpServletRequest res){
        user_info user_info = (user_info) res.getSession().getAttribute("user_info");
        if (null ==user_info){
            return "default/login";
        }
        String to_url="html/no_jur" ;
        for(int i =0;i<ignore_url.size();i++){
            if(ignore_url.get(i).indexOf(url)>=0){
                to_url =url;
                break;
            }
        }
        List<String> menu_info  = (List<String>) res.getSession().getAttribute("fuis_url");
        for(int i=0;i<menu_info.size();i++){
            if(menu_info.get(i).indexOf(url)>=0){
                to_url =url;
                break;
            }
        }
        return to_url;
    }


    @RequestMapping(value = "/getUserInfofoAll",method = RequestMethod.GET)
    public @ResponseBody Object getUserInfofoAll(int sys_id, String name, int org_id,int page,int limit){
        retMap map = new retMap();
        String msg = "查询成功";
        try {
            List<user_info> userList = userService.getUserInfoAll(name,sys_id,org_id,(page-1)*limit,limit);
            for(int i=0;i<userList.size();i++){
                userList.get(i).setLoginPassword(password.convertMD5(userList.get(i).getLoginPassword()));
            }
            int count = userService.getUserCount(name,sys_id,org_id);
            map.setCount(count);
            map.setMsg(msg);
            map.setData(userList);
            return map.getMap();
        }catch (Exception e){
            System.err.println("查询用户列表失败："+e.toString());
            msg = "查询用户列表失败："+e.toString();
            map.setMsg(msg);
            map.setCode(2000);
            return map.getMap();
        }
    }

    @RequestMapping(value = "/saveUserInfo",method = RequestMethod.POST)
    public @ResponseBody Object saveUserInfo(HttpServletRequest res){
        retMap map = new retMap();
        String msg = "新增成功";
        Boolean success = true;
        try {
            String user_name = res.getParameter("user_name");
            String user_login = res.getParameter("user_login");
            String login_password = res.getParameter("login_password");
            System.out.println("加密前密码："+login_password);
            login_password = password.setPassword(login_password);//密码加密
            System.out.println("加密后密码："+login_password);
            int user_status = Integer.parseInt(res.getParameter("user_status"));
            int user_org = Integer.parseInt(res.getParameter("user_org"));
            String user_phone = res.getParameter("user_phone");
            String user_remark = res.getParameter("user_remark");
            int user_sex = Integer.parseInt(res.getParameter("user_sex"));
            String user_email = res.getParameter("user_email");
            int user_sys = Integer.parseInt(res.getParameter("user_sys"));
            int role_id = Integer.parseInt(res.getParameter("role_id"));
            String user_on = res.getParameter("user_on");
            user_info saveUserInfo = new user_info(user_name,user_login,login_password,user_status,user_org,user_phone,user_remark,user_sex,user_email,user_sys,role_id,user_on);
            userService.saveUser_info(saveUserInfo);
            map.setMsg(msg);
            map.setSuccess(success);
            return  map.getMap();
        }catch (Exception e){
            msg = "新增失败，原因"+e.toString();
            System.err.println(msg);
            success =false;
            map.setMsg(msg);
            map.setSuccess(success);
            return map.getMap();
        }

    }

    @RequestMapping(value = "/upUserInfo",method = RequestMethod.POST)
    public @ResponseBody Object upUserInfo(HttpServletRequest res){
        retMap map = new retMap();
        String msg = "修改成功";
        Boolean success = true;
        try {
            int id = Integer.parseInt(res.getParameter("id"));
            String user_name = res.getParameter("user_name");
            String user_login = res.getParameter("user_login");
            String login_password = res.getParameter("login_password");
            System.out.println("加密前密码："+login_password);
            login_password = password.setPassword(login_password);//密码加密
            System.out.println("加密后密码："+login_password);
            int user_status = Integer.parseInt(res.getParameter("user_status"));
            int user_org = Integer.parseInt(res.getParameter("user_org"));
            String user_phone = res.getParameter("user_phone");
            String user_remark = res.getParameter("user_remark");
            int user_sex = Integer.parseInt(res.getParameter("user_sex"));
            String user_email = res.getParameter("user_email");
            int user_sys = Integer.parseInt(res.getParameter("user_sys"));
            int role_id = Integer.parseInt(res.getParameter("role_id"));
            String user_on = res.getParameter("user_on");
            user_info upUserInfo = new user_info(id,user_name,user_login,login_password,user_status,user_org,user_phone,user_remark,user_sex,user_email,user_sys,role_id,user_on);
            userService.UpUser_info(upUserInfo);
            map.setMsg(msg);
            map.setSuccess(success);
            return map.getMap();
        }catch (Exception e){
            msg = "修改失败，原因："+e.toString();
            success =false;
            map.setMsg(msg);
            map.setSuccess(success);
            return map.getMap();
        }
    }

    @RequestMapping(value = "/ResetPassword",method =RequestMethod.GET)
    public @ResponseBody Object ResetPassword(int id){
        retMap map = new retMap();
        String msg = "重置密码成功";
        Boolean success = true;
        try {
            String logpassword = password.setPasswordInfo();
            user_info upUserInfo = new user_info(id,logpassword);
            userService.UpUser_info(upUserInfo);
            msg +="，新密码："+password.convertMD5(logpassword);
            map.setMsg(msg);
            map.setSuccess(success);
            return  map.getMap();
        }catch (Exception e){
            msg = "重置密码失败，原因："+e.toString();
            success =false;
            map.setMsg(msg);
            map.setSuccess(success);
            return map.getMap();
        }
    }

    @RequestMapping(value = "/upUserStatus",method = RequestMethod.GET)
    public @ResponseBody Object upUserStatus(int id,int user_status){
        retMap map = new retMap();
        String msg = "禁用/启用成功";
        Boolean success = true;
        try {
            user_info upUserInfo = new user_info(id,user_status);
            userService.UpUser_info(upUserInfo);
            map.setMsg(msg);
            map.setSuccess(success);
            return  map.getMap();
        }catch (Exception e){
            msg = "禁用/启用失败，原因："+e.toString();
            success =false;
            map.setMsg(msg);
            map.setSuccess(success);
            return map.getMap();
        }
    }
}
