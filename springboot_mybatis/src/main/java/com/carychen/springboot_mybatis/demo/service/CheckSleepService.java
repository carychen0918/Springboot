package com.carychen.springboot_mybatis.demo.service;

import com.carychen.springboot_mybatis.demo.entity.Student_info;
import com.carychen.springboot_mybatis.demo.entity.check_sleep_info;
import com.carychen.springboot_mybatis.demo.entity.dormitory_info;
import com.carychen.springboot_mybatis.demo.entity.student_check;

import java.util.List;

/**
 * Created by chentao
 * Date by 2020-01-16
 * 无敌太寂寞
 */
public interface CheckSleepService {

    List<check_sleep_info> getCheckSleepInfoAll(int f_id,int d_id,String d_name,String time,int page,int limit);

    int getCountCheckSleep(int f_id,int d_id,String d_name,String time);

    int saveCheckSleepInfo(check_sleep_info record);

    int upCheckSleepInfo(check_sleep_info record);

    int saveStudentList(List<student_check> list);

    int EmptyCheckByCid(int c_id);

    List<dormitory_info> getDormitoryByCheck(int f_id,String time);

    List<Student_info> getStudentByDid(int d_id);

    List<student_check> getStudentCheckByCid(int c_id);
}
