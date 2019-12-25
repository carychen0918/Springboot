package com.carychen.springboot_mybatis.demo.service;

import com.carychen.springboot_mybatis.demo.entity.Student_info;

import java.util.List;

/**
 * Created by chentao
 * Date by 2019-12-17
 * 无敌太寂寞
 */
public interface StudentService {
    List<Student_info> getStudentAll(String name,int f_sex,int c_id,int page,int limit);

    int getCount(String name,int f_sex,int c_id);

    int saveStudent(Student_info studentInfo);

    int upStudent(Student_info studentInfo,int d_id);

    int delStudent(int s_id);

    int MoveStudent(int s_id);

    Student_info getStuBySnumber(String s_id_number);
    /**
     * 减
     * @param d_id
     * @return
     */
    int upDormitory(int d_id);

    /**
     * 加
     * @param d_id
     * @return
     */
    int upSaveDormitory(int d_id);
}
