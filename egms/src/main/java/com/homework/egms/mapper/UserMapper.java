package com.homework.egms.mapper;

import com.homework.egms.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/6/22 22:36
 */
@Mapper
public interface UserMapper {
    void addUser(User user);
}
