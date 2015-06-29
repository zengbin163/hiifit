package com.hiifit.haipay.vo;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: UserFireStep 
* @Description: 用户点踩
* @date 2015年6月25日 上午10:57:43 
*/
public class UserFireStep extends BaseVo implements Serializable {
    
    private static final long serialVersionUID = 8524662005889922240L;
    private Integer id;
    private Integer fireId; // 怒火id
    private Integer userId; // 点赞用户id
    private int flag; // 数据标示： 0评论未被读取，1评论已被读取，2数据被逻辑删除
    private Date createTime;
    
    public UserFireStep() {
        
    }
    
    public UserFireStep(Integer fireId, Integer userId) {
        this.fireId = fireId;
        this.userId = userId;
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
    
    public int getFlag() {
        return flag;
    }
    
    public void setFlag(int flag) {
        this.flag = flag;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
}
