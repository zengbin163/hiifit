/*
 * @Project: GZJK
 * @Author: bin
 * @Date: 2015年6月23日
 * @Copyright: 2000-2015 CMCC . All rights reserved.
 */
package com.hiifit.haipay.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/** 
* @ClassName: UserFire 
* @Description: 怒火
* @author bin
* @date 2015年6月23日 下午2:46:52 
*/
public class UserFire extends BaseVo implements Serializable {
    
    private static final long serialVersionUID = -3365636324936706791L;
    
    private Integer id;
    private Integer userId;
    private String fireReason;
    private Integer fireValue;
    private Integer firePraiseCount;
    private Integer fireStepCount;
    private Integer fireComCount;
    private Date createDate;
    private Date createTime;
    private Date modifyTime;
    private BigDecimal eastLatitude;
    private BigDecimal northLatitude;
    private Integer mapLevel;
    private String picUrl1;
    private String picUrl2;
    private String picUrl3;
    private String picUrl4;
    private String nickName;
    private String headerUrl;
    private Integer sex;
    private String address;
    private String tagIds;// 标签id，通过逗号分隔
    
    /**用于评论数、点赞数、点踩数更新作隔离**/
    private boolean commentIsolation = false;
    private boolean praiseIsolation = false;
    private boolean stepIsolation = false;
    
    private List<UserTag> tagList;
    
    public UserFire() {
        
    }
    
    public UserFire(Integer userId, String fireReason, Integer fireValue, Integer firePraiseCount,
                    Integer fireStepCount, Integer fireComCount, BigDecimal eastLatitude,
                    BigDecimal northLatitude, Integer mapLevel, String picUrl1, String picUrl2,
                    String picUrl3, String picUrl4, String address, String tagIds) {
        this.userId = userId;
        this.fireReason = fireReason;
        this.fireValue = fireValue;
        this.firePraiseCount = firePraiseCount;
        this.fireStepCount = fireStepCount;
        this.fireComCount = fireComCount;
        this.eastLatitude = eastLatitude;
        this.northLatitude = northLatitude;
        this.mapLevel = mapLevel;
        this.picUrl1 = picUrl1;
        this.picUrl2 = picUrl2;
        this.picUrl3 = picUrl3;
        this.picUrl4 = picUrl4;
        this.address = address;
        this.tagIds = tagIds;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public String getFireReason() {
        return fireReason;
    }
    
    public void setFireReason(String fireReason) {
        this.fireReason = fireReason;
    }
    
    public Integer getFireValue() {
        return fireValue;
    }
    
    public void setFireValue(Integer fireValue) {
        this.fireValue = fireValue;
    }
    
    public Integer getFirePraiseCount() {
        return firePraiseCount;
    }
    
    public void setFirePraiseCount(Integer firePraiseCount) {
        this.firePraiseCount = firePraiseCount;
    }
    
    public Integer getFireStepCount() {
        return fireStepCount;
    }
    
    public void setFireStepCount(Integer fireStepCount) {
        this.fireStepCount = fireStepCount;
    }
    
    public Integer getFireComCount() {
        return fireComCount;
    }
    
    public void setFireComCount(Integer fireComCount) {
        this.fireComCount = fireComCount;
    }
    
    public Date getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Date getModifyTime() {
        return modifyTime;
    }
    
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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
    
    public Integer getMapLevel() {
        return mapLevel;
    }
    
    public void setMapLevel(Integer mapLevel) {
        this.mapLevel = mapLevel;
    }
    
    public String getPicUrl1() {
        return picUrl1;
    }
    
    public void setPicUrl1(String picUrl1) {
        this.picUrl1 = picUrl1;
    }
    
    public String getPicUrl2() {
        return picUrl2;
    }
    
    public void setPicUrl2(String picUrl2) {
        this.picUrl2 = picUrl2;
    }
    
    public String getPicUrl3() {
        return picUrl3;
    }
    
    public void setPicUrl3(String picUrl3) {
        this.picUrl3 = picUrl3;
    }
    
    public String getPicUrl4() {
        return picUrl4;
    }
    
    public void setPicUrl4(String picUrl4) {
        this.picUrl4 = picUrl4;
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
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public boolean isCommentIsolation() {
        return commentIsolation;
    }
    
    public void setCommentIsolation(boolean commentIsolation) {
        this.commentIsolation = commentIsolation;
    }
    
    public boolean isPraiseIsolation() {
        return praiseIsolation;
    }
    
    public void setPraiseIsolation(boolean praiseIsolation) {
        this.praiseIsolation = praiseIsolation;
    }
    
    public boolean isStepIsolation() {
        return stepIsolation;
    }
    
    public void setStepIsolation(boolean stepIsolation) {
        this.stepIsolation = stepIsolation;
    }
    
    public String getTagIds() {
        return tagIds;
    }
    
    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }
    
    public List<UserTag> getTagList() {
        return tagList;
    }
    
    public void setTagList(List<UserTag> tagList) {
        this.tagList = tagList;
    }
    
}
