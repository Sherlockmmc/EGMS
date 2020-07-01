package com.homework.egms.service;

import com.homework.egms.bean.Family;
import com.homework.egms.mapper.FamilyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/7/1 16:04
 */
@Service
public class FamilyServiceImp implements FamilyService {
    @Resource
    FamilyMapper familyMapper;
    @Override
    public int addFamily(Family family) {
        return familyMapper.addFamily(family);
    }

    @Override
    public int deletFamily(long familyId) {
        return familyMapper.deletFamily(familyId);
    }

    @Override
    public int updateFamily(Family family) {
        return familyMapper.updateFamily(family);
    }

    @Override
    public Family findFamily(long familyId) {
        return familyMapper.findFamily(familyId);
    }

    @Override
    public int countAll(long familyId) {
        return familyMapper.countAll(familyId);
    }
}
