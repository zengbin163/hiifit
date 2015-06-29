package com.hiifit.haipay.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
* @ClassName: UserFireComment 
* @Description: 用户评论
* @date 2015年6月25日 上午10:57:43 
*/
public class UserFireComment extends BaseVo implements Serializable {
    
    private static final long serialVersionUID = 3320496787645452598L;
    private Integer id;
    private Integer fireId; // 怒火id
    private Integer followerId; // 评论发表者id
    private Integer authorId; // 被评论者id
    private String content; // 评论内容
    private int flag; // 数据标示： 0评论未被读取，1评论已被读取，2数据被逻辑删除
    private BigDecimal eastLatitude;
    private BigDecimal northLatitude;
    private Date createTime;
    private String address;
    private String nickName;
    private String headerUrl;
    private Integer sex;
    
    public UserFireComment(){

    }
    
    public UserFireComment(Integer fireId, Integer followerId, Integer authorId, String content) {
        this.fireId = fireId;
        this.followerId = followerId;
        this.authorId = authorId;
        this.content = content;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getFireId() {
        return fireId;
    }
    
    public void setFireId(Integer fireId) {
        this.fireId = fireId;
    }
    
    public Integer getFollowerId() {
        return followerId;
    }
    
    public void setFollowerId(Integer followerId) {
        this.followerId = followerId;
    }
    
    public Integer getAuthorId() {
        return authorId;
    }
    
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public int getFlag() {
        return flag;
    }
    
    public void setFlag(int flag) {
        this.flag = flag;
    }
    
    public BigDecimal getEastLatitude() {
        return eastLatitude;
    }
    
    public void setEastLatitude(BigDecimal eastLatitude) {
        this.eastLatitude = eastLatitude;
    }
    
    public BigDecimal getNorthLatitude() {
        return northLatitude;
    }
    
    public void setNorthLatitude(BigDecimal northLatitude) {
        this.northLatitude = northLatitude;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getNickName() {
        return nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public String getHeaderUrl() {
        return headerUrl;
    }
    
    public void setHeaderUrl(String headerUrl) {
        this.headerUrl = headerUrl;
    }
    
    public Integer getSex() {
        return sex;
    }
    
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
}
