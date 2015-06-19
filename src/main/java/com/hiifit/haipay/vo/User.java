package com.hiifit.haipay.vo;

import java.io.Serializable;

import com.hiifit.haipay.enumEntity.SexEnum;

/**
 * 用户登录表
 * @author sen
 *
 */
public class User implements Serializable {
    
    private static final long serialVersionUID = -6723648415687712333L;
    
    /**
     * 用户ID
     */
    private Integer id;
    
    /**
     * 昵称
     */
    private String nickName;
    
    /**
     * 用户手机号
     */
    private String mobile;
    
    /**
     * 登录密码
     */
    private String password;
    
    /**
     * 上次登录时间
     */
    private String lastLoginTime;
    
    /**
     * 是否需要更新敏感词
     */
    private Integer isUpdate;
    
    private String headerUrl;
    
    private SexEnum sex;
    
    public User() {
    }
    
    public User(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
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
    
    public Integer getIsUpdate() {
        return isUpdate;
    }
    
    public void setIsUpdate(Integer isUpdate) {
        this.isUpdate = isUpdate;
    }
    
    public String getHeaderUrl() {
        return headerUrl;
    }
    
    public void setHeaderUrl(String headerUrl) {
        this.headerUrl = headerUrl;
    }
    
    public SexEnum getSex() {
        return sex;
    }
    
    public void setSex(SexEnum sex) {
        this.sex = sex;
    }
    
}
