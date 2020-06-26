package com.homework.egms.controller;

import com.homework.egms.bean.User;
import com.homework.egms.service.UserServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/6/26 12:37
 */
@Controller
@ResponseBody
@RequestMapping(value = "user",produces = "application/json;charset=utf-8")
public class UserController {
    @Resource
    UserServiceImp userService;
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
}
