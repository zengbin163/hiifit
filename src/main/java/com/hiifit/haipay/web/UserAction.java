/*
 * @Project: GZJK
 * @Author: bin
 * @Date: 2015年6月19日
 * @Copyright: 2000-2015 CMCC . All rights reserved.
 */
package com.hiifit.haipay.web;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.cmcc.common.util.ParamUtil;
import com.hiifit.haipay.manager.UserManager;
import com.hiifit.haipay.util.math.CodeUtil;
import com.hiifit.haipay.util.math.FireUtil;
import com.hiifit.haipay.vo.User;
import com.hiifit.haipay.vo.UserFire;
import com.hiifit.haipay.vo.UserFireComment;
import com.hiifit.haipay.vo.UserFirePraise;
import com.hiifit.haipay.vo.UserFireStep;

/** 
* @ClassName: UserAction 
* @Description: 
* @author bin
* @date 2015年6月19日 上午11:21:51 
*/
public class UserAction extends BaseAction {
    private static final long serialVersionUID = -7879690191783260314L;
    
    @Autowired
    protected UserManager userManager;
    
    /***
     * 
     * <pre>
     *   首页接口，只需要传入一个deviceId，返回用户基本信息
     * </pre>
     * @param deviceId（用户手机设备id）
     * @return id（用户id），nickName（昵称），headerUrl（头像URL），sex（性别）
     */
    public String index() {
        String deviceId = ParamUtil.getStringParameter(request, "deviceId", null);
        Assert.notNull(deviceId);
        User user = userManager.getUserByDeviceId(deviceId);
        returnFastJSON(user);
        return null;
    }
    
    /**
     * <pre>
     *  查询基本信息
     * </pre>
     * @param userId（用户id）
     * @return id（用户id），nickName（昵称），headerUrl（头像URL），sex（性别）
     */
    public String userInfo() {
        Integer userId = ParamUtil.getIntParameter(request, "userId", null);
        Assert.notNull(userId);
        User user = userManager.getByUserId(userId);
        returnFastJSON(user);
        return null;
    }
    
    /***
     * <pre>
     *    更新用户基本信息
     * </pre>
     * @param userId（用户id）
     * @param nickName（昵称）
     * @param headerUrl（头像URL）
     * @param sex（性别：0女性，1男性）
     * @return 成功返回recode=200，失败返回recode=500
     */
    public String updateUserInfo() {
        Integer userId = ParamUtil.getIntParameter(request, "userId", null);
        Assert.notNull(userId);
        String nickName = ParamUtil.getStringParameter(request, "nickName", null);
        String headerUrl = ParamUtil.getStringParameter(request, "headerUrl", null);
        Integer sex = ParamUtil.getIntParameter(request, "sex", null);
        returnWithoutFastJSON(this.userManager.updateUserInfo(userId, nickName, headerUrl, sex));
        return null;
    }
    
    /**
     * 
     * <pre>
     *   查询以当前用户坐标为焦点方圆几公里内的怒火
     * </pre>
     * @param distance（方圆多少M，单位是M）
     * @param eastLatitude（东经坐标值）
     * @param northLatitude（北纬坐标值）
     * @return eastLatitude（东经坐标值）
     *         northLatitude（北纬坐标值）
     *         userId（怒火发表人）
     *         nickName（怒火发表人昵称）
     *         headerUrl（头像URL）
     *         fireValue（怒值）
     *         fireReason（怒因）（decoding）
     *         firePraiseCount（点赞数）
     *         fireStepCount（点踩数）
     *         fireComCount（评论数）
     *         address（来自#详细地址#）（decoding）
     */
    public String fireList() {
        String distance = ParamUtil.getStringParameter(request, "distance", null);// 地图方圆几公里内的火焰
        Assert.notNull(distance);
        String eastLatitude = ParamUtil.getStringParameter(request, "eastLatitude", null);// 东经坐标
        Assert.notNull(eastLatitude);
        String northLatitude = ParamUtil.getStringParameter(request, "northLatitude", null);// 北纬
        Assert.notNull(northLatitude);
        returnFastJSON(this.userManager.fireList(new BigDecimal(distance), new BigDecimal(
            eastLatitude), new BigDecimal(northLatitude)));
        return null;
    }
    
    /***
     * 
     * <pre>
     *    发泄怒火
     * </pre>
     * @param userId（用户id）
     * @param mapLevel（地图层级）
     * @param fireReason（内容）（encoding）
     * @param eastLatitude（东经坐标）
     * @param northLatitude（北纬坐标）
     * @param picUrl1 picUrl2 picUrl3 picUrl4（图片URL）
     * @param address（来自#详细地址#）（encoding）
     * @return 成功返回recode=200，失败抛异常
     */
    public String fire() {
        Integer userId = ParamUtil.getIntParameter(request, "userId", null);
        Assert.notNull(userId);
        Integer mapLevel = ParamUtil.getIntParameter(request, "mapLevel", null);
        Assert.notNull(mapLevel);
        String fireReason = ParamUtil.getStringParameter(request, "fireReason", null);// 输入内容
        Assert.notNull(fireReason);
        String eastLatitude = ParamUtil.getStringParameter(request, "eastLatitude", null);// 东经坐标
        Assert.notNull(eastLatitude);
        String northLatitude = ParamUtil.getStringParameter(request, "northLatitude", null);// 北纬坐标
        Assert.notNull(northLatitude);
        String picUrl1 = ParamUtil.getStringParameter(request, "picUrl1", null);
        String picUrl2 = ParamUtil.getStringParameter(request, "picUrl2", null);
        String picUrl3 = ParamUtil.getStringParameter(request, "picUrl3", null);
        String picUrl4 = ParamUtil.getStringParameter(request, "picUrl4", null);
        String address = ParamUtil.getStringParameter(request, "address", null);
        String content = CodeUtil.decode(fireReason);
        String tagIds = ParamUtil.getStringParameter(request, "tagIds", null);
        UserFire userFire = new UserFire(userId, content, FireUtil.getFireValue(content),
            DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE, new BigDecimal(eastLatitude),
            new BigDecimal(northLatitude), mapLevel, picUrl1, picUrl2, picUrl3, picUrl4,
            CodeUtil.decode(address), tagIds);
        returnWithoutFastJSON(this.userManager.fire(userFire));
        return null;
    }
    
    /**
     * <pre>
     *     根据火焰id查询火焰详情
     * </pre>
     * @param fireId（火焰id）
     * @return fireReason（怒因）
     *         fireValue（怒值）
     *         firePraiseCount（点赞数）
     *         fireStepCount（点踩数）
     *         fireComCount（评论数）
     *         eastLatitude（东经）
     *         northLatitude（北纬）
     *         userId（怒火发表人）
     *         nickName（怒火发表人昵称）
     *         headerUrl（头像URL）
     */
    public String getFire() {
        Integer fireId = ParamUtil.getIntParameter(request, "fireId", null);
        Assert.notNull(fireId);
        returnFastJSON(this.userManager.getUserFireById(fireId));
        return null;
    }
    
    /**
     * 
     * <pre>
     *    发表评论
     * </pre>
     * @param fireId（火焰id）
     * @param followerId（评论发表者id）
     * @param authorId（被评论者id）
     * @param content（评论内容）（encoding）
     * @return 返回成功code 200
     */
    public String comment() {
        Integer fireId = ParamUtil.getIntParameter(request, "fireId", null);
        Assert.notNull(fireId);
        Integer followerId = ParamUtil.getIntParameter(request, "followerId", null);
        Assert.notNull(followerId);
        Integer authorId = ParamUtil.getIntParameter(request, "authorId", null);
        Assert.notNull(authorId);
        String content = ParamUtil.getStringParameter(request, "content", null);
        Assert.notNull(content);
        UserFireComment comment = new UserFireComment(fireId, followerId, authorId,
            CodeUtil.decode(content));
        returnWithoutFastJSON(this.userManager.comment(comment));
        return null;
    }
    
    /**
     * <pre>
     *   查询用户评论列表
     * </pre>
     * @param fireId（火焰d）
     * @param pageOffset（第几页）
     * @param pageSize（每页条数）
     * @return  id   （评论id）
     *          followerId    （评论发表者id）
     *          content     （评论内容）  （decoding）
     *          createTime   （评论发表时间）
     *          eastLatitude   （东经）
     *          northLatitude   （北纬）
     *          address    （来自#详细地址） （decoding）
     *          flag    （数据标示 0 评论未被读取，1评论已被读取,2 数据被逻辑删除）
     *          nickName   （评论发表者昵称）
     *          headerUrl   （头像URL）
     *          sex    （性别：0女人，1男人）
     */
    public String commentList() {
        Integer fireId = ParamUtil.getIntParameter(request, "fireId", null);
        Assert.notNull(fireId);
        Integer pageOffset = ParamUtil.getIntParameter(request, "pageOffset", null);
        Assert.notNull(fireId);
        Integer pageSize = ParamUtil.getIntParameter(request, "pageSize", null);
        Assert.notNull(fireId);
        returnFastJSON(this.userManager.commentList(fireId, pageOffset, pageSize));
        return null;
    }
    
    /**
     * <pre>
     *  点赞
     * </pre>
     * @param fireId（火焰id）
     * @param userId（用户id）
     * @return 返回成功code 200
     */
    public String praise() {
        Integer fireId = ParamUtil.getIntParameter(request, "fireId", null);
        Assert.notNull(fireId);
        Integer userId = ParamUtil.getIntParameter(request, "userId", null);
        Assert.notNull(userId);
        UserFirePraise userFirePraise = new UserFirePraise(fireId, userId);
        returnWithoutFastJSON(this.userManager.praise(userFirePraise));
        return null;
    }
    
    /**
     * <pre>
     *  点踩
     * </pre>
     * @param fireId（火焰id）
     * @param userId（用户id）
     * @return 返回成功code 200
     */
    public String step() {
        Integer fireId = ParamUtil.getIntParameter(request, "fireId", null);
        Assert.notNull(fireId);
        Integer userId = ParamUtil.getIntParameter(request, "userId", null);
        Assert.notNull(userId);
        UserFireStep userFireStep = new UserFireStep(fireId, userId);
        returnWithoutFastJSON(this.userManager.step(userFireStep));
        return null;
    }
    
    /**
     * <pre>
     *   查询所有tag标签
     * </pre>
     * @return
     */
    public String getAllTag() {
        returnFastJSON(this.userManager.getAllTag());
        return null;
    }
}
