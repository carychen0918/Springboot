package com.carychen.springboot_mybatis.demo.controller;

import com.carychen.springboot_mybatis.demo.entity.*;
import com.carychen.springboot_mybatis.demo.service.CheckSleepService;
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
 * Date by 2020-01-16
 * 无敌太寂寞
 */
@Controller
@RequestMapping("/CheckSleep")
public class CheckSleepInfoController {

    @Autowired
    private CheckSleepService checkSleepService;

    @RequestMapping(value = "/getCheckSleepInfoAll",method = RequestMethod.GET)
    public @ResponseBody Object getCheckSleepInfoAll(int f_id,int d_id,String name,String time,int page,int limit){
        retMap map = new retMap();
        String msg = "查询成功";
        try{
            List<check_sleep_info> checkSleepInfoList = checkSleepService.getCheckSleepInfoAll(f_id,d_id,name,time,(page-1)*limit,limit);
            int count = checkSleepService.getCountCheckSleep(f_id,d_id,name,time);
            map.setMsg(msg);
            map.setData(checkSleepInfoList);
            map.setCount(count);
        }catch (Exception e){
            msg="查询签到列表失败："+e.toString();
            System.err.println(msg);
            map.setCode(0);
            map.setData(null);
            map.setCode(2000);
            map.setMsg(msg);
        }
        return map.getMap();
    }

    /**
     * 根据宿舍楼获取当天还未签到的宿舍
     * @param f_id
     * @return
     */
    @RequestMapping(value = "/getDormitoryByCheck",method = RequestMethod.GET)
    public @ResponseBody Object getDormitoryByCheck(int f_id){
        retMap map = new retMap();
        String msg = "查询成功";
        Boolean suc = true;
        try {
            String newTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            List<dormitory_info> dormitoryInfos = checkSleepService.getDormitoryByCheck(f_id,newTime);
            map.setData(dormitoryInfos);
        }catch (Exception e){
            msg ="宿舍联动失败："+e.toString();
            System.err.println(msg);
            suc = false;
            map.setData(null);
        }
        map.setMsg(msg);
        map.setSuccess(suc);
        return map.getMap();
    }

    @RequestMapping(value = "/getStudentByDid",method = RequestMethod.GET)
    public @ResponseBody Object getStudentByDid(int d_id){
        retMap map = new retMap();
        String msg = "获取宿舍成员成功";
        Boolean suc = true;
        try {
            List<Student_info> studentInfoList = checkSleepService.getStudentByDid(d_id);
            map.setData(studentInfoList);
        }catch (Exception e){
            msg = "获取宿舍成员失败:"+e.toString();
            suc = false;
            map.setData(null);
            System.err.println(msg);
        }
        map.setMsg(msg);
        map.setSuccess(suc);
        return map.getMap();
    }

    /**
     *
     * @param c_state 是否全到
     * @param reason 说明
     * @param d_id 寝室id
     * @param true_to 应到人数
     * @param missing 缺到学生id
     * @param actual_list 签到学生id
     * @param res
     * @return
     */
    @RequestMapping(value = "/saveCheckSleep",method = RequestMethod.POST)
    public @ResponseBody Object saveCheckSleep(int c_state,String reason,int d_id,int true_to,
                                               @RequestParam(required = false, value = "missing[]") List<Integer> missing,
                                               @RequestParam(required = false,value = "actual_list[]")List<Integer> actual_list,
                                               HttpServletRequest res){
        retMap map = new retMap();
        String msg = "签到成功";
        Boolean suc = true;
        try{
            String add_time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            int u_id = ((user_info)res.getSession().getAttribute("user_info")).getId();
            check_sleep_info saveCheckSleep = new check_sleep_info(add_time,c_state,u_id,d_id,true_to,null==missing?0:missing.size(),reason);
            int c_id = checkSleepService.saveCheckSleepInfo(saveCheckSleep);
            System.err.println("新增id"+c_id);
            if (c_id<=0){
                map.setMsg("签到失败：主表更新失败");
                map.setSuccess(false);
                return  map.getMap();
            }
            List<student_check> saveCheck = new ArrayList<>();
            for(int i=0;i<actual_list.size();i++){
                student_check studentCheck = new student_check(c_id,actual_list.get(i),0,add_time,null);
                saveCheck.add(studentCheck);
            }
            if(null !=missing){
                for(int i=0;i<missing.size();i++){
                    student_check studentCheck = new student_check(c_id,missing.get(i),1,add_time,reason);
                    saveCheck.add(studentCheck);
                }
            }
            int i = checkSleepService.saveStudentList(saveCheck);
            if(i<=0){
                map.setMsg("签到失败：附表更新失败");
                map.setSuccess(false);
                return  map.getMap();
            }
        }catch (Exception e){
            msg = "签到失败："+e.toString();
            System.err.println(msg);
            suc= false;
        }
        map.setMsg(msg);
        map.setSuccess(suc);
        return map.getMap();
    }

    @RequestMapping(value = "/getStudenCheckByCid",method = RequestMethod.GET)
    public @ResponseBody Object getStudenCheckByCid(int c_id){
        retMap map = new retMap();
        String msg = "获取签到信息成功";
        Boolean suc = true;
        try {
            List<student_check> studentCheckList = checkSleepService.getStudentCheckByCid(c_id);
            map.setData(studentCheckList);
        }catch (Exception e){
            msg ="获取签到信息失败："+e.toString();
            System.err.println(msg);
            suc= false;
            map.setData(null);
        }
        map.setMsg(msg);
        map.setSuccess(suc);
        return map.getMap();
    }
}
