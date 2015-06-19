package com.hiifit.haipay.vo;

import java.io.Serializable;
/**
 * 用户登录表
 * @author sen
 *
 */
public class User implements Serializable{
	/**
	 * 
	 */
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

	public User() {}
	
	public User(String mobile, String password) {
		this.mobile = mobile;
		this.password = password;
	}
	
	public User(String mobile, String password,String nickName) {
        this.mobile = mobile;
        this.password = password;
        this.nickName = nickName;
    }
	
	public User(Integer id,String mobile, String password,String nickName,String lastLoginTime) {
	    this.id = id;
        this.mobile = mobile;
        this.password = password;
        this.nickName = nickName;
        this.lastLoginTime = lastLoginTime;
    }
	public User(Integer id,String mobile, String password) {
        this.id = id;
        this.mobile = mobile;
        this.password = password;
    }
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the lastLoginTime
	 */
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

    public Integer getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Integer isUpdate) {
        this.isUpdate = isUpdate;
    }

}
