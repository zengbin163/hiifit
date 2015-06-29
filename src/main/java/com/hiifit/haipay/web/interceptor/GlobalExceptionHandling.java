package com.hiifit.haipay.web.interceptor;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cmcc.common.util.WebUtil;
import com.hiifit.haipay.enumEntity.ReturnCodeEnum;
import com.hiifit.haipay.util.result.ResultUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class GlobalExceptionHandling extends AbstractInterceptor {
    
    private static final long serialVersionUID = 8198284756139778765L;
    
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        String resultString = null;
        try {
            resultString = invocation.invoke();
        } catch (Exception e) {
            e.printStackTrace();
            if(e.getClass().isAssignableFrom(IllegalArgumentException.class)){
                write(ResultUtil.failMap(ReturnCodeEnum.ILLEGAL_ARGUMENT));
                return null;
            }else{
                write(ResultUtil.failMap(ReturnCodeEnum.SYSTEM_ERROR));
                return null;
            }
        }
        return resultString;
    }
    
    private void write(Object obj){
        HttpServletResponse response = ServletActionContext.getResponse();
        WebUtil.returnJSON(response, JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue).toString(), "json");
    }
}
