package com.carychen.springboot_mybatis.demo.dao;

import com.carychen.springboot_mybatis.demo.entity.student_out;

import java.util.List;

public interface student_outMapper {
    int delStudentOut(student_out record);

    student_out getStudentOutByid(Integer o_id);

    int upStudentOut(Integer o_id);

    int saveStudentOut(List<student_out> list);

    int upStudentoutByidlist(List<Integer> list);

    int upDormitoryByid(int d_id,int index);

    List<student_out> getStudentOutAll(String name,String out_time,String out_time1,String d_number,int c_id,int page,int limit);

    int getCountStuout(String name,String out_time,String out_time1,String d_number,int c_id);
}