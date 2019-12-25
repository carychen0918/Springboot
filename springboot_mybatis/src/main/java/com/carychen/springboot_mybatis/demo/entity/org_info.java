package com.carychen.springboot_mybatis.demo.entity;

public class org_info {
    private Integer id;

    private String codeName;

    private Integer pId;

    private Integer sysId;

    private String orgFullName;

    private String orgRemark;

    public org_info(Integer id, String codeName, Integer pId, Integer sysId, String orgFullName, String orgRemark) {
        this.id = id;
        this.codeName = codeName;
        this.pId = pId;
        this.sysId = sysId;
        this.orgFullName = orgFullName;
        this.orgRemark = orgRemark;
    }

    public org_info( String codeName, Integer pId, Integer sysId, String orgFullName, String orgRemark) {
        this.codeName = codeName;
        this.pId = pId;
        this.sysId = sysId;
        this.orgFullName = orgFullName;
        this.orgRemark = orgRemark;
    }

    public org_info() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName == null ? null : codeName.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public String getOrgFullName() {
        return orgFullName;
    }

    public void setOrgFullName(String orgFullName) {
        this.orgFullName = orgFullName == null ? null : orgFullName.trim();
    }

    public String getOrgRemark() {
        return orgRemark;
    }

    public void setOrgRemark(String orgRemark) {
        this.orgRemark = orgRemark == null ? null : orgRemark.trim();
    }
}