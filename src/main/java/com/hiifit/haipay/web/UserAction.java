/*
*@Project: GZJK
*@Author: bin
*@Date: 2015年6月19日
*@Copyright: 2000-2015 CMCC . All rights reserved.
 */
package com.hiifit.haipay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

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
    
    /**
     * <pre>
     *  查询基本信息
     * </pre>
     * @return
     */
    public String userInfo(){
        Integer userId = ParamUtil.getIntParameter(request, "userId", null);
        Assert.notNull(userId);
        User user = userManager.getByUserId(userId);
        returnFastJSON(user);
        return null;
    }
    
    /**
     * <pre>
     *   更新基本信息
     * </pre>
     * @return
     */
    public String updateUserInfo(){
        Integer userId = ParamUtil.getIntParameter(request, "userId", null);
        Assert.notNull(userId);
        String nickName = ParamUtil.getStringParameter(request, "nickName", null);
        String headerUrl = ParamUtil.getStringParameter(request, "headerUrl", null);
        Integer sex = ParamUtil.getIntParameter(request, "sex", null);
        returnFastJSON(this.userManager.updateUserInfo(userId, nickName, headerUrl, sex));
        return null;
    }
    
    /***
     * <pre>
     *    首页火焰列表
     * </pre>
     * @return
     */
    public String fireList(){
        return null;
    }
    
    /***
     * <pre>
     *  用户发怒
     * </pre>
     * @return
     */
    public String fire(){
        return null;
    }
 
    /***
     * <pre>
     *  用户评论
     * </pre>
     * @return
     */
    public String comment(){
        return null;
    }
    
    /***
     * <pre>
     *  用户评论列表
     * </pre>
     * @return
     */
    public String commentList(){
        return null;
    }
    
}

