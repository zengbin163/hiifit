package com.hiifit.haipay.web.interceptor;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.hiifit.haipay.manager.UserManager;
import com.hiifit.haipay.vo.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class GlobalLoginHandling extends AbstractInterceptor {
    
    private static final long serialVersionUID = 8198284756139778765L;
    
    @Autowired
    private UserManager userManager;
    
    private static final String []interceptMethods = {"index"};
    
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        String method = invocation.getProxy().getMethod();
        if(ArrayUtils.contains(interceptMethods, method)){
            Map<String, Object> parameters = invocation.getInvocationContext().getParameters();        
            Object deviceId = parameters.get("deviceId");
            String []devId = (String[])deviceId;
            Assert.notNull(devId);
            Assert.hasText(devId[0]);
            User user = userManager.getUserByDeviceId(devId[0]);
            if(null==user){
                user = new User();
                user.setDeviceId(devId[0]);
                this.userManager.registerUser(user);
            }else{
                user.setLastLoginTime(new Date());
                this.userManager.updateUserLastLoginTime(user);
            }
        }
        return invocation.invoke();
    }
}
