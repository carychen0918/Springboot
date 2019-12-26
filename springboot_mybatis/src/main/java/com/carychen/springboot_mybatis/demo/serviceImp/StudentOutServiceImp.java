package com.carychen.springboot_mybatis.demo.serviceImp;

import com.carychen.springboot_mybatis.demo.dao.student_outMapper;
import com.carychen.springboot_mybatis.demo.entity.Student_info;
import com.carychen.springboot_mybatis.demo.entity.student_out;
import com.carychen.springboot_mybatis.demo.service.StudentOutSservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chentao
 * Date by 2019-12-20
 * 无敌太寂寞
 */
@Service
public class StudentOutServiceImp implements StudentOutSservice {

    @Autowired
    private student_outMapper studentOutMapper;

    @Override
    public int delStudentOut(student_out record) {
        return 0;
    }

    @Override
    public student_out getStudentOutByid(Integer o_id) {
        return null;
    }

    @Override
    public int upStudentOut(Integer o_id) {
        return 0;
    }

    @Override
    @Transactional
    public int saveStudentOut(List<student_out> list,List<Integer> sid_list,List<Integer> d_id) {
        int i =studentOutMapper.saveStudentOut(list);
        for(int j=0;j<d_id.size();j++){
            studentOutMapper.upDormitoryByid(d_id.get(j),1);
        }
        studentOutMapper.upStudentoutByidlist(sid_list);
        return i;
    }

    @Override
    public List<student_out> getStudentOutAll(String name, String out_time, String out_time1, String d_number, int c_id, int page, int limit) {
        return studentOutMapper.getStudentOutAll(name,out_time,out_time1,d_number,c_id,(page-1)*limit,limit);
    }

    @Override
    public int getCount(String name, String out_time, String out_time1, String d_number, int c_id) {
        return studentOutMapper.getCountStuout(name,out_time,out_time1,d_number,c_id);
    }

    @Override
    public int getCountStuout(String name, String out_time, String out_time1, String d_number,int c_id) {
        return studentOutMapper.getCountStuout(name,out_time,out_time1,d_number,c_id);
    }

    @Override
    public List<Student_info> getStudentAlltoOut(String name, int d_id, int c_id){
        return studentOutMapper.getStudentAlltoOut(name,d_id,c_id);
    }

    @Override
    public String getDepartmentByPid(int sup_id) {
        return studentOutMapper.getDepartmentByPid(sup_id);
    }
}
