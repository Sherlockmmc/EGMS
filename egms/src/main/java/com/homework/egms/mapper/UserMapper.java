package com.homework.egms.mapper;

import com.homework.egms.bean.User;
import org.apache.ibatis.annotations.Mapper;

import javax.jws.soap.SOAPBinding;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/6/22 22:36
 */
public interface UserMapper {
    //增
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
