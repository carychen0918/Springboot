package com.carychen.springboot_mybatis.demo.service;

import com.carychen.springboot_mybatis.demo.entity.Student_info;
import com.carychen.springboot_mybatis.demo.entity.student_out;

import java.util.List;

/**
 * Created by chentao
 * Date by 2019-12-20
 * 无敌太寂寞
 */
public interface StudentOutSservice {
    int delStudentOut(student_out record);

    student_out getStudentOutByid(Integer o_id);

    int upStudentOut(Integer o_id);

    /**
     *
     * @param list 迁出学生数组
     * @param sid_list 学生id
     * @param d_id 宿舍id
     * @return
     */
    int saveStudentOut(List<student_out> list,List<Integer> sid_list,List<Integer> d_id);

    /**
     *
     * @param name 学生姓名/学号
     * @param out_time 大于的时间
     * @param out_time1 小于的时间
     * @param d_number 寝室号
     * @param c_id 院系班
     * @param page 当前页
     * @param limit 单页行数
     * @return
     */
    List<student_out> getStudentOutAll(String name,String out_time,String out_time1,String d_number,int c_id,int page,int limit);
    /**
     *
     * @param name 学生姓名/学号
     * @param out_time 大于的时间
     * @param out_time1 小于的时间
     * @param d_number 寝室号
     * @param c_id 院系班
     * @return
     */
    int getCount(String name,String out_time,String out_time1,String d_number,int c_id);

    int getCountStuout(String name,String out_time,String out_time1,String d_number,int c_id);

    List<Student_info> getStudentAlltoOut(String name, int d_id, int c_id);

    String getDepartmentByPid(int sup_id);
}
