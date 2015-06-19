/*
*@Project: GZJK
*@Author: bin
*@Date: 2015年6月19日
*@Copyright: 2000-2015 CMCC . All rights reserved.
 */
package com.hiifit.haipay.web;

import org.springframework.beans.factory.annotation.Autowired;

import com.cmcc.common.util.ParamUtil;
import com.hiifit.haipay.manager.UserManager;
import com.hiifit.haipay.vo.User;


/** 
* @ClassName: UserAction 
* @Description: TODO
* @author bin
* @date 2015年6月19日 上午11:21:51 
*/
public class UserAction extends BaseAction{
    private static final long serialVersionUID = -7879690191783260314L;

    @Autowired
    protected UserManager userManager;
    
    public String userInfo(){
        int userId = ParamUtil.getIntParameter(request, "userId", 0);
        User user = userManager.getByUserId(userId);
        returnFastJSON(user);
        return null;
    }
}

