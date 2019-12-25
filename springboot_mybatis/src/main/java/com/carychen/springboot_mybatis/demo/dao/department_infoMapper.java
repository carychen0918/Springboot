package com.carychen.springboot_mybatis.demo.dao;

import com.carychen.springboot_mybatis.demo.entity.department_info;

import java.util.List;

public interface department_infoMapper {
    int delDepartment(Integer d_id);

    int saveDepartment(department_info record);

    department_info getDepartmentByid(Integer d_id);

    int upDepartment(department_info record);

    List<department_info> getDepartmentBySupid(int sup_id);

    List<department_info>getDepartmentAll(String name,int sup_id,int page,int limit);

    int getCount(String name,int sup_id);

    department_info getFatherDid(int sup_id);

    department_info selDepartment(int sup_id,String d_name);

}