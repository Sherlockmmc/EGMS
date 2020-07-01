package com.homework.egms.service;


import com.homework.egms.bean.Incident;
import com.homework.egms.mapper.IncidentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/7/1 16:07
 */
@Service
public class IncidentServiceImp implements IncidentService {
    @Resource
    IncidentMapper incidentMapper;
    @Override
    public Incident findIncident(long incidentId) {
        return incidentMapper.findIncident(incidentId);
    }
}
