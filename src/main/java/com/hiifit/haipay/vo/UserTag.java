/*
 * @Project: GZJK
 * @Author: bin
 * @Date: 2015年6月23日
 * @Copyright: 2000-2015 CMCC . All rights reserved.
 */
package com.hiifit.haipay.vo;

import java.io.Serializable;

/** 
* @ClassName: UserTag 
* @Description: 怒火标签
* @date 2015年6月23日 上午10:57:43 
*/
public class UserTag extends BaseVo implements Serializable {
    
    private static final long serialVersionUID = 8113997764723566384L;
    private Integer id;
    private String tagName;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTagName() {
        return tagName;
    }
    
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
    
}
