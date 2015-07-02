/*
 * @Project: GZJK
 * @Author: bin
 * @Date: 2015年7月2日
 * @Copyright: 2000-2015 CMCC . All rights reserved.
 */
package com.hiifit.haipay.util.math;

import org.springframework.util.StringUtils;

import com.chinamobile.cmcc.encypt.util.DESUtil;

/** 
* @ClassName: FireUtil 
* @Description: TODO
* @author bin
* @date 2015年7月2日 下午2:22:24 
*/
public abstract class FireUtil {
    private static final int DEFAULT_VALUE = 0;
    
    public static int getFireValue(String fireReason) {
        int fireValue = DEFAULT_VALUE;
        if (StringUtils.isEmpty(fireReason)) {
            return fireValue;
        }
        fireValue = DESUtil.encrypt(fireReason).length();
        return fireValue;
    }
}
