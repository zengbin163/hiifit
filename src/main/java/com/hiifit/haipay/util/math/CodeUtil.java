/**
 * @Project: HJK
 * @Author: lizhibing
 * @Date: 2015-04-02
 * @Copyright: 2000-2015 CMCC . All rights reserved.
 */
package com.hiifit.haipay.util.math;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.springframework.util.StringUtils;

public abstract class CodeUtil {
    
    public static final String UTF8 = "UTF-8";
    
    public final static String encode(String value) {
        if (!StringUtils.hasText(value)) {
            return value;
        }
        try {
            return URLEncoder.encode(value, UTF8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public final static String decode(String value) {
        if (!StringUtils.hasText(value)) {
            return value;
        }
        try {
            return URLDecoder.decode(value, UTF8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
}
