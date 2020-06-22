package com.homework.egms.bean;

import lombok.Data;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/6/22 22:35
 */
@Data
public class Family {
    private  String familyId;
    private  String familyName;
    private  String lastName;
    private  String introduction;
    private  Long   members;
    private  int times;
}
