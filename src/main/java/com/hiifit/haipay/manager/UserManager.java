package com.hiifit.haipay.manager;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.hiifit.haipay.enumEntity.SexEnum;
import com.hiifit.haipay.vo.User;
import com.hiifit.haipay.vo.UserFire;

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
     *   查询东西南北坐标范围内的怒火
     * </pre>
     * @param north（北方坐标）
     * @param south（南方坐标）
     * @param west（西方坐标）
     * @param east（东方坐标）
     * @return eastLatitude（东经坐标值），northLatitude（北纬坐标值），userId（怒火发表人），nickName（怒火发表人昵称），headerUrl（头像URL）
     * fireValue（怒值），fireReason（怒因），firePraiseCount（点赞数），fireStepCount（点踩数），fireComCount（评论数）
     */
    List<UserFire> fireList(BigDecimal north, BigDecimal south, BigDecimal west, BigDecimal east);
    
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
    Map<String,Object> fire(Integer userId,String content,String imgUrl);
    
    /**
     * 
     * <pre>
     *    发表评论
     * </pre>
     * @param userId（用户id）
     * @param comment（评论内容）
     * @return 返回成功code 200
     */
    Map<String,Object> comment(Integer userId,String comment);
    
    /***
     * <pre>
     *    用户点赞或者取消点赞
     * </pre>
     * @param userId（用户id）
     * @return 返回成功code 200
     */
    Map<String,Object> praise(Integer userId);
}
