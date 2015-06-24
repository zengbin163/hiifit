package com.hiifit.haipay.enumEntity;

/** 
* @ClassName: DeviceTypeEnum 
* @Description: 设备类型
* @author bin
* @date 2015年4月21日 下午2:31:54 
*/
public enum SexEnum {
    
    WOMAN(0, "女人"), MAN(1, "男人");
    
    private Integer code;
    
    private String string;
    
    private SexEnum(Integer code, String string) {
        this.code = code;
        this.string = string;
    }
    
    public static SexEnum getEnum(Integer code) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.getCode().equals(code)) {
                return sexEnum;
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
