package com.carychen.springboot_mybatis.demo.serviceImp;

import com.carychen.springboot_mybatis.demo.dao.Student_infoMapper;
import com.carychen.springboot_mybatis.demo.entity.Student_info;
import com.carychen.springboot_mybatis.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chentao
 * Date by 2019-12-17
 * 无敌太寂寞
 */
@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private Student_infoMapper studentInfoMapper;
    @Override
    public List<Student_info> getStudentAll(String name, int f_sex, int c_id, int page, int limit) {
        return studentInfoMapper.getStudentAll(name,f_sex,c_id,(page-1)*limit,limit);
    }

    @Override
    public int getCount(String name, int f_sex, int c_id) {
        return studentInfoMapper.getCount(name,f_sex,c_id);
    }

    @Override
    @Transactional
    public int saveStudent(Student_info studentInfo) {
        int i =studentInfoMapper.upSaveDormitory(studentInfo.getD_id());
        int j = studentInfoMapper.saveStudent(studentInfo);
        return j>0&&i>0?1:0;
    }

    @Override
    @Transactional
    public int upStudent(Student_info studentInfo,int d_id) {
        int k = studentInfoMapper.upDormitory(d_id);
        int j = studentInfoMapper.upSaveDormitory(studentInfo.getD_id());
        int l = studentInfoMapper.upStudent(studentInfo);
        return l;
    }

    @Override
    public int delStudent(int s_id) {
        return 0;
    }

    @Override
    public int MoveStudent(int s_id) {
        return 0;
    }

    @Override
    public Student_info getStuBySnumber(String s_id_number) {
        return studentInfoMapper.getStudentByid(s_id_number);
    }

    @Override
    @Transactional
    public int upDormitory(int d_id) {
        return studentInfoMapper.upDormitory(d_id);
    }

    @Override
    @Transactional
    public int upSaveDormitory(int d_id) {
        return studentInfoMapper.upSaveDormitory(d_id);
    }
}
