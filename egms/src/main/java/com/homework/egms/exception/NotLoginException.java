package com.homework.egms.exception;

import javax.security.sasl.AuthenticationException;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/6/26 15:26
 */
public class NotLoginException extends AuthenticationException {
    public NotLoginException(String msg, Throwable t) {
        super(msg, t);
    }

    public NotLoginException(String msg) {
        super(msg);
    }
}
