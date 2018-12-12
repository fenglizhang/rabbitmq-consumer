package com.zlf.bo;

import java.util.Date;

public class UserBo {
    private String userid;

    private String pwd;

    private String username;

    private String sex;

    private Date birth;

    private String education;

    private String phone;

    private String status;

    private String userlevle;

    private String enabled;

    private String managecom;

    private String salecom;

    private Date createtime;

    private String createpeople;

    private Date edittime;

    private String editpeople;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getUserlevle() {
        return userlevle;
    }

    public void setUserlevle(String userlevle) {
        this.userlevle = userlevle == null ? null : userlevle.trim();
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled == null ? null : enabled.trim();
    }

    public String getManagecom() {
        return managecom;
    }

    public void setManagecom(String managecom) {
        this.managecom = managecom == null ? null : managecom.trim();
    }

    public String getSalecom() {
        return salecom;
    }

    public void setSalecom(String salecom) {
        this.salecom = salecom == null ? null : salecom.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreatepeople() {
        return createpeople;
    }

    public void setCreatepeople(String createpeople) {
        this.createpeople = createpeople == null ? null : createpeople.trim();
    }

    public Date getEdittime() {
        return edittime;
    }

    public void setEdittime(Date edittime) {
        this.edittime = edittime;
    }

    public String getEditpeople() {
        return editpeople;
    }

    public void setEditpeople(String editpeople) {
        this.editpeople = editpeople == null ? null : editpeople.trim();
    }
}