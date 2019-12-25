package com.carychen.springboot_mybatis.demo.controller;

import com.carychen.springboot_mybatis.demo.entity.Student_info;
import com.carychen.springboot_mybatis.demo.entity.department_info;
import com.carychen.springboot_mybatis.demo.entity.dormitory_info;
import com.carychen.springboot_mybatis.demo.entity.retMap;
import com.carychen.springboot_mybatis.demo.service.DepartmentService;
import com.carychen.springboot_mybatis.demo.service.DormitoryService;
import com.carychen.springboot_mybatis.demo.service.StudentService;
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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private DormitoryService dormitoryService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/getStudentAll",method = RequestMethod.GET)
    public @ResponseBody Object getStudentAll(String name,int f_sex,int c_id,int page,int limit){
        retMap map  = new retMap();
        String msg = "查询入住学生成功";
        try {
            List<Student_info> studentInfoList = studentService.getStudentAll(name,f_sex,c_id,page,limit);
            int count = studentService.getCount(name,f_sex,c_id);
            map.setData(studentInfoList);
            map.setCount(count);
        }catch (Exception e){
            System.err.println("查询入住学生失败："+e.toString());
            msg ="查询入住学生失败："+e.toString();
            map.setCode(2000);
            map.setData(null);
            map.setCount(0);
        }
        map.setMsg(msg);
        return map.getMap();
    }

    @RequestMapping(value = "/getDor",method = RequestMethod.GET)
    public @ResponseBody Object getDor(int f_id){
        retMap map  = new retMap();
        String msg = "根据楼层获取宿舍成功";
        boolean suce = true;
        try {
            List<dormitory_info> dormitoryInfoList = dormitoryService.getDormitoryByFid(f_id);
            map.setData(dormitoryInfoList);
        }catch (Exception e){
            System.err.println("根据楼层获取宿舍失败："+e.toString());
            msg="根据楼层获取宿舍失败："+e.toString();
            suce =false;
            map.setData(null);
        }
        map.setMsg(msg);
        map.setSuccess(suce);
        return map.getMap();
    }

    @RequestMapping(value = "/saveStudent" ,method = RequestMethod.POST)
    public @ResponseBody Object saveStudent(HttpServletRequest res){
        retMap map  = new retMap();
        String msg = "学生入住成功";
        boolean suce = true;
        try {
            String s_id_number = res.getParameter("s_id_number");
            Student_info selStu = studentService.getStuBySnumber(s_id_number);
            if(null!=selStu){
                map.setSuccess(false);
                map.setMsg("该学号对应的学生已入住");
                return map.getMap();
            }
            String s_name = res.getParameter("s_name");
            int s_sex = Integer.parseInt(res.getParameter("s_sex"));
            int c_id = Integer.parseInt(res.getParameter("c_id"));
            String s_phone = res.getParameter("s_phone");
            String s_email = res.getParameter("s_email");
            String s_urgent_phone = res.getParameter("s_urgent_phone");
            String s_urgent_name = res.getParameter("s_urgent_name");
            String s_urgent_address = res.getParameter("s_urgent_address");
            String s_session = res.getParameter("s_session");
            int d_id = Integer.parseInt(res.getParameter("d_id"));
            int s_state = 0;
            Student_info saveStu = new Student_info(s_name,s_sex,c_id,s_phone,s_email,s_urgent_phone,s_urgent_name,s_urgent_address,s_id_number,s_session,d_id,s_state);
            int i =studentService.saveStudent(saveStu);
            if(i<=0){
                msg="学生入住失败：寝室更新失败";
                suce =false;
            }
        }catch (Exception e){
            System.err.println("学生入住失败："+e.toString());
            msg="学生入住失败："+e.toString();
            suce =false;
        }
        map.setMsg(msg);
        map.setSuccess(suce);
        return map.getMap();
    }

    @RequestMapping(value = "/getDepartmentBySupId",method = RequestMethod.GET)
    public @ResponseBody Object getDepartmentBySupId(int sup_id){
        retMap map  = new retMap();
        String msg = "获取上级院系";
        boolean suce = true;
        try {
            department_info departmentInfo = departmentService.getFatherDid(sup_id);
            map.setData(departmentInfo);
        }catch (Exception e){
            msg="获取上级院系失败";
            suce=false;
            map.setData(null);
        }
        map.setMsg(msg);
        map.setSuccess(suce);
        return  map.getMap();
    }

    @RequestMapping(value = "/upStudent" ,method = RequestMethod.POST)
    public @ResponseBody Object upStudent(HttpServletRequest res){
        retMap map  = new retMap();
        String msg = "学生入住成功";
        boolean suce = true;
        try {
            String s_id_number = res.getParameter("s_id_number");
            Student_info selStu = studentService.getStuBySnumber(s_id_number);
            if(null!=selStu){
                map.setSuccess(false);
                map.setMsg("该学号对应的学生已入住");
                return map.getMap();
            }
            int s_id = Integer.parseInt(res.getParameter("s_id"));
            String s_name = res.getParameter("s_name");
            int s_sex = Integer.parseInt(res.getParameter("s_sex"));
            int c_id = Integer.parseInt(res.getParameter("c_id"));
            String s_phone = res.getParameter("s_phone");
            String s_email = res.getParameter("s_email");
            String s_urgent_phone = res.getParameter("s_urgent_phone");
            String s_urgent_name = res.getParameter("s_urgent_name");
            String s_urgent_address = res.getParameter("s_urgent_address");
            String s_session = res.getParameter("s_session");
            int d_id = Integer.parseInt(res.getParameter("d_id"));
            int s_state = 0;
            int up_d_id = Integer.parseInt(res.getParameter("up_d_id"));
            Student_info upStu = new Student_info(s_id,s_name,s_sex,c_id,s_phone,s_email,s_urgent_phone,s_urgent_name,s_urgent_address,s_id_number,s_session,d_id,s_state);
            int i = studentService.upStudent(upStu,up_d_id);
            if(i<=0){
                msg="学生入住失败：寝室更新失败";
                suce =false;
            }
        }catch (Exception e){
            System.err.println("学生入住失败："+e.toString());
            msg="学生入住失败："+e.toString();
            suce =false;
        }
        map.setMsg(msg);
        map.setSuccess(suce);
        return map.getMap();
    }


}
