package com.carychen.springboot_mybatis.demo.entity;

public class Student_info {
    private Integer s_id;

    private String s_name;

    private Integer s_sex;

    private Integer c_id;

    private String s_phone;

    private String s_email;

    private String s_urgent_phone;

    private String s_urgent_name;

    private String s_urgent_address;

    private String s_id_number;

    private String s_session;

    private Integer d_id;

    private Integer s_state;

    private dormitory_info dormitoryInfo;

    private department_info departmentInfo;

    public Student_info(Integer s_id, String s_name, Integer s_sex, Integer c_id, String s_phone, String s_email, String s_urgent_phone, String s_urgent_name, String s_urgent_address, String s_id_number, String s_session, Integer d_id, Integer s_state) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_sex = s_sex;
        this.c_id = c_id;
        this.s_phone = s_phone;
        this.s_email = s_email;
        this.s_urgent_phone = s_urgent_phone;
        this.s_urgent_name = s_urgent_name;
        this.s_urgent_address = s_urgent_address;
        this.s_id_number = s_id_number;
        this.s_session = s_session;
        this.d_id = d_id;
        this.s_state = s_state;
    }
    public Student_info(String s_name, Integer s_sex, Integer c_id, String s_phone, String s_email, String s_urgent_phone, String s_urgent_name, String s_urgent_address, String s_id_number, String s_session, Integer d_id, Integer s_state) {
        this.s_name = s_name;
        this.s_sex = s_sex;
        this.c_id = c_id;
        this.s_phone = s_phone;
        this.s_email = s_email;
        this.s_urgent_phone = s_urgent_phone;
        this.s_urgent_name = s_urgent_name;
        this.s_urgent_address = s_urgent_address;
        this.s_id_number = s_id_number;
        this.s_session = s_session;
        this.d_id = d_id;
        this.s_state = s_state;
    }

    public Integer getS_state() {
        return s_state;
    }

    public void setS_state(Integer s_state) {
        this.s_state = s_state;
    }

    public dormitory_info getDormitoryInfo() {
        return dormitoryInfo;
    }

    public void setDormitoryInfo(dormitory_info dormitoryInfo) {
        this.dormitoryInfo = dormitoryInfo;
    }

    public department_info getDepartmentInfo() {
        return departmentInfo;
    }

    public void setDepartmentInfo(department_info departmentInfo) {
        this.departmentInfo = departmentInfo;
    }

    public Student_info() {
        super();
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name == null ? null : s_name.trim();
    }

    public Integer getS_sex() {
        return s_sex;
    }

    public void setS_sex(Integer s_sex) {
        this.s_sex = s_sex;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getS_phone() {
        return s_phone;
    }

    public void setS_phone(String s_phone) {
        this.s_phone = s_phone == null ? null : s_phone.trim();
    }

    public String getS_email() {
        return s_email;
    }

    public void setS_email(String s_email) {
        this.s_email = s_email == null ? null : s_email.trim();
    }

    public String getS_urgent_phone() {
        return s_urgent_phone;
    }

    public void setS_urgent_phone(String s_urgent_phone) {
        this.s_urgent_phone = s_urgent_phone == null ? null : s_urgent_phone.trim();
    }

    public String getS_urgent_name() {
        return s_urgent_name;
    }

    public void setS_urgent_name(String s_urgent_name) {
        this.s_urgent_name = s_urgent_name == null ? null : s_urgent_name.trim();
    }

    public String getS_urgent_address() {
        return s_urgent_address;
    }

    public void setS_urgent_address(String s_urgent_address) {
        this.s_urgent_address = s_urgent_address == null ? null : s_urgent_address.trim();
    }

    public String getS_id_number() {
        return s_id_number;
    }

    public void setS_id_number(String s_id_number) {
        this.s_id_number = s_id_number == null ? null : s_id_number.trim();
    }

    public String getS_session() {
        return s_session;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }


    public void setS_session(String s_session) {
        this.s_session = s_session == null ? null : s_session.trim();
    }
}