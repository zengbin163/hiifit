package com.hiifit.haipay.vo;

import java.io.Serializable;

public class User implements Serializable {
    
    private static final long serialVersionUID = -6723648415687712333L;
    
    private Integer id;
    
    private String nickName;
    
    private String mobile;
    
    private String password;
    
    private String lastLoginTime;
    
    private String headerUrl;
    
    private Integer sex;
    
    public User() {
    }
    
    public User(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }
    
    public User(Integer userId,String nickName,String headerUrl,Integer sex){
        this.id = userId;
        this.nickName = nickName;
        this.headerUrl = headerUrl;
        this.sex = sex;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getLastLoginTime() {
        return lastLoginTime;
    }
    
    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    
    public String getNickName() {
        return nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public String getHeaderUrl() {
        return headerUrl;
    }
    
    public void setHeaderUrl(String headerUrl) {
        this.headerUrl = headerUrl;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
    
}
