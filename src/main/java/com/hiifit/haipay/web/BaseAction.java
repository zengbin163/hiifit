/*
 * @Project: GZJK
 * @Author: bin
 * @Date: 2015年6月19日
 * @Copyright: 2000-2015 CMCC . All rights reserved.
 */
package com.hiifit.haipay.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cmcc.common.util.WebUtil;
import com.hiifit.haipay.enumEntity.ReturnCodeEnum;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/** 
* @ClassName: BaseAction 
* @Description: TODO
* @author bin
* @date 2015年6月19日 上午11:22:51 
*/
public abstract class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware, Preparable {
   
    private static final long serialVersionUID = 3264789333544841923L;
    
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected  Object result;
    
    protected static final int DEFAULT_VALUE = 0;
    
    protected void returnSingleFastJSON(Object obj) {
        if(obj != null){
            WebUtil.returnJSON(response,(JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue).toString()),"json");
        }else{
            WebUtil.returnJSON(response, ("{\"recode\":\"" + ReturnCodeEnum.NOT_EXISTS.getCode() + "\"," + "\"msg\":\"" + ReturnCodeEnum.NOT_EXISTS.getString() + "\"}"), "json");
        }
    }
    
    protected void returnFastJSON(Object obj) {
        if(obj != null){
            WebUtil.returnJSON(response,("{\"recode\":\"" + ReturnCodeEnum.SUCCESS.getCode() + "\","  + "\"data\":" + JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue).toString()  + ",\"msg\":\"" + ReturnCodeEnum.SUCCESS.getString() + "\"}"),"json");
        }else{
            WebUtil.returnJSON(response, ("{\"recode\":\"" + ReturnCodeEnum.NOT_EXISTS.getCode() + "\"," + "\"msg\":\"" + ReturnCodeEnum.NOT_EXISTS.getString() + "\"}"), "json");
        }
    }

    protected void returnWithoutFastJSON(Object obj) {
        if(obj != null){
            WebUtil.returnJSON(response,(JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue).toString()),"json");
        }else{
            WebUtil.returnJSON(response, ("{\"recode\":\"" + ReturnCodeEnum.NOT_EXISTS.getCode() + "\"," + "\"msg\":\"" + ReturnCodeEnum.NOT_EXISTS.getString() + "\"}"), "json");
        }
    }
    
    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
    
    @Override
    public void prepare() throws Exception {
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
