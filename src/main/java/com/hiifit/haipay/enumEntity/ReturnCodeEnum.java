/*
 * @Project: GZJK
 * @Author: bin
 * @Date: 2015年4月21日
 * @Copyright: 2000-2015 CMCC . All rights reserved.
 */
package com.hiifit.haipay.enumEntity;

/** 
* @ClassName: DeviceTypeEnum 
* @Description: 设备类型
* @author bin
* @date 2015年4月21日 下午2:31:54 
*/
public enum ReturnCodeEnum {
    
    SUCCESS(200, "响应正常"), 
    NOT_EXISTS(404, "数据不存在"),
    UPDATE_FAIL(500, "更新失败"),
    ILLEGAL_ARGUMENT(510, "参数错误或者缺少必要参数"),
    SYSTEM_ERROR(555, "系统异常"),
    ;
    
    private Integer code;
    
    private String string;
    
    private ReturnCodeEnum(Integer code, String string) {
        this.code = code;
        this.string = string;
    }
    
    public static ReturnCodeEnum getEnum(Integer code) {
        for (ReturnCodeEnum retEnum : ReturnCodeEnum.values()) {
            if (retEnum.getCode().equals(code)) {
                return retEnum;
            }
        }
        return null;
    }
    
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    public String getString() {
        return string;
    }
    
    public void setString(String string) {
        this.string = string;
    }
}
