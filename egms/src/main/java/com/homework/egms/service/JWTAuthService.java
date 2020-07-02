package com.homework.egms.service;

import com.homework.egms.bean.JwtUser;
import com.homework.egms.bean.User;
import com.homework.egms.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/6/29 18:05
 */
@Service
public class JWTAuthService {
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    JwtUtils jwtUtils;
    /**
     * 登录认证换取JWT令牌
     */
    public String login(long userId,String password){
        //用户验证
        Authentication authentication=null;
        try{
            //该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication=authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(userId,password));
        }catch (Exception e){
            throw  new RuntimeException("用户账号或密码错误");

        }
        JwtUser loginUser=(JwtUser)authentication.getPrincipal();
        //返回token
        return jwtUtils.generateToken(loginUser);
    }
}
