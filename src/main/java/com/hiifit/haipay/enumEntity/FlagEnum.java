package com.hiifit.haipay.enumEntity;

/** 
* @ClassName: FlagEnum 
* @Description: flag类型
* @author bin
* @date 2015年4月21日 下午2:31:54 
*/
public enum FlagEnum {
    
    NOT_READ(0, "未被阅读"), BE_READED(1, "已被阅读"), BE_DELETED(2, "已被逻辑删除");
    
    private Integer code;
    
    private String string;
    
    private FlagEnum(Integer code, String string) {
        this.code = code;
        this.string = string;
    }
    
    public static FlagEnum getEnum(Integer code) {
        for (FlagEnum flagEnum : FlagEnum.values()) {
            if (flagEnum.getCode().equals(code)) {
                return flagEnum;
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
