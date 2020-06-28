package com.homework.egms.exception;


import com.homework.egms.api.ResultCode;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/6/27 11:02
 */
public class SmsCodeWrongException extends BusinessException {
    public SmsCodeWrongException() {
        super();
    }

    public SmsCodeWrongException(Object data) {
        super();
        super.data = data;
    }

    public SmsCodeWrongException(ResultCode resultCode) {
        super(resultCode);
    }

    public SmsCodeWrongException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public SmsCodeWrongException(String msg) {
        super(msg);
    }

    public SmsCodeWrongException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
