package com.carychen.springboot_mybatis.demo.serviceImp;

import com.carychen.springboot_mybatis.demo.dao.check_sleep_infoMapper;
import com.carychen.springboot_mybatis.demo.entity.Student_info;
import com.carychen.springboot_mybatis.demo.entity.check_sleep_info;
import com.carychen.springboot_mybatis.demo.entity.dormitory_info;
import com.carychen.springboot_mybatis.demo.entity.student_check;
import com.carychen.springboot_mybatis.demo.service.CheckSleepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chentao
 * Date by 2020-01-16
 * 无敌太寂寞
 */
@Service
public class CheckSleepServiceImp implements CheckSleepService {

    @Autowired
    private check_sleep_infoMapper checkSleepInfoMapper;

    @Override
    public List<check_sleep_info> getCheckSleepInfoAll(int f_id, int d_id, String d_name, String time ,int page, int limit) {
        String time1 = "";
        String time2 = "";
        if(null !=time && time!=""){
             time1 = time.split("至")[0];
             time2 = time.split("至")[1];
        }
        return checkSleepInfoMapper.getCheckSleepInfoAll(f_id,d_id,d_name,time1,time2,page,limit);
    }

    @Override
    public int getCountCheckSleep(int f_id, int d_id, String d_name, String time) {
        String time1 = "";
        String time2 = "";
        if(null !=time && time!=""){
            time1 = time.split("至")[0];
            time2 = time.split("至")[1];
        }
        return checkSleepInfoMapper.getCountCheckSleep(f_id,d_id,d_name,time1,time2);
    }

    @Override
    @Transactional
    public int saveCheckSleepInfo(check_sleep_info record) {
        int i = checkSleepInfoMapper.saveCheckSleepInfo(record);
        System.out.println("新增id"+record.getC_id());
        return i;
    }

    @Override
    @Transactional
    public int upCheckSleepInfo(check_sleep_info record) {
        return 0;
    }

    @Override
    @Transactional
    public int saveStudentList(List<student_check> list) {
        return checkSleepInfoMapper.saveStudentList(list);
    }

    @Override
    @Transactional
    public int EmptyCheckByCid(int c_id) {
        return checkSleepInfoMapper.EmptyCheckByCid(c_id);
    }

    @Override
    public List<dormitory_info> getDormitoryByCheck(int f_id, String time) {
        return checkSleepInfoMapper.getDormitoryByCheck(f_id,time);
    }

    @Override
    public List<Student_info> getStudentByDid(int d_id) {
        return checkSleepInfoMapper.getStudentByDid(d_id);
    }

    @Override
    public List<student_check> getStudentCheckByCid(int c_id) {
        return checkSleepInfoMapper.getStudentCheckByCid(c_id);
    }
}
