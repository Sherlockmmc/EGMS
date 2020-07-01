package com.homework.egms.exception;


import com.homework.egms.api.ResultCode;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/6/27 11:02
 */
public class PermissionForbiddenException extends BusinessException {
    public PermissionForbiddenException() {
        super();
    }

    public PermissionForbiddenException(Object data) {
        super();
        super.data = data;
    }

    public PermissionForbiddenException(ResultCode resultCode) {
        super(resultCode);
    }

    public PermissionForbiddenException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public PermissionForbiddenException(String msg) {
        super(msg);
    }

    public PermissionForbiddenException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
