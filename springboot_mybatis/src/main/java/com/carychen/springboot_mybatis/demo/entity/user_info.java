package com.carychen.springboot_mybatis.demo.entity;

public class user_info {
    private Integer id;

    private String userName;

    private String userLogin;

    private String loginPassword;

    private Integer userStatus;

    private Integer userOrg;

    private String userPhone;

    private String userRemark;

    private Integer userSex;

    private String userEmail;

    private Integer userSys;

    private Integer roleId;

    private String userOn;

    public user_info(){super();}

    public user_info(Integer id, String userName, String userLogin, String loginPassword, Integer userStatus, Integer userOrg, String userPhone, String userRemark, Integer userSex, String userEmail, Integer userSys, Integer roleId, String userOn) {
        this.id = id;
        this.userName = userName;
        this.userLogin = userLogin;
        this.loginPassword = loginPassword;
        this.userStatus = userStatus;
        this.userOrg = userOrg;
        this.userPhone = userPhone;
        this.userRemark = userRemark;
        this.userSex = userSex;
        this.userEmail = userEmail;
        this.userSys = userSys;
        this.roleId = roleId;
        this.userOn = userOn;
    }
    public user_info(Integer id,String loginPassword){
        this.id = id;
        this.loginPassword = loginPassword;
    }
    public user_info(Integer id,int userStatus){
        this.id = id;
        this.userStatus = userStatus;
    }
    public user_info( String userName, String userLogin, String loginPassword, Integer userStatus, Integer userOrg, String userPhone, String userRemark, Integer userSex, String userEmail, Integer userSys, Integer roleId, String userOn) {
        this.userName = userName;
        this.userLogin = userLogin;
        this.loginPassword = loginPassword;
        this.userStatus = userStatus;
        this.userOrg = userOrg;
        this.userPhone = userPhone;
        this.userRemark = userRemark;
        this.userSex = userSex;
        this.userEmail = userEmail;
        this.userSys = userSys;
        this.roleId = roleId;
        this.userOn = userOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin == null ? null : userLogin.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserOrg() {
        return userOrg;
    }

    public void setUserOrg(Integer userOrg) {
        this.userOrg = userOrg;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark == null ? null : userRemark.trim();
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Integer getUserSys() {
        return userSys;
    }

    public void setUserSys(Integer userSys) {
        this.userSys = userSys;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUserOn() {
        return userOn;
    }

    public void setUserOn(String userOn) {
        this.userOn = userOn == null ? null : userOn.trim();
    }
}