package com.homework.egms.bean;

import lombok.Data;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/6/22 22:35
 */
@Data
public class Incident {
    private Long incidentId;
    private String incidentName;
    private String familyId;
    private String story;
}
