package com.homework.egms.exception;


import com.homework.egms.api.ResultCode;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/6/27 11:02
 */
public class RegisterFailedException extends BusinessException {
    public RegisterFailedException() {
        super();
    }

    public RegisterFailedException(Object data) {
        super();
        super.data = data;
    }

    public RegisterFailedException(ResultCode resultCode) {
        super(resultCode);
    }

    public RegisterFailedException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public RegisterFailedException(String msg) {
        super(msg);
    }

    public RegisterFailedException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
