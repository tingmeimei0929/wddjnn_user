package com.wddjnn.user.util.exception;

/**
 * @author wyc
 */
public class BizException extends RuntimeException {
    private int code;
    private static final long serialVersionUID = -4249405448091210964L;

    public BizException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(int code, String message, Exception e) {
        super(message, e);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
