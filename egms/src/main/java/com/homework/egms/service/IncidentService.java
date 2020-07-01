package com.homework.egms.service;

import com.homework.egms.bean.Incident;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/7/1 16:07
 */
public interface IncidentService {
    //查询
    Incident findIncident(long incidentId);
}
