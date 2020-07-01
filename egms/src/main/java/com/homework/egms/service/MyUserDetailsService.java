package com.homework.egms.service;

import com.homework.egms.bean.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: egms
 * @description:根据用户名获取数据库该用户信息，spring security在登录时自动调用
 *  * WebSecurityConfigurerAdapter会拿这里的User里的password与用户输入的对比验证
 * @Author: Sherlock
 * @Date 2020/6/27 11:02
 */
@Service
public  class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        GrantedAuthority au = new SimpleGrantedAuthority("ROLE_USER");
        list.add(au);
        //123456 自定义MD5加密后=e10adc3949ba59abbe56e057f20f883e
        JwtUser jwtUser = new JwtUser(s,"e10adc3949ba59abbe56e057f20f883e",list);
        if (jwtUser == null) {
            throw new UsernameNotFoundException(String.format("No user found with username."));
        }
        System.out.println(jwtUser);
        return jwtUser;
    }
}
