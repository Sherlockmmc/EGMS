package com.homework.egms.commn;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/7/2 10:59
 */
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence arg0) {
        return arg0.toString();
    }

    @Override
    public boolean matches(CharSequence arg0, String arg1) {
        return arg1.equals(arg0.toString());
    }

}
