package com.carychen.springboot_mybatis.demo.dao;

import com.carychen.springboot_mybatis.demo.entity.Student_info;

import java.util.List;

public interface Student_infoMapper {
    int saveStudent(Student_info studentInfo);

    int insert(Student_info record);


    Student_info getStudentByid(String s_id_number);


    int upStudent(Student_info record);

    List<Student_info> getStudentAll(String name,int f_sex,int c_id,int page,int limit);

    int getCount(String name,int f_sex,int c_id);

    int upSaveDormitory(int d_id);

    int upDormitory(int d_id);
}