package com.homework.egms.controller;

import com.alibaba.fastjson.JSONObject;
import com.homework.egms.bean.User;
import com.homework.egms.commn.RestResult;
import com.homework.egms.service.JWTAuthService;
import com.homework.egms.service.UserServiceImp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/6/27 16:12
 */
@RestController
public class JwtLoginController {
    @Resource
    JWTAuthService jwtAuthService;
    @Resource
    UserServiceImp userService;
    @PostMapping({"/login","/"})
   public JSONObject login(long userId, String password){
        User user=userService.findById(userId);
        if(password!=user.getPassword()){
            throw  new RuntimeException("用户账号或密码错误");
        }
        String token=jwtAuthService.login(userId,password);
        RestResult result=RestResult.success("登录成功",token);
       return result;
   }
}
