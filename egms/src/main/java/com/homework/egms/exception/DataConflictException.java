package com.homework.egms.exception;

import com.homework.egms.api.ResultCode;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/6/27 11:02
 */
public class DataConflictException extends BusinessException{
    public DataConflictException() {
        super();
    }

    public DataConflictException(Object data) {
        super();
        super.data = data;
    }

    public DataConflictException(ResultCode resultCode) {
        super(resultCode);
    }

    public DataConflictException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public DataConflictException(String msg) {
        super(msg);
    }

    public DataConflictException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
