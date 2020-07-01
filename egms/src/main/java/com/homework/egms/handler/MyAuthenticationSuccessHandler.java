package com.homework.egms.handler;

import com.homework.egms.bean.JwtUser;
import com.homework.egms.utils.JwtUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @program: egms
 * @description:Spring security登录成功处理类,返回jwt
 * @Author: Sherlock
 * @Date 2020/6/27 11:02
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("登录成功");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");

        //从authentication中获取用户信息
        final JwtUser userDetail = (JwtUser) authentication.getPrincipal();
        //生成jwt
        String token =  JwtUtils.createJwtToken(userDetail.getUsername());
        httpServletResponse.addHeader("token", "Bearer " + token);
        httpServletResponse.getWriter().write("{\"result\":\"ok\"}");
        httpServletResponse.getWriter().flush();
    }
}
