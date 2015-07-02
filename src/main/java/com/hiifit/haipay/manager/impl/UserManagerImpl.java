package com.hiifit.haipay.manager.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.hiifit.haipay.dao.UserDao;
import com.hiifit.haipay.enumEntity.FlagEnum;
import com.hiifit.haipay.enumEntity.ReturnCodeEnum;
import com.hiifit.haipay.enumEntity.SexEnum;
import com.hiifit.haipay.manager.UserManager;
import com.hiifit.haipay.util.map.MapUtil;
import com.hiifit.haipay.util.math.CodeUtil;
import com.hiifit.haipay.util.math.RandomUtil;
import com.hiifit.haipay.util.result.ResultUtil;
import com.hiifit.haipay.vo.User;
import com.hiifit.haipay.vo.UserFire;
import com.hiifit.haipay.vo.UserFireComment;
import com.hiifit.haipay.vo.UserFirePraise;
import com.hiifit.haipay.vo.UserFireStep;
import com.hiifit.haipay.vo.UserFireTag;
import com.hiifit.haipay.vo.UserLogo;
import com.hiifit.haipay.vo.UserNoun;
import com.hiifit.haipay.vo.UserTag;
import com.hiifit.haipay.vo.UserVerb;

@Service
public class UserManagerImpl implements UserManager {
    
    @Resource(name = "userDao")
    protected UserDao userDao;
    
    private Map<Integer, String> headerLogoMap = new HashMap<Integer, String>(); // 随机头像URL
    private Map<Integer, String> nickNameVerbMap = new HashMap<Integer, String>(); // 随机昵称动词
    private Map<Integer, String> nickNameNounMap = new HashMap<Integer, String>(); // 随机昵称名称
    private Map<Integer, String> tagNameMap = new HashMap<Integer, String>(); // 怒火心情的标签
    
    private static final int headerBegin = 1;
    private static final int headerEnd = 7;
    private static final int verbBegin = 1;
    private static final int verbEnd = 192;
    private static final int nounBegin = 1;
    private static final int nounEnd = 77;

    private static final String FROM = "来自 # ";
    private static final String DOT = ",";
    
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
        List<UserTag> userTagList = this.userDao.getAllUserTag();
        if (!CollectionUtils.isEmpty(userTagList)) {
            for (UserTag userTag : userTagList) {
                tagNameMap.put(userTag.getId(), userTag.getTagName());
            }
        }
    }
    
    @Override
    public User getByUserId(Integer userId) {
        User user = this.userDao.getByUserId(userId);
        if (null == user) {
            return null;
        }
        if (StringUtils.isEmpty(user.getHeaderUrl())) {
            user.setHeaderUrl(this.headerLogoMap.get(RandomUtil.getAreaNum(headerBegin, headerEnd)));
        }
        if (StringUtils.isEmpty(user.getNickName())) {
            String verb = this.nickNameVerbMap.get(RandomUtil.getAreaNum(verbBegin, verbEnd));
            String noun = this.nickNameNounMap.get(RandomUtil.getAreaNum(nounBegin, nounEnd));
            user.setNickName(verb + noun);
        }
        if (null == user.getSex()) {
            user.setSex(SexEnum.getEnum(RandomUtil.getAreaNum(0, 1)).getCode());
        }
        return user;
    }
    
    @Override
    public User getUserByDeviceId(String deviceId){
        return this.userDao.getUserByDeviceId(deviceId);
    }
    
    @Override
    public Map<String,Object> registerUser(User user){
        this.userDao.insertUser(user);
        return ResultUtil.successMap();
    }
    
    @Override
    public Map<String,Object> updateUserLastLoginTime(User user){
        this.userDao.updateUserById(user);
        return ResultUtil.successMap();
    }
    
    @Override
    public Map<String, Object> updateUserInfo(Integer userId, String nickName, String headerUrl,
                                              Integer sex) {
        User user = new User(userId, nickName, headerUrl, sex);
        int flag = this.userDao.updateUserById(user);
        if (flag > 0) {
            return ResultUtil.successMap();
        } else {
            return ResultUtil.failMap(ReturnCodeEnum.UPDATE_FAIL);
        }
    }
    
    @Override
    public List<UserFire> fireList(BigDecimal distance, BigDecimal eastLatitude,
                                   BigDecimal northLatitude) {
        Map<String, Object> map = MapUtil.getAround(eastLatitude.toString(), northLatitude.toString(), distance.toString());
        double minLat = (double)map.get("minLat");
        double maxLat = (double)map.get("maxLat");
        double minLng = (double)map.get("minLng");
        double maxLng = (double)map.get("maxLng");
        List<UserFire> list = this.userDao.getUserFiresByLatitude(minLat, maxLat, minLng, maxLng);
        if(CollectionUtils.isEmpty(list)){
            list = this.userDao.getUserFiresByPage(0, 10);//兜底用，如果当前用户坐标没数据就返回最热门的数据
        }
        List<UserFire> enList = new ArrayList<UserFire>();
        for(UserFire uf : list){
            String content = CodeUtil.encode(uf.getFireReason());
            uf.setFireReason(content);
            String address = CodeUtil.encode(FROM + uf.getAddress());
            uf.setAddress(address);
            enList.add(uf);
        }
        return enList;
    }
    
    @Override
    public Map<String, Object> fire(UserFire userFire) {
        Integer fireId = this.userDao.insertUserFire(userFire);
        if(!StringUtils.isEmpty(userFire.getTagIds())){
            String []ids = userFire.getTagIds().split(DOT);
            for(String tagId:ids){
                UserFireTag userFireTag = new UserFireTag(fireId, Integer.parseInt(tagId));
                userDao.insertUserFireTag(userFireTag);
            }
        }
        return ResultUtil.successMap();
    }
    
    @Override
    public UserFire getUserFireById(Integer fireId){
        UserFire userFire = this.userDao.getUserFireById(fireId);
        if(null!=userFire){
            userFire.setTagList(this.userDao.getFireTagsByFireId(fireId));
        }
        return userFire;
    }
    
    @Override
    public Map<String, Object> comment(UserFireComment userFireComment) {
        this.userDao.insertUserFireComment(userFireComment);
        UserFire userFire = this.userDao.getUserFireById(userFireComment.getFireId());
        Assert.notNull(userFire);
        int version = userFire.getVersion() + 1;
        int comm = userFire.getFireComCount() + 1;
        userFire.setVersion(version);
        userFire.setFireComCount(comm);
        userFire.setCommentIsolation(true);
        this.userDao.updateUserFireCountById(userFire);
        return ResultUtil.successMap();
    }
    
    @Override
    public List<UserFireComment> commentList(Integer fireId,Integer pageOffset,Integer pageSize){
        List<UserFireComment> list = this.userDao.getUserFireCommentsByPage(fireId,pageOffset,pageSize);
        if(!CollectionUtils.isEmpty(list)){
            List<UserFireComment> enList = new ArrayList<UserFireComment>();
            for(UserFireComment ufc : list){
                String comment = CodeUtil.encode(ufc.getContent());
                ufc.setContent(comment);
                String address = CodeUtil.encode(FROM + ufc.getAddress());
                ufc.setAddress(address);
                enList.add(ufc);
            }
            return enList;
        }
        return list;
    }
    
    @Override
    public Map<String, Object> praise(UserFirePraise userFirePraise) {
        UserFirePraise ufp= this.userDao.getUserFirePraiseByFireId(userFirePraise.getFireId(), userFirePraise.getUserId());
        UserFire userFire = this.userDao.getUserFireById(userFirePraise.getFireId());
        Assert.notNull(userFire);
        if(null==ufp){
            this.userDao.insertUserFirePraise(userFirePraise);
            increasePraise(userFire);
        }else{
            int flag = ufp.getFlag();
            if(FlagEnum.BE_DELETED.getCode().equals(flag)){
                flag = FlagEnum.BE_READED.getCode();
                increasePraise(userFire);
            }else{
                flag = FlagEnum.BE_DELETED.getCode();
                decreasePraise(userFire);
            }
            userFirePraise.setFlag(flag);
            this.userDao.updateUserFirePraiseByFireId(userFirePraise);
        }
        return ResultUtil.successMap();
    }

    @Override
    public Map<String, Object> step(UserFireStep userFireStep) {
        UserFirePraise ufp= this.userDao.getUserFirePraiseByFireId(userFireStep.getFireId(), userFireStep.getUserId());
        UserFire userFire = this.userDao.getUserFireById(userFireStep.getFireId());
        Assert.notNull(userFire);
        if(null==ufp){
            this.userDao.insertUserFireStep(userFireStep);
            increaseStep(userFire);
        }else{
            int flag = ufp.getFlag();
            if(FlagEnum.BE_DELETED.getCode().equals(flag)){
                flag = FlagEnum.BE_READED.getCode();
                increaseStep(userFire);
            }else{
                flag = FlagEnum.BE_DELETED.getCode();
                decreaseStep(userFire);
            }
            userFireStep.setFlag(flag);
            this.userDao.updateUserFireStepByFireId(userFireStep);
        }
        return ResultUtil.successMap();
    }
    
    public Map<Integer,String> getAllTag(){
        return this.tagNameMap;
    }
    
    private void increasePraise(UserFire userFire){
        int version = userFire.getVersion() + 1;
        int praise = userFire.getFirePraiseCount() + 1;
        userFire.setVersion(version);
        userFire.setFirePraiseCount(praise);
        userFire.setPraiseIsolation(true);
        this.userDao.updateUserFireCountById(userFire);
    }
    
    private void  decreasePraise(UserFire userFire){
        int version = userFire.getVersion() + 1;
        int praise = userFire.getFirePraiseCount()>0?userFire.getFirePraiseCount() - 1:userFire.getFirePraiseCount();
        userFire.setVersion(version);
        userFire.setFirePraiseCount(praise);
        userFire.setPraiseIsolation(true);
        this.userDao.updateUserFireCountById(userFire);
    }
    
    private void increaseStep(UserFire userFire){
        int version = userFire.getVersion() + 1;
        int Step = userFire.getFireStepCount() + 1;
        userFire.setVersion(version);
        userFire.setFireStepCount(Step);
        userFire.setStepIsolation(true);
        this.userDao.updateUserFireCountById(userFire);
    }
    
    private void  decreaseStep(UserFire userFire){
        int version = userFire.getVersion() + 1;
        int Step = userFire.getFireStepCount()>0?userFire.getFireStepCount()-1:userFire.getFireStepCount();
        userFire.setVersion(version);
        userFire.setFireStepCount(Step);
        userFire.setStepIsolation(true);
        this.userDao.updateUserFireCountById(userFire);
    }
    
}
