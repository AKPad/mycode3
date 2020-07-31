package com.link.exception;

/**
 * 自定义异常，统一处理异常
 */
public class MyException extends RuntimeException{

    public static String SYS_CODE = "-1";
    public static String SYS_MSG = "系统繁忙，请稍后再试";

    private String code;    //状态码
    private String msg;     //异常信息

    public MyException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
