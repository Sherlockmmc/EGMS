package com.homework.egms.service;

import com.homework.egms.bean.User;
import com.homework.egms.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/6/22 22:37
 */
@Service
public class UserServiceImp implements UserService{
    @Resource
    UserMapper userMapper;
    @Override
    public int addUser(User user) {
       return userMapper.addUser(user);
    }

    @Override
    public int deletUser(long userId) {
      return   userMapper.deletUser(userId);
    }

    @Override
    public int updateUser(User user) {
       return userMapper.updateUser(user);
    }

    @Override
    public User findById(long userId) {
        return userMapper.findById(userId);
    }

    @Override
    public String findPwd(long userId) {
        String pwd=userMapper.findPwd(userId);
        return pwd;
    }
}
