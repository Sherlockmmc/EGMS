package com.homework.egms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/6/27 16:12
 */
@RestController
public class JwtLoginController {
    @PostMapping({"/login","/"})
   public  Object login(String username,String password){

       return null;
   }
}
