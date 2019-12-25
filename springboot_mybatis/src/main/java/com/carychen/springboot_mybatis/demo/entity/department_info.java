package com.carychen.springboot_mybatis.demo.entity;

public class department_info {
    private Integer d_id;

    private String d_nanem;

    private String d_teacher_name;

    private String d_teacher_phone;

    private String d_teacher_email;

    private Integer d_sup_id;

    public department_info(Integer d_id, String d_nanem, String d_teacher_name, String d_teacher_phone, String d_teacher_email, Integer d_sup_id) {
        this.d_id = d_id;
        this.d_nanem = d_nanem;
        this.d_teacher_name = d_teacher_name;
        this.d_teacher_phone = d_teacher_phone;
        this.d_teacher_email = d_teacher_email;
        this.d_sup_id = d_sup_id;
    }
    public department_info( String d_nanem, String d_teacher_name, String d_teacher_phone, String d_teacher_email, Integer d_sup_id) {
        this.d_nanem = d_nanem;
        this.d_teacher_name = d_teacher_name;
        this.d_teacher_phone = d_teacher_phone;
        this.d_teacher_email = d_teacher_email;
        this.d_sup_id = d_sup_id;
    }
    public department_info() {
        super();
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public String getD_nanem() {
        return d_nanem;
    }

    public void setD_nanem(String d_nanem) {
        this.d_nanem = d_nanem == null ? null : d_nanem.trim();
    }

    public String getD_teacher_name() {
        return d_teacher_name;
    }

    public void setD_teacher_name(String d_teacher_name) {
        this.d_teacher_name = d_teacher_name == null ? null : d_teacher_name.trim();
    }

    public String getD_teacher_phone() {
        return d_teacher_phone;
    }

    public void setD_teacher_phone(String d_teacher_phone) {
        this.d_teacher_phone = d_teacher_phone == null ? null : d_teacher_phone.trim();
    }

    public String getD_teacher_email() {
        return d_teacher_email;
    }

    public void setD_teacher_email(String d_teacher_email) {
        this.d_teacher_email = d_teacher_email == null ? null : d_teacher_email.trim();
    }

    public Integer getD_sup_id() {
        return d_sup_id;
    }

    public void setD_sup_id(Integer d_sup_id) {
        this.d_sup_id = d_sup_id;
    }
}