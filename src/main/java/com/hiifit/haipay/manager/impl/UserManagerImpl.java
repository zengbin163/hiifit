package com.hiifit.haipay.manager.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.hiifit.haipay.dao.UserDao;
import com.hiifit.haipay.enumEntity.SexEnum;
import com.hiifit.haipay.manager.UserManager;
import com.hiifit.haipay.util.math.RandomUtil;
import com.hiifit.haipay.util.result.ResultUtil;
import com.hiifit.haipay.vo.User;
import com.hiifit.haipay.vo.UserFire;
import com.hiifit.haipay.vo.UserLogo;
import com.hiifit.haipay.vo.UserNoun;
import com.hiifit.haipay.vo.UserVerb;

@Service
public class UserManagerImpl implements UserManager {
    
    @Resource(name = "userDao")
    protected UserDao userDao;
    
    private Map<Integer, String> headerLogoMap = new HashMap<Integer, String>(); // 随机头像URL
    private Map<Integer, String> nickNameVerbMap = new HashMap<Integer, String>(); // 随机昵称动词
    private Map<Integer, String> nickNameNounMap = new HashMap<Integer, String>(); // 随机昵称名称
    
    private static final int headerBegin = 1;
    private static final int headerEnd = 10;
    private static final int verbBegin = 1;
    private static final int verbEnd = 3;
    private static final int nounBegin = 1;
    private static final int nounEnd = 3;
    
    @PostConstruct
    public void init() {
        List<UserLogo> userLogoList = this.userDao.getAllUserLogo();
        if (!CollectionUtils.isEmpty(userLogoList)) {
            for (UserLogo userLogo : userLogoList) {
                headerLogoMap.put(userLogo.getId(), userLogo.getHeaderUrl());
            }
        }
        List<UserVerb> userVerbList = this.userDao.getAllUserVerb();
        if (!CollectionUtils.isEmpty(userVerbList)) {
            for (UserVerb userVerb : userVerbList) {
                nickNameVerbMap.put(userVerb.getId(), userVerb.getVerb());
            }
        }
        List<UserNoun> userNounList = this.userDao.getAllUserNoun();
        if (!CollectionUtils.isEmpty(userNounList)) {
            for (UserNoun userNoun : userNounList) {
                nickNameNounMap.put(userNoun.getId(), userNoun.getNoun());
            }
        }
    }

    @Override
    public User getByUserId(Integer userId) {
        User user = this.userDao.getByUserId(userId);
        if(null==user){
            return null;
        }
        if(StringUtils.isEmpty(user.getHeaderUrl())){
            user.setHeaderUrl(this.headerLogoMap.get(RandomUtil.getAreaNum(headerBegin, headerEnd)));
        }
        if(StringUtils.isEmpty(user.getNickName())){
            String verb = this.nickNameVerbMap.get(RandomUtil.getAreaNum(verbBegin, verbEnd));
            String noun = this.nickNameNounMap.get(RandomUtil.getAreaNum(nounBegin, nounEnd));
            user.setNickName(verb + noun);
        }
        if(null==user.getSex()){
            user.setSex(SexEnum.getEnum(RandomUtil.getAreaNum(0, 1)).getCode());
        }
        return user;
    }

    @Override
    public Map<String, Object> updateUserInfo(Integer userId, String nickName, String headerUrl, Integer sex) {
        User user = new User(userId, nickName, headerUrl, sex);
        int flag = this.userDao.updateUserById(user);
        if(flag>0){
            return ResultUtil.successMap();
        }else{
            return ResultUtil.updateFailMap();
        }
    }

    @Override
    public List<UserFire> fireList(BigDecimal north, BigDecimal south, BigDecimal west,
                                   BigDecimal east) {
        return null;
    }

    @Override
    public Map<String, Object> fire(Integer userId, String content, String imgUrl) {
        return null;
    }

    @Override
    public Map<String, Object> comment(Integer userId, String comment) {
        return null;
    }

    @Override
    public Map<String, Object> praise(Integer userId) {
        return null;
    }

}
