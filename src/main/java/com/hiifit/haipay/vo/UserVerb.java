/*
 * @Project: GZJK
 * @Author: bin
 * @Date: 2015年6月23日
 * @Copyright: 2000-2015 CMCC . All rights reserved.
 */
package com.hiifit.haipay.vo;

import java.io.Serializable;

/** 
* @ClassName: UserVerb 
* @Description: 用户昵称动词
* @date 2015年6月23日 上午10:57:43 
*/
public class UserVerb extends BaseVo implements Serializable {
    
    private static final long serialVersionUID = -7983128570382845091L;
    private Integer id;
    private String verb;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getVerb() {
        return verb;
    }
    
    public void setVerb(String verb) {
        this.verb = verb;
    }
}
