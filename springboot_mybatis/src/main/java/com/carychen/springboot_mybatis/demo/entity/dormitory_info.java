package com.carychen.springboot_mybatis.demo.entity;

public class dormitory_info {
    private Integer d_id;

    private Integer f_id;

    private Integer max_number;

    private String d_number;

    private Integer current_number;

    private floor_info floorInfo;

    public dormitory_info(Integer d_id, Integer f_id, Integer max_number, String d_number, Integer current_number) {
        this.d_id = d_id;
        this.f_id = f_id;
        this.max_number = max_number;
        this.d_number = d_number;
        this.current_number = current_number;
    }
    public dormitory_info(Integer f_id, Integer max_number, String d_number, Integer current_number) {
        this.f_id = f_id;
        this.max_number = max_number;
        this.d_number = d_number;
        this.current_number = current_number;
    }

    public floor_info getFloorInfo() {
        return floorInfo;
    }

    public void setFloorInfo(floor_info floorInfo) {
        this.floorInfo = floorInfo;
    }

    public dormitory_info() {
        super();
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public Integer getF_id() {
        return f_id;
    }

    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }

    public Integer getMax_number() {
        return max_number;
    }

    public void setMax_number(Integer max_number) {
        this.max_number = max_number;
    }

    public String getD_number() {
        return d_number;
    }

    public void setD_number(String d_number) {
        this.d_number = d_number == null ? null : d_number.trim();
    }

    public Integer getCurrent_number() {
        return current_number;
    }

    public void setCurrent_number(Integer current_number) {
        this.current_number = current_number;
    }
}