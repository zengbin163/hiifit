package com.hiifit.haipay.manager;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.hiifit.haipay.vo.User;
import com.hiifit.haipay.vo.UserFire;
import com.hiifit.haipay.vo.UserFireComment;
import com.hiifit.haipay.vo.UserFirePraise;
import com.hiifit.haipay.vo.UserFireStep;
import com.hiifit.haipay.vo.UserTag;

public interface UserManager {
    /***
     * 
     * <pre>
     *   返回用户基本信息
     * </pre>
     * @param userId（用户id）
     * @return id（用户id），nickName（昵称），headerUrl（头像URL），sex（性别）
     */
    User getByUserId(Integer userId);

    /***
     * 
     * <pre>
     *   返回用户基本信息
     * </pre>
     * @param deviceId（用户手机设备id）
     * @return id（用户id），nickName（昵称），headerUrl（头像URL），sex（性别）
     */
    User getUserByDeviceId(String deviceId);
    
    /**
     * 
     * <pre>
     *   注册用户
     * </pre>
     * @param user
     */
    Map<String,Object> registerUser(User user);
    
    /**
     * 
     * <pre>
     *   更新用户最新登录时间
     * </pre>
     * @param user
     * @return
     */
    Map<String,Object> updateUserLastLoginTime(User user);
    
    /***
     * <pre>
     *    更新用户基本信息
     * </pre>
     * @param userId（用户id）
     * @param nickName（昵称）
     * @param headerUrl（头像URL）
     * @param sex（性别：0女性，1男性）
     * @return 返回成功code 200
     */
    Map<String,Object> updateUserInfo(Integer userId, String nickName, String headerUrl, Integer sex);
    
    /**
     * 
     * <pre>
     *   查询以当前用户坐标为焦点方圆几公里内的怒火
     * </pre>
     * @param distance（方圆多少M，单位是M）
     * @param eastLatitude（东经坐标值）
     * @param northLatitude（北纬坐标值）
     * @return eastLatitude（东经坐标值），northLatitude（北纬坐标值），userId（怒火发表人），nickName（怒火发表人昵称），headerUrl（头像URL）
     * fireValue（怒值），fireReason（怒因），firePraiseCount（点赞数），fireStepCount（点踩数），fireComCount（评论数）
     */
    List<UserFire> fireList(BigDecimal distance, BigDecimal eastLatitude, BigDecimal northLatitude);
    
    /***
     * 
     * <pre>
     *      查询最热的前pageSize条怒怒
     * </pre>
     * @param pageOffset
     * @param pageSize
     * @return
     */
    List<UserFire> getUserFiresByPage(Integer pageOffset,Integer pageSize);
    
    /**
     * 
     * <pre>
     *      查询我发表的怒怒
     * </pre>
     * @param userId
     * @return
     */
    List<UserFire> getMyFireList(Integer userId);
    
    /***
     * 
     * <pre>
     *    发泄怒火
     * </pre>
     * @param userId（用户id）
     * @param content（内容）
     * @param imgUrl（图片URL）
     * @return 返回成功code 200
     */
    Map<String, Object> fire(UserFire userFire);
    
    /**
     * <pre>
     *    查询火焰信息 
     * </pre>
     * @param fireId
     * @return
     */
    UserFire getUserFireById(Integer fireId,Integer userId);
    
    /**
     * 
     * <pre>
     *    发表评论
     * </pre>
     * @param userId（用户id）
     * @param comment（评论内容）
     * @return 返回成功code 200
     */
    Map<String,Object> comment(UserFireComment userFireComment);
    
    /**
     * 
     * <pre>
     *   查询用户评论列表
     * </pre>
     * @param fireId（火焰d）
     * @return
     */
    List<UserFireComment> commentList(Integer fireId,Integer pageOffset,Integer pageSize);
    
    /***
     * <pre>
     *    用户点赞或者取消点赞
     * </pre>
     * @param userId（用户id）
     * @return 返回成功code 200
     */
    Map<String,Object> praise(UserFirePraise userFirePraise);

    /***
     * <pre>
     *    用户点踩或者取消点踩
     * </pre>
     * @param userId（用户id）
     * @return 返回成功code 200
     */
    Map<String,Object> step(UserFireStep userFireStep);
    
    /**
     * <pre>
     *    查询所有tag标签
     * </pre>
     * @return
     */
    List<UserTag> getAllTag();
    
    /**
     * 
     * <pre>
     *    查询我参与的怒怒
     * </pre>
     * @param userId
     * @return
     */
    List<UserFire> getUserFiresByMyInvolve(Integer userId);
}
