package com.carychen.springboot_mybatis.demo.controller;

import com.carychen.springboot_mybatis.demo.entity.Student_info;
import com.carychen.springboot_mybatis.demo.entity.retMap;
import com.carychen.springboot_mybatis.demo.entity.student_out;
import com.carychen.springboot_mybatis.demo.entity.user_info;
import com.carychen.springboot_mybatis.demo.service.StudentOutSservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chentao
 * Date by 2019-12-20
 * 无敌太寂寞
 */
@Controller
@RequestMapping("/student_out")
public class StudentOutController {

    @Autowired
    private StudentOutSservice studentOutSservice;


    @RequestMapping(value = "/getStudentOutAll", method = RequestMethod.GET)
    public @ResponseBody
    Object getStudentOutAll(String name, int c_id, String d_number, String out_time, int page, int limit) {
        retMap map = new retMap();
        String msg = "查询迁出信息成功";
        try {
            String out_time1 = null;
            if (null != out_time && !out_time.equals("")) {
                String[] time = out_time.split("至");
                out_time = time[0];
                out_time1 = time[1];
            }
            List<student_out> studentOutList = studentOutSservice.getStudentOutAll(name, out_time, out_time1, d_number, c_id, page, limit);
            int count = studentOutSservice.getCount(name, out_time, out_time1, d_number, c_id);
            map.setCount(count);
            map.setData(studentOutList);
        } catch (Exception e) {
            System.err.println("查询迁出信息失败：" + e.toString());
            msg = "查询迁出信息失败：" + e.toString();
            map.setCode(2000);
            map.setCount(0);
            map.setData(null);
        }
        map.setMsg(msg);
        return map.getMap();
    }

    /**
     * @param stu_id_list 学生id数组
     * @param d_id_list   宿舍id数组
     * @param out_reason  迁出原因
     * @param out_time    迁出时间
     * @return
     */
    @RequestMapping(value = "/OutStudents", method = RequestMethod.POST)
    public @ResponseBody
    Object OutStudents(@RequestParam(required = false, value = "stu_id_list[]") List<Integer> stu_id_list, @RequestParam(required = false, value = "d_id_list[]") List<Integer> d_id_list, String out_reason, String out_time, HttpServletRequest res) {
        retMap map = new retMap();
        String msg = "迁出失败成功";
        Boolean suce = true;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String add_time = format.format(new Date());
            List<student_out> outList = new ArrayList<>();
            user_info session_user = (user_info) res.getSession().getAttribute("user_info");
            for (int i = 0; i < stu_id_list.size(); i++) {
                student_out out = new student_out(stu_id_list.get(i), out_time, session_user.getId(), add_time, out_reason);
                outList.add(out);
            }
            studentOutSservice.saveStudentOut(outList,stu_id_list,d_id_list);
        } catch (Exception e) {

            System.err.println("迁出失败：" + e.toString());
            msg = "迁出失败：" + e.toString();
            suce = false;
        }
        map.setMsg(msg);
        map.setSuccess(suce);
        return map.getMap();
    }

    @RequestMapping(value = "/getStudentAlltoOut", method = RequestMethod.GET)
    public @ResponseBody
    Object getStudentAlltoOut(String name, int d_id, int c_id) {
        retMap map = new retMap();
        String msg = "查询未迁出学生信息";
        try {
            List<Student_info> studentInfos = studentOutSservice.getStudentAlltoOut(name, d_id, c_id);
            map.setData(studentInfos);
            map.setCount(studentInfos.size());
        } catch (Exception e) {
            System.err.println("查询未迁出学生信息失败：" + e.toString());
            msg = "查询未迁出学生信息失败：" + e.toString();
            map.setCode(2000);
            map.setCount(0);
            map.setData(null);
        }
        map.setMsg(msg);
        return map.getMap();
    }
    @RequestMapping(value = "/getDepartmentByPid", method = RequestMethod.GET)
    public @ResponseBody Object getDepartmentByPid(int sup_id){
        retMap map = new retMap();
        String msg = "获取院系详情成功";
        Boolean suec = true;
        try {
            String dep = studentOutSservice.getDepartmentByPid(sup_id);
            map.setData(dep);
        } catch (Exception e) {
            System.err.println("获取院系详情失败：" + e.toString());
            msg = "获取院系详情失败：" + e.toString();
            map.setData(null);
            suec =false;
        }
        map.setSuccess(suec);
        map.setMsg(msg);
        return map.getMap();
    }
}
