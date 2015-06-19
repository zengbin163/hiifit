package com.hiifit.haipay.dao;

import org.apache.ibatis.annotations.Param;

import com.hiifit.haipay.vo.User;

/**
 * 用户登录操作DAO
 * @author sen
 *
 */
public interface UserDao extends IBaseDao<User> {
    
    /**
     * 查询用户
     * @param userId
     * @return
     */
    public User getByUserId(@Param(value = "userId") Integer userId);
    
    /**
     * 删除用户（只修改用户状态为删除状态）
     * @param userId
     */
    public void deleteById(@Param(value = "userId") Integer userId);
    
    /***
     * 用户注册
     * @param user
     * @return
     */
    public int insert(User user);
    
}
