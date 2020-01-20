package com.carychen.springboot_mybatis.demo.entity;

public class student_check {
    private Integer id;

    private Integer c_id;

    private Integer s_id;

    private Integer s_state;

    private String add_time;

    private String reason;


    private Student_info studentInfo;

    public student_check( Integer c_id, Integer s_id, Integer s_state, String add_time, String reason) {
        this.c_id = c_id;
        this.s_id = s_id;
        this.s_state = s_state;
        this.add_time = add_time;
        this.reason = reason;
    }

    public student_check(Integer id, Integer c_id, Integer s_id, Integer s_state, String add_time, String reason) {
        this.id = id;
        this.c_id = c_id;
        this.s_id = s_id;
        this.s_state = s_state;
        this.add_time = add_time;
        this.reason = reason;
    }
    public Student_info getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(Student_info studentInfo) {
        this.studentInfo = studentInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getS_state() {
        return s_state;
    }

    public void setS_state(Integer s_state) {
        this.s_state = s_state;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time == null ? null : add_time.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}