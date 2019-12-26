package com.carychen.springboot_mybatis.demo.entity;

public class student_out {
    private Integer o_id;

    private Integer s_id;

    private String out_time;

    private Integer u_id;

    private String add_time;

    private String out_reason;

    private Student_info student_info;

    private user_info user_info;

    public student_out(Integer s_id, String out_time, Integer u_id, String add_time,String out_reason) {
        this.s_id = s_id;
        this.out_time = out_time;
        this.u_id = u_id;
        this.add_time = add_time;
        this.out_reason = out_reason;
    }

    public student_out(Integer o_id, Integer s_id, String out_time, Integer u_id, String add_time, String out_reason) {
        this.o_id = o_id;
        this.s_id = s_id;
        this.out_time = out_time;
        this.u_id = u_id;
        this.add_time = add_time;
        this.out_reason = out_reason;
    }

    public student_out() {
        super();
    }

    public Student_info getStudent_info() {
        return student_info;
    }

    public void setStudent_info(Student_info student_info) {
        this.student_info = student_info;
    }

    public com.carychen.springboot_mybatis.demo.entity.user_info getUser_info() {
        return user_info;
    }

    public void setUser_info(com.carychen.springboot_mybatis.demo.entity.user_info user_info) {
        this.user_info = user_info;
    }

    public Integer getO_id() {
        return o_id;
    }

    public void setO_id(Integer o_id) {
        this.o_id = o_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getOut_time() {
        return out_time;
    }

    public void setOut_time(String out_time) {
        this.out_time = out_time == null ? null : out_time.trim();
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time == null ? null : add_time.trim();
    }

    public String getOut_reason() {
        return out_reason;
    }

    public void setOut_reason(String out_reason) {
        this.out_reason = out_reason == null ? null : out_reason.trim();
    }
}