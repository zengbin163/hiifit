package com.hiifit.haipay.manager.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hiifit.haipay.dao.UserDao;
import com.hiifit.haipay.manager.UserManager;
import com.hiifit.haipay.vo.User;

@Service
public class UserManagerImpl implements UserManager {
    
    @Resource(name = "userDao")
    protected UserDao userDao;
    
    public User getByUserId(Integer userId) {
        return this.userDao.getByUserId(userId);
    }
}
