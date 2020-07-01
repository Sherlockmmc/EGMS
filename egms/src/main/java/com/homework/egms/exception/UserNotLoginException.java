package com.homework.egms.exception;


import com.homework.egms.api.ResultCode;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/6/27 11:02
 */
public class UserNotLoginException extends BusinessException {
    public UserNotLoginException() {
        super();
    }

    public UserNotLoginException(Object data) {
        super();
        super.data = data;
    }

    public UserNotLoginException(ResultCode resultCode) {
        super(resultCode);
    }

    public UserNotLoginException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public UserNotLoginException(String msg) {
        super(msg);
    }

    public UserNotLoginException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}