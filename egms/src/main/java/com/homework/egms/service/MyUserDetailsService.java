package com.homework.egms.service;

import com.homework.egms.bean.JwtUser;
import com.homework.egms.bean.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Resource
    UserServiceImp userService;
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        long id=Long.parseLong(userId);
        User user=userService.findById(id);
        if(user==null){
            throw new UsernameNotFoundException("登录用户：" + userId+ " 不存在");
        }
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        int role=user.getRole();
        String s = String.valueOf(role);
        authorities.add(new SimpleGrantedAuthority((s)));
        return new org.springframework.security.core.userdetails.User(userId,user.getPassword(), authorities);
    }
}
