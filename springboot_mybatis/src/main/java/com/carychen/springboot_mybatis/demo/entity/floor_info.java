package com.carychen.springboot_mybatis.demo.entity;

public class floor_info {
    private Integer f_id;

    private String f_name;

    private Integer u_id;

    private String add_time;

    private Integer add_by;

    private String up_date;

    private Integer up_by;

    private Integer f_sex;

    private Integer f_number;

    private user_info userInfo;

    public floor_info(Integer f_id, Integer u_id, String add_time, Integer add_by, String up_date, Integer up_by, Integer f_sex, Integer f_number, String f_name) {
        this.f_id = f_id;
        this.u_id = u_id;
        this.add_time = add_time;
        this.add_by = add_by;
        this.up_date = up_date;
        this.up_by = up_by;
        this.f_sex = f_sex;
        this.f_number = f_number;
        this.f_name = f_name;
    }

    public floor_info(Integer u_id, String add_time, Integer add_by, String up_date, Integer up_by, Integer f_sex, Integer f_number, String f_name) {
        this.u_id = u_id;
        this.add_time = add_time;
        this.add_by = add_by;
        this.up_date = up_date;
        this.up_by = up_by;
        this.f_sex = f_sex;
        this.f_number = f_number;
        this.f_name = f_name;
    }

    public floor_info() {
        super();
    }

    public user_info getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(user_info userInfo) {
        this.userInfo = userInfo;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public Integer getF_id() {
        return f_id;
    }

    public void setF_id(Integer f_id) {
        this.f_id = f_id;
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

    public Integer getAdd_by() {
        return add_by;
    }

    public void setAdd_by(Integer add_by) {
        this.add_by = add_by;
    }

    public String getUp_date() {
        return up_date;
    }

    public void setUp_date(String up_date) {
        this.up_date = up_date == null ? null : up_date.trim();
    }

    public Integer getUp_by() {
        return up_by;
    }

    public void setUp_by(Integer up_by) {
        this.up_by = up_by;
    }

    public Integer getF_sex() {
        return f_sex;
    }

    public void setF_sex(Integer f_sex) {
        this.f_sex = f_sex;
    }

    public Integer getF_number() {
        return f_number;
    }

    public void setF_number(Integer f_number) {
        this.f_number = f_number;
    }
}