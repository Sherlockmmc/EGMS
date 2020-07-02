package com.homework.egms.controller;
import com.homework.egms.bean.Family;
import com.homework.egms.bean.User;
import com.homework.egms.commn.RestResult;
import com.homework.egms.service.FamilyServiceImp;
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
 * @Date 2020/7/1 16:26
 */
@Controller
@ResponseBody
@RequestMapping(value = "/admin",produces = "application/json;charset=utf-8")
public class AdminController {
    @Resource
    FamilyServiceImp familyService;
    @Resource
    UserServiceImp userService;

    /**
     * 添加成员
     * @param user
     */
    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    public RestResult addUser(@RequestBody User user){
        userService.addUser(user);
        RestResult result=RestResult.success();
        return  result;
    }

    /**
     * 删除成员
     * @param userId
     * @return
     */
    @RequestMapping(value = "/deletUser",method = RequestMethod.DELETE)
    public RestResult deletUser(long userId){
        userService.deletUser(userId);
        RestResult result=RestResult.success();
        return  result;
    }

    /**
     * 改成员
     * @param user
     * @return
     */
    @RequestMapping(value = "/uodateUser",method = RequestMethod.POST)
    public Object upDate(@RequestBody User user){
        userService.updateUser(user);
        RestResult result=RestResult.success();
        return  result;
    }
    /**
     * 添加家族
     * @param family
     */
    @RequestMapping(value="/addFamily",method = RequestMethod.POST)
    public RestResult addFamily(@RequestBody Family family){
        familyService.addFamily(family);
        RestResult result=RestResult.success();
        return  result;
    }

    /**
     * 删除家族
     * @param familyId
     * @return
     */
    @RequestMapping(value = "/deletFamily",method = RequestMethod.DELETE)
    public RestResult deletFamily(long familyId){
        familyService.deletFamily(familyId);
        RestResult result=RestResult.success();
        return  result;
    }

    /**
     * 改家族
     * @param family
     * @return
     */
    @RequestMapping(value = "/uodateFamily",method = RequestMethod.POST)
    public Object upDateFamily(@RequestBody Family family){
        familyService.updateFamily(family);
        RestResult result=RestResult.success();
        return  result;
    }
}
