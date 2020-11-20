package com.wddjnn.user.enums;

/**
 * @author : wuyuechao
 * @Date: 2019-12-15 11:26
 * @Description:
 */
public enum YesNoEnum {
    /**
     * 是
     */
    YES(1, "是"),

    /**
     * 否
     */
    NO(0, "否");


    int code;
    String message;

    YesNoEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
