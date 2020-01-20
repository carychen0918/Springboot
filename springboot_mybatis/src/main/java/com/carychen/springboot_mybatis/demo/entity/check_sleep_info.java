package com.carychen.springboot_mybatis.demo.entity;

import java.util.List;

public class check_sleep_info {
    private Integer c_id;

    private String time;

    private Integer c_state;

    private Integer u_id;

    private Integer d_id;

    private Integer true_to;

    private Integer missing;

    private String reason;

    private List<student_check> studentCheck;

    private user_info user_info;

    private dormitory_info dormitoryInfo;


    public check_sleep_info(String time, Integer c_state, Integer u_id, Integer d_id, Integer true_to, Integer missing, String reason) {
        this.time = time;
        this.c_state = c_state;
        this.u_id = u_id;
        this.d_id = d_id;
        this.true_to = true_to;
        this.missing = missing;
        this.reason = reason;
    }

    public check_sleep_info(Integer c_id, String time, Integer c_state, Integer u_id, Integer d_id, Integer true_to, Integer missing, String reason) {
        this.c_id = c_id;
        this.time = time;
        this.c_state = c_state;
        this.u_id = u_id;
        this.d_id = d_id;
        this.true_to = true_to;
        this.missing = missing;
        this.reason = reason;
    }

    public dormitory_info getDormitoryInfo() {
        return dormitoryInfo;
    }

    public void setDormitoryInfo(dormitory_info dormitoryInfo) {
        this.dormitoryInfo = dormitoryInfo;
    }

    public com.carychen.springboot_mybatis.demo.entity.user_info getUser_info() {
        return user_info;
    }

    public void setUser_info(com.carychen.springboot_mybatis.demo.entity.user_info user_info) {
        this.user_info = user_info;
    }

    public List<student_check> getStudentCheck() {
        return studentCheck;
    }

    public void setStudentCheck(List<student_check> studentCheck) {
        this.studentCheck = studentCheck;
    }

    public check_sleep_info() {
        super();
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getC_state() {
        return c_state;
    }

    public void setC_state(Integer c_state) {
        this.c_state = c_state;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public Integer getTrue_to() {
        return true_to;
    }

    public void setTrue_to(Integer true_to) {
        this.true_to = true_to;
    }

    public Integer getMissing() {
        return missing;
    }

    public void setMissing(Integer missing) {
        this.missing = missing;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}