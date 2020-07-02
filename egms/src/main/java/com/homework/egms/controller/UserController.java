package com.homework.egms.controller;

import com.homework.egms.bean.Family;
import com.homework.egms.bean.Incident;
import com.homework.egms.bean.User;
import com.homework.egms.commn.RestResult;
import com.homework.egms.service.FamilyServiceImp;
import com.homework.egms.service.IncidentService;
import com.homework.egms.service.IncidentServiceImp;
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
@RequestMapping(value = "/user",produces = "application/json;charset=utf-8")
public class UserController {
    @Resource
    UserServiceImp userService;
    @Resource
    FamilyServiceImp familyService;
    @Resource
    IncidentServiceImp incidentService;

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/uodate",method = RequestMethod.POST)
    public Object upDate(@RequestBody User user){
        userService.updateUser(user);
        RestResult result=RestResult.success();
        return  result;
    }
    /**
     * 查找user
     * @param userId
     * @return
     */
    @RequestMapping(value = "/findUser",method = RequestMethod.GET)
    public  Object find(long userId){
        User user=userService.findById(userId);
        return user;
    }

    /**
     * 查找家族
     * @param familyId
     * @return
     */
    @RequestMapping(value = "/findFamily",method = RequestMethod.GET)
    public Object findFamily(long familyId){
        Family family=familyService.findFamily(familyId);
        return  family;
    }

    /**
     * 查找重大事件
     * @param incidentId
     * @return
     */
    @RequestMapping(value = "/findIncident",method = RequestMethod.GET)
    public Object findIncident(long incidentId){
        Incident incident=incidentService.findIncident(incidentId);

        return  incident;
    }
}
