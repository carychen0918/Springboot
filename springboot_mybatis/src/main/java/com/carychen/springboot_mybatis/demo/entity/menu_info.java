package com.carychen.springboot_mybatis.demo.entity;

public class menu_info {
    private Integer menuId;

    private String menuCode;

    private String menuName;

    private String menuNav;

    private String menuRemark;

    private String menuUrl;

    private Integer menuLevel;

    private Integer menuOrder;

    private Integer menuStatus;

    private Integer menuPid;

    private Integer menuHidden;

    private String menuTarget;

    private Integer menuSysid;

    public Integer getMenuSysid() {
        return menuSysid;
    }

    public void setMenuSysid(Integer menuSysid) {
        this.menuSysid = menuSysid;
    }



    public menu_info(Integer menuId, String menuCode, String menuName, String menuNav, String menuRemark, String menuUrl, Integer menuLevel, Integer menuOrder, Integer menuStatus, Integer menuPid, Integer menuHidden, String menuTarget,Integer menuSysid) {
        this.menuId = menuId;
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuNav = menuNav;
        this.menuRemark = menuRemark;
        this.menuUrl = menuUrl;
        this.menuLevel = menuLevel;
        this.menuOrder = menuOrder;
        this.menuStatus = menuStatus;
        this.menuPid = menuPid;
        this.menuHidden = menuHidden;
        this.menuTarget = menuTarget;
        this.menuSysid = menuSysid;
    }
    public menu_info(String menuCode, String menuName, String menuNav, String menuRemark, String menuUrl, Integer menuLevel, Integer menuOrder, Integer menuStatus, Integer menuPid, Integer menuHidden, String menuTarget,Integer menuSysid) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuNav = menuNav;
        this.menuRemark = menuRemark;
        this.menuUrl = menuUrl;
        this.menuLevel = menuLevel;
        this.menuOrder = menuOrder;
        this.menuStatus = menuStatus;
        this.menuPid = menuPid;
        this.menuHidden = menuHidden;
        this.menuTarget = menuTarget;
        this.menuSysid = menuSysid;
    }

    public menu_info() {
        super();
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode == null ? null : menuCode.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuNav() {
        return menuNav;
    }

    public void setMenuNav(String menuNav) {
        this.menuNav = menuNav == null ? null : menuNav.trim();
    }

    public String getMenuRemark() {
        return menuRemark;
    }

    public void setMenuRemark(String menuRemark) {
        this.menuRemark = menuRemark == null ? null : menuRemark.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public Integer getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(Integer menuStatus) {
        this.menuStatus = menuStatus;
    }

    public Integer getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(Integer menuPid) {
        this.menuPid = menuPid;
    }

    public Integer getMenuHidden() {
        return menuHidden;
    }

    public void setMenuHidden(Integer menuHidden) {
        this.menuHidden = menuHidden;
    }

    public String getMenuTarget() {
        return menuTarget;
    }

    public void setMenuTarget(String menuTarget) {
        this.menuTarget = menuTarget == null ? null : menuTarget.trim();
    }
}