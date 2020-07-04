package com.homework.egms.controller;
import com.alibaba.fastjson.JSONObject;
import com.homework.egms.commn.RestResult;
import com.homework.egms.service.JWTAuthService;
import com.homework.egms.service.UserServiceImp;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/7/2 10:32
 */
@Controller
@ResponseBody
public class JwtLoginController {
    @Resource
    JWTAuthService jwtAuthService;
    @Resource
    UserServiceImp userService;
    @Resource
    BCryptPasswordEncoder passwordEncoder;
    @PostMapping({"/login", "/"})
    public JSONObject login(String username, String password) {
       long userId=Long.parseLong(username);
       // User user=userService.findById(userId);
        String token = jwtAuthService.login(userId, password);
        RestResult result = new RestResult(200,"登录成功",token);

        return result;
    }

    @GetMapping({"/test"})
    public JSONObject test() {
        RestResult result = new RestResult(200,"登录成功");
        return result;
    }

}
