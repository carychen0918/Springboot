package com.carychen.springboot_mybatis.demo.serviceImp;

import com.carychen.springboot_mybatis.demo.dao.department_infoMapper;
import com.carychen.springboot_mybatis.demo.entity.department_info;
import com.carychen.springboot_mybatis.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chentao
 * Date by 2019-12-10
 * 无敌太寂寞
 */
@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private department_infoMapper departmentInfoMapper;

    @Override
    public List<department_info> getDepartmentAll(String name, int sup_id, int page, int limit) {
        return departmentInfoMapper.getDepartmentAll(name,sup_id,(page-1)*limit,limit);
    }

    @Override
    public int getCount(String name, int sup_id) {
        return departmentInfoMapper.getCount(name,sup_id);
    }

    @Override
    public int saveDepartment(department_info department_info) {
        return departmentInfoMapper.saveDepartment(department_info);
    }

    @Override
    public int upDepartment(department_info department_info) {
        return departmentInfoMapper.upDepartment(department_info);
    }

    @Override
    public int delDepartment(int d_id) {
        return departmentInfoMapper.delDepartment(d_id);
    }

    @Override
    public List<department_info> getDepartmentBySupid(int sup_id) {
        return departmentInfoMapper.getDepartmentBySupid(sup_id);
    }

    @Override
    public department_info getFatherDid(int sup_id) {
        return departmentInfoMapper.getFatherDid(sup_id);
    }

    @Override
    public department_info selDepartment(int sup_id, String name) {
        return departmentInfoMapper.selDepartment(sup_id,name);
    }
}
