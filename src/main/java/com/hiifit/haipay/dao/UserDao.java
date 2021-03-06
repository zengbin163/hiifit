package com.hiifit.haipay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
     * 查询用户
     * @param deviceId
     * @return
     */
    public User getUserByDeviceId(@Param(value = "deviceId") String deviceId);
    
    /**
     * 
     * <pre>
     *  新增注册用户 
     * </pre>
     * @param user
     */
    public void insertUser(User user);
    
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
    
    /***
     * <pre>
     *  查询所有配置的标签
     * </pre>
     * @return
     */
    public List<UserTag> getAllUserTag();
    
    /**
     * <pre>
     * 更新用户信息  
     * </pre>
     * @param user
     * @return
     */
    public int updateUserById(User user);

    /**
     * 
     * <pre>
     *  用户发布火焰
     * </pre>
     * @param user
     */
    public Integer insertUserFire(UserFire userFire);
    
    /**
     * <pre>
     *  查询火焰id查询用户火焰信息
     * </pre>
     * @param fireId
     * @return
     */
    public UserFire getUserFireById(@Param(value = "fireId") Integer fireId);

    /**
     * <pre>
     *  查询怒火火焰的标签信息
     * </pre>
     * @param fireId
     * @return
     */
    public List<UserTag> getFireTagsByFireId(@Param(value = "fireId") Integer fireId);
    
    /**
     * 
     * <pre>
     *   查询四周用户发布的火焰
     * </pre>
     * @param pageOffset
     * @param pageSize
     * @return
     */
    public List<UserFire> getUserFiresByLatitude(@Param("minLat")Double minLat,@Param("maxLat")Double maxLat,@Param("minLng")Double minLng,@Param("maxLng")Double maxLng);
    
    /**
     * <pre>
     *   分页查询用户发布的火焰
     * </pre>
     * @param pageOffset
     * @param pageSize
     * @return
     */
    public List<UserFire> getUserFiresByPage(@Param("pageOffset")int pageOffset,@Param("pageSize")int pageSize);
    
    /**
     * 
     * <pre>
     *      根据用户id查询用户发表的怒怒
     * </pre>
     * @param userId
     * @return
     */
    public List<UserFire> getUserFiresByUserId(Integer userId);
    
    /**
     * 
     * <pre>
     *   查询用户发布的火焰总共多少条
     * </pre>
     * @return
     */
    public int getUserFiresCountByLatitude();
    
    /**
     * <pre>
     *    新增用户火焰的评论
     * </pre>
     * @param userFireComment
     */
    public void insertUserFireComment(UserFireComment userFireComment);
    
    /**
     * 
     * <pre>
     *    查询火焰下面的评论列表
     * </pre>
     * @param fireId
     * @return
     */
    public List<UserFireComment> getUserFireCommentsByPage(@Param("fireId")int fireId,@Param("pageOffset")int pageOffset,@Param("pageSize")int pageSize);

    /**
     * <pre>
     *     插入用户点赞信息表
     * </pre>
     * @param userFirePraise
     */
    public void insertUserFirePraise(UserFirePraise userFirePraise);

    /**
     * 
     * <pre>
     *     插入用户点踩信息表
     * </pre>
     * @param userFireStep
     */
    public void insertUserFireStep(UserFireStep userFireStep);

    /**
     * <pre>
     *     插入用户标签
     * </pre>
     * @param userFireTag
     */
    public void insertUserFireTag(UserFireTag userFireTag);
    
    /**
     * 
     * <pre>
     *   查询用户点赞记录
     * </pre>
     * @param fireId
     * @param userId
     * @return
     */
    public UserFirePraise getUserFirePraiseByFireId(@Param("fireId")int fireId,@Param("userId")int userId);

    /**
     * 
     * <pre>
     *   查询用户点踩记录
     * </pre>
     * @param fireId
     * @param userId
     * @return
     */
    public UserFireStep getUserFireStepByFireId(@Param("fireId")int fireId,@Param("userId")int userId);

    public int updateUserFirePraiseByFireId(UserFirePraise userFirePraise);
    
    public int updateUserFireStepByFireId(UserFireStep userFireStep);
    
    /**
     * <pre>
     *     更新用户火焰表相关count统计
     * </pre>
     * @param userFire
     * @return
     */
    public int updateUserFireCountById(UserFire userFire);
    
    /**
     * 
     * <pre>
     *     查询我参与过的消息
     * </pre>
     * @param userId
     * @return
     */
    public List<UserFire> getUserFiresByMyInvolve(@Param("userId")int userId);
}
