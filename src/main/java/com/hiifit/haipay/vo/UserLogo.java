/*
*@Project: GZJK
*@Author: bin
*@Date: 2015年6月23日
*@Copyright: 2000-2015 CMCC . All rights reserved.
 */
package com.hiifit.haipay.vo;

import java.io.Serializable;

/** 
* @ClassName: UserLogo 
* @Description: 用户随机头像
* @date 2015年6月23日 上午10:57:43 
*/
public class UserLogo implements Serializable {

    private static final long serialVersionUID = -8654585322511729274L;
    
    private Integer id;
    private String headerUrl;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getHeaderUrl() {
        return headerUrl;
    }
    public void setHeaderUrl(String headerUrl) {
        this.headerUrl = headerUrl;
    }
    
}

