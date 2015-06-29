/*
 * @Project: GZJK
 * @Author: bin
 * @Date: 2015年6月23日
 * @Copyright: 2000-2015 CMCC . All rights reserved.
 */
package com.hiifit.haipay.vo;

import java.io.Serializable;

/** 
* @ClassName: UserNoun 
* @Description: 用户昵称名词
* @date 2015年6月23日 上午10:57:43 
*/
public class UserNoun extends BaseVo implements Serializable {
    
    private static final long serialVersionUID = -4017447546274559388L;
    private Integer id;
    private String noun;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNoun() {
        return noun;
    }
    
    public void setNoun(String noun) {
        this.noun = noun;
    }
}
