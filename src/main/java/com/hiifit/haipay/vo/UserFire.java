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
    private String picUrl;
    private String nickName;
    private String headerUrl;
    private Integer sex;
    private String address;
    
    public UserFire() {
        
    }
    
    public UserFire(Integer userId, String fireReason, Integer fireValue, Integer firePraiseCount,
                    Integer fireStepCount, Integer fireComCount, BigDecimal eastLatitude,
                    BigDecimal northLatitude, Integer mapLevel, String picUrl, String address) {
        this.userId = userId;
        this.fireReason = fireReason;
        this.fireValue = fireValue;
        this.firePraiseCount = firePraiseCount;
        this.fireStepCount = fireStepCount;
        this.fireComCount = fireComCount;
        this.eastLatitude = eastLatitude;
        this.northLatitude = northLatitude;
        this.mapLevel = mapLevel;
        this.picUrl = picUrl;
        this.address = address;
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
    
    public String getPicUrl() {
        return picUrl;
    }
    
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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
    
}
