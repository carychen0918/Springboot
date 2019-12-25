package com.carychen.springboot_mybatis.demo.controller;

import com.carychen.springboot_mybatis.demo.entity.retMap;
import com.carychen.springboot_mybatis.demo.entity.system_info;
import com.carychen.springboot_mybatis.demo.serviceImp.SystemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/system")
@Controller
public class SystemController {

    @Autowired
    private SystemServiceImp serviceImp;

    @RequestMapping(value="/getSystemAll",method = RequestMethod.GET)
    public @ResponseBody Object getSystemAll(HttpServletRequest request){
        int page = Integer.parseInt(request.getParameter("page"))-1;
        int limt = Integer.parseInt(request.getParameter("limit"));
        String Name = request.getParameter("name");
        System.out.println("查询条件"+Name);
        List<system_info> all = serviceImp.getSystemAll(Name,(page-1)*limt,limt);
        int count = serviceImp.selectCount(Name);
        retMap map = new retMap("查询成功",0,all,count,true);
        return map.getMap();
    }

    @RequestMapping(value = "/saveSystem",method = RequestMethod.POST)
    public @ResponseBody Object saveSystem(HttpServletRequest res){
        String sys_code = res.getParameter("sys_code");
        String sys_name = res.getParameter("sys_name");
        String sys_url =res.getParameter("sys_url");
        String sys_main_url =res.getParameter("sys_main_url");
        int sys_status = Integer.parseInt(res.getParameter("sys_status"));
        String sys_remark =res.getParameter("sys_remark");
        system_info sys = new system_info(sys_code,sys_name,sys_url,sys_main_url,sys_status,sys_remark);
        int idnex = serviceImp.save_systemInfo(sys);
        String msg = "新增成功";
        boolean success = true;
        if(idnex==0){
            msg = "新增失败";
            success=false;
        }
        retMap map = new retMap(msg,0,null,0,success);
        return  map.getMap();
    }

    @RequestMapping(value = "/upsystem",method = RequestMethod.POST)
    public @ResponseBody Object upsystem(HttpServletRequest res){
        int id = Integer.parseInt(res.getParameter("id"));
        String sys_code = res.getParameter("sys_code");
        String sys_name = res.getParameter("sys_name");
        String sys_url =res.getParameter("sys_url");
        String sys_main_url =res.getParameter("sys_main_url");
        int sys_status = Integer.parseInt(res.getParameter("sys_status"));
        String sys_remark =res.getParameter("sys_remark");
        system_info sys = new system_info(sys_code,sys_name,sys_url,sys_main_url,sys_status,sys_remark);
        sys.setId(id);
        int upindex = serviceImp.UpSystemInfo(sys);
        String msg = "修改成功";
        boolean success = true;
        if(upindex==0){
            msg = "修改失败";
            success=false;
        }
        retMap map = new retMap(msg,0,null,0,success);
        return  map.getMap();
    }

    @RequestMapping(value = "/getSystemInfo",method = RequestMethod.GET)
    public @ResponseBody Object getSystemInfo(HttpServletRequest res){
        List<system_info> sys_info = serviceImp.getSystemInfo();
        retMap map = new retMap("查询成功", 0,sys_info,0,true);
        return map.getMap();
    }

}
