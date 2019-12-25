package com.carychen.springboot_mybatis.demo.service;

import com.carychen.springboot_mybatis.demo.entity.department_info;

import java.util.List;

/**
 * Created by chentao
 * Date by 2019-12-10
 * 无敌太寂寞
 */
public interface DepartmentService {

    /**
     * 获取院系班列表
     * @param name 名称、教师姓名、教师电话
     * @param page
     * @param limit
     * @param sup_id 院系id
     * @return
     */
    List<department_info> getDepartmentAll(String name,int sup_id,int page,int limit);

    /**
     * 获取总行数
     * @param name
     * @param sup_id
     * @return
     */
    int getCount(String name,int sup_id);

    /**
     * 新增院系班
     * @param department_info
     * @return
     */
    int saveDepartment(department_info department_info);

    /**
     * 修改院系
     * @param department_info
     * @return
     */
    int upDepartment(department_info department_info);

    /**
     * 删除院系
     * @param d_id
     * @return
     */
    int delDepartment(int d_id);

    /**
     * 院系二、三级联动
     * @param sup_id 上级id，默认传0
     * @return
     */
    List<department_info> getDepartmentBySupid(int sup_id);

    /**
     * 获取父级
     */
    department_info getFatherDid(int sup_id);

    /**
     * 新增修改查询重复
     */
    department_info selDepartment(int sup_id,String name);
}
