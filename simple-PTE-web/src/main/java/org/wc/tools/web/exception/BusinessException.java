package org.wc.tools.web.exception;

/**
 * Created by WenChen on 2020/11/23.
 */
public class BusinessException extends RuntimeException {

    private String code;

    private String msg;

    public BusinessException(String code, String msg) {
        this(code,msg,null);
    }

    public BusinessException(String code, String msg, Throwable cause) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
