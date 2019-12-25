package com.carychen.springboot_mybatis.demo.entity;

public class role_info {
    private Integer id;

    private String roleCode;

    private String roleName;

    private Integer roleState;

    private Integer sysId;

    private Integer roleOrder;

    private String roleRemark;

    public role_info(String roleCode, String roleName, Integer roleState, Integer sysId, Integer roleOrder, String roleRemark) {
        this.roleCode = roleCode;
        this.roleName = roleName;
        this.roleState = roleState;
        this.sysId = sysId;
        this.roleOrder = roleOrder;
        this.roleRemark = roleRemark;
    }
    public role_info(Integer id,String roleCode, String roleName, Integer roleState, Integer sysId, Integer roleOrder, String roleRemark) {
        this.id=id;
        this.roleCode = roleCode;
        this.roleName = roleName;
        this.roleState = roleState;
        this.sysId = sysId;
        this.roleOrder = roleOrder;
        this.roleRemark = roleRemark;
    }


    public role_info() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Integer getRoleState() {
        return roleState;
    }

    public void setRoleState(Integer roleState) {
        this.roleState = roleState;
    }

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public Integer getRoleOrder() {
        return roleOrder;
    }

    public void setRoleOrder(Integer roleOrder) {
        this.roleOrder = roleOrder;
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark == null ? null : roleRemark.trim();
    }
}