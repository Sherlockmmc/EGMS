package com.homework.egms.service;

import com.homework.egms.bean.User;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/6/22 22:37
 */
public interface UserService {
    int addUser(User user);
    //删
    int deletUser(long userId);
    //改
    int updateUser(User user);
    //查
    User findById(long userId);
    //查询密码
    String findPwd(long userId);
}
