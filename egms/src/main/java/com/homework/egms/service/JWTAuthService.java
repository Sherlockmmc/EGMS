package com.homework.egms.service;

import com.homework.egms.bean.JwtUser;
import com.homework.egms.bean.User;
import com.homework.egms.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
            List<SimpleGrantedAuthority> authorities=new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("1"));
            //该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication=authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(userId,password, authorities));
        }catch (Exception e){
           throw  new RuntimeException("用户账号或密码错误");
        }
        JwtUser loginUser = new JwtUser(authentication.getName(), null, null);
        //返回token
        /**
         *  Users loginUser = (Users) authentication.getPrincipal();
         *         // 生成token
         *         return jwtTokenUtil.generateToken(loginUser);
         */
        return jwtUtils.generateToken(loginUser);
    }
}
