/*
*@Project: GZJK
*@Author: bin
*@Date: 2015年6月24日
*@Copyright: 2000-2015 CMCC . All rights reserved.
 */
package com.hiifit.haipay;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/** 
* @ClassName: MainTest 
* @Description: TODO
* @author bin
* @date 2015年6月24日 下午2:02:57 
*/
public class MainTest {
    public static void main(String[] args) throws ParseException {
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1, "亲爱的");
        map.put(2, "我爱你");
        
        System.out.println(JSONObject.toJSON(map));
    }
}

