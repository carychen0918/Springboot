package com.carychen.springboot_mybatis.demo.controller;

import com.carychen.springboot_mybatis.demo.entity.department_info;
import com.carychen.springboot_mybatis.demo.entity.retMap;
import com.carychen.springboot_mybatis.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by chentao
 * module 院系班控制层
 * Date by 2019-12-10
 * 无敌太寂寞
 */
@Controller
@RequestMapping("/department")
public class DepartmentContorller {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/getDepartmentAll",method = RequestMethod.GET)
    public @ResponseBody Object getDepartmentAll(String name,int sup_id,int page,int limit){
        retMap map = new retMap();
        try {
            List<department_info> departmentInfoList = departmentService.getDepartmentAll(name,sup_id,page,limit);
            int count = departmentService.getCount(name,sup_id);
            map.setCount(count);
            map.setMsg("查询成功");
            map.setSuccess(true);
            map.setData(departmentInfoList);
        }catch (Exception e){
            map.setCode(1000);
            map.setMsg("查询院系失败："+e.toString());
            map.setData(null);
            map.setSuccess(false);
        }
        return map.getMap();
    }

    @RequestMapping(value = "/saveDepartment",method = RequestMethod.POST)
    public @ResponseBody Object saveDepartment(HttpServletRequest res){
        retMap map = new retMap();
        try {
            String msg = "新增成功";
            Boolean success = true;
            String d_nanem = res.getParameter("d_nanem");
            String d_teacher_name = res.getParameter("d_teacher_name");
            String d_teacher_phone = res.getParameter("d_teacher_phone");
            String d_teacher_email = res.getParameter("d_teacher_email");
            int d_sup_id =  Integer.parseInt(res.getParameter("d_sup_id"));
            department_info departmentInfos = departmentService.selDepartment(d_sup_id,d_nanem);
            if(departmentInfos!=null){
                msg = "新增失败，同级院系下存在相同名称";
                success = false;
                map.setMsg(msg);
                map.setSuccess(success);
                return map.getMap();
            }
            department_info departmentInfo = new department_info(d_nanem,d_teacher_name,d_teacher_phone,d_teacher_email,d_sup_id);
            int i = departmentService.saveDepartment(departmentInfo);
            if(i<=0){
                msg = "新增失败，首先应行数为0";
                success = false;
            }
            map.setMsg(msg);
            map.setSuccess(success);
        }catch (Exception e){
            map.setCode(1000);
            map.setMsg("新增失败："+e.toString());
            map.setData(null);
            map.setSuccess(false);
        }
        return map.getMap();
    }

    @RequestMapping(value ="/getDepartmentBySupid" ,method = RequestMethod.GET)
    public @ResponseBody Object getDepartmentBySupid(int sup_id){
        retMap map = new retMap();
        try {
            System.err.println(sup_id);
            List<department_info> departmentInfoList = departmentService.getDepartmentBySupid(sup_id);
            map.setMsg("获取下拉成功");
            map.setData(departmentInfoList);
            map.setSuccess(true);
        }catch (Exception e){
            map.setCode(1000);
            map.setMsg("获取下拉失败："+e.toString());
            map.setData(null);
            map.setSuccess(false);
        }
        return map.getMap();
    }
    @RequestMapping(value ="/getFatherDid" ,method = RequestMethod.GET)
    public @ResponseBody Object getFatherDid(int sup_id){
        retMap map = new retMap();
        try {
            department_info departmentInfo = departmentService.getFatherDid(sup_id);
            map.setMsg("获取父级下拉成功");
            map.setData(departmentInfo);
            map.setSuccess(true);
        }catch (Exception e){
            map.setCode(1000);
            map.setMsg("获取父级下拉失败："+e.toString());
            map.setData(null);
            map.setSuccess(false);
        }
        return map.getMap();
    }

    @RequestMapping(value = "/upDepartment",method = RequestMethod.POST)
    public @ResponseBody Object upDepartment(HttpServletRequest res){
        retMap map = new retMap();
        try {
            int d_id = Integer.parseInt(res.getParameter("d_id"));
            String d_nanem = res.getParameter("d_nanem");
            String d_teacher_name = res.getParameter("d_teacher_name");
            String d_teacher_phone = res.getParameter("d_teacher_phone");
            String d_teacher_email = res.getParameter("d_teacher_email");
            int d_sup_id =  Integer.parseInt(res.getParameter("d_sup_id"));
            department_info departmentInfos = departmentService.selDepartment(d_sup_id,d_nanem);
            if(departmentInfos!=null){
                map.setMsg("新增失败，同级院系下存在相同名称");
                map.setSuccess(false);
                return map.getMap();
            }
            department_info departmentInfo = new department_info(d_id,d_nanem,d_teacher_name,d_teacher_phone,d_teacher_email,d_sup_id);
            departmentService.upDepartment(departmentInfo);
            map.setMsg("修改成功");
            map.setSuccess(true);
        }catch (Exception e){
            map.setMsg("修改失败："+e.toString());
            map.setData(null);
            map.setSuccess(false);
        }
        return map.getMap();
    }
}
