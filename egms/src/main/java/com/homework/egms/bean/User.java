package com.homework.egms.bean;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/6/22 22:34
 */
@Data
public class User {
    private Long userId;
    private String userName;
    private  String password;
    private String sex;
    private Long fatherId;
    private  Long familyId;
    private String mate;
    private Date birthday;
    private String introduction;
    private int role;
}
