package com.homework.egms.service;

import com.homework.egms.bean.Family;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/7/1 16:03
 */
public interface FamilyService {
    //增
    int addFamily(Family family);
    //删
    int deletFamily(long familyId);
    //改
    int updateFamily(Family family);
    //查
    Family findFamily(long familyId);
    //总人数
    int countAll(long familyId);
}
