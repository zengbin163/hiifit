package com.hiifit.haipay.vo;

import com.hiifit.haipay.enumEntity.ReturnCodeEnum;

/** 
* @ClassName: BaseVo 
* @author bin
* @date 2015年6月24日 下午4:22:41 
*/
public abstract class BaseVo {
    private int pageOffset;
    private int pageSize;
    private int version;
    private int recode = ReturnCodeEnum.SUCCESS.getCode();
    private String msg = ReturnCodeEnum.SUCCESS.getString();
    
    public int getPageOffset() {
        return pageOffset;
    }
    
    public void setPageOffset(int pageOffset) {
        this.pageOffset = pageOffset;
    }
    
    public int getPageSize() {
        return pageSize;
    }
    
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    public int getVersion() {
        return version;
    }
    
    public void setVersion(int version) {
        this.version = version;
    }
    
    public int getRecode() {
        return recode;
    }
    
    public void setRecode(int recode) {
        this.recode = recode;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
