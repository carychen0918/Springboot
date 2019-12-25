package com.carychen.springboot_mybatis.demo.entity;

public class role_menu_info {
    private Integer id;

    private Integer roleId;

    private Integer menuId;

    public role_menu_info(Integer id, Integer roleId, Integer menuId) {
        this.id = id;
        this.roleId = roleId;
        this.menuId = menuId;
    }
    public role_menu_info( Integer roleId, Integer menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }
    public role_menu_info() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}