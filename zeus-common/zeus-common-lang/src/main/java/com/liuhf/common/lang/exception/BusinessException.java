package com.liuhf.common.lang.exception;

import com.liuhf.common.lang.enums.Status;

/**
 * @author liuhf
 * @date 2023/4/12
 * @since 1.0
 */
public class BusinessException extends RuntimeException {

    private final String code;
    private final String msg;


    public BusinessException(Throwable cause, String code, String msg) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(Throwable cause, Status status) {
        super(cause);
        this.code = status.getCode();
        this.msg = status.getMessage();
    }

    public BusinessException(Status status) {
        this.code = status.getCode();
        this.msg = status.getMessage();
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
