package com.homework.egms.mapper;

import com.homework.egms.bean.Incident;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/7/1 15:45
 */
public interface IncidentMapper {
    //查询
    Incident findIncident(long incidentId);
}
