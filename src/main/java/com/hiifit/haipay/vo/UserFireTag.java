package com.hiifit.haipay.vo;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: UserFireTag 
* @Description: 用户怒火下面的标签
* @date 2015年6月25日 上午10:57:43 
*/
public class UserFireTag extends BaseVo implements Serializable {
    
    private static final long serialVersionUID = 8524662005889922240L;
    private Integer id;
    private Integer fireId; // 怒火id
    private Integer tagId; // 标签id
    private Date createTime;
    private Date modifyTime;
    
    public UserFireTag() {
        
    }
    
    public UserFireTag(Integer fireId, Integer tagId) {
        this.fireId = fireId;
        this.tagId = tagId;
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
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    
}
