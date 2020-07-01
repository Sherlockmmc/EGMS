package com.homework.egms.controller;

import com.homework.egms.commn.RestResult;
import com.homework.egms.service.JWTAuthService;
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
    @PostMapping({"/login","/"})
   public  Object login(String username,String password){
        RestResult result=RestResult.success();
        String token=jwtAuthService.login(username,password);
       return result;
   }
}
