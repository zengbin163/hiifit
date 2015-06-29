/*
 * @Project: GZJK
 * @Author: bin
 * @Date: 2015年6月23日
 * @Copyright: 2000-2015 CMCC . All rights reserved.
 */
package com.hiifit.haipay.util.result;

import java.util.HashMap;
import java.util.Map;

import com.hiifit.haipay.enumEntity.ReturnCodeEnum;

/** 
* @ClassName: ResultUtils 
* @Description: TODO
* @author bin
* @date 2015年6月23日 下午4:58:51 
*/
public class ResultUtil {
    
    public static final String RETURN_KEY = "recode";
    public static final String MSG = "msg";
    
    public static Map<String, Object> successMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(RETURN_KEY, ReturnCodeEnum.SUCCESS.getCode());
        return map;
    }

    public static Map<String, Object> failMap(ReturnCodeEnum returnCode) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(RETURN_KEY, returnCode.getCode());
        map.put(MSG, returnCode.getString());
        return map;
    }
    
}
