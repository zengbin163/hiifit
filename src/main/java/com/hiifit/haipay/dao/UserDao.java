package com.hiifit.haipay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hiifit.haipay.vo.User;
import com.hiifit.haipay.vo.UserLogo;
import com.hiifit.haipay.vo.UserNoun;
import com.hiifit.haipay.vo.UserVerb;

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
     * <pre>
     * 查询所有的用户logo加载到缓存
     * </pre>
     * @return
     */
    public List<UserLogo> getAllUserLogo();

    /**
     * <pre>
     * 查询所有的用户昵称动词加载到缓存
     * </pre>
     * @return
     */
    public List<UserVerb> getAllUserVerb();
    
    /**
     * <pre>
     * 查询所有的用户昵称名词加载到缓存
     * </pre>
     * @return
     */
    public List<UserNoun> getAllUserNoun();
    
    /**
     * <pre>
     * 更新用户信息  
     * </pre>
     * @param user
     * @return
     */
    public int updateUserById(User user);
}
