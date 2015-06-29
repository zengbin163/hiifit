package com.hiifit.haipay.vo;

/** 
* @ClassName: BaseVo 
* @author bin
* @date 2015年6月24日 下午4:22:41 
*/
public abstract class BaseVo {
    private int pageOffset;
    private int pageSize;
    
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
}
