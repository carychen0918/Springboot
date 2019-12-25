package com.carychen.springboot_mybatis.demo.entity;

public class system_info {
    private Integer id;

    private String sysCode;

    private String sysName;

    private String sysUrl;

    private String sysMainUrl;

    private Integer sysStatus;

    private String sysRemark;

    public system_info(Integer id, String sysCode, String sysName, String sysUrl, String sysMainUrl, Integer sysStatus, String sysRemark) {
        this.id = id;
        this.sysCode = sysCode;
        this.sysName = sysName;
        this.sysUrl = sysUrl;
        this.sysMainUrl = sysMainUrl;
        this.sysStatus = sysStatus;
        this.sysRemark = sysRemark;
    }
    public system_info(String sysCode, String sysName, String sysUrl, String sysMainUrl, Integer sysStatus, String sysRemark) {
        this.id = id;
        this.sysCode = sysCode;
        this.sysName = sysName;
        this.sysUrl = sysUrl;
        this.sysMainUrl = sysMainUrl;
        this.sysStatus = sysStatus;
        this.sysRemark = sysRemark;
    }

    public system_info() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode == null ? null : sysCode.trim();
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName == null ? null : sysName.trim();
    }

    public String getSysUrl() {
        return sysUrl;
    }

    public void setSysUrl(String sysUrl) {
        this.sysUrl = sysUrl == null ? null : sysUrl.trim();
    }

    public String getSysMainUrl() {
        return sysMainUrl;
    }

    public void setSysMainUrl(String sysMainUrl) {
        this.sysMainUrl = sysMainUrl == null ? null : sysMainUrl.trim();
    }

    public Integer getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(Integer sysStatus) {
        this.sysStatus = sysStatus;
    }

    public String getSysRemark() {
        return sysRemark;
    }

    public void setSysRemark(String sysRemark) {
        this.sysRemark = sysRemark == null ? null : sysRemark.trim();
    }

    @Override
    public String toString() {
        return  "id:"+id+"sysCode:"+sysCode+"sysName:"+sysName+"sysUrl:"+sysUrl+"sysMainUrl:"+sysMainUrl+"sysStatus:"+sysStatus+"sysRemark:"+sysRemark;
    }
}