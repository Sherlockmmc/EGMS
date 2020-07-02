package com.homework.egms.mapper;

import com.homework.egms.bean.Family;

public interface FamilyMapper {
    //增
    int addFamily(Family family);
    //删
    int deletFamily(long familyId);
    //改
    int updateFamily(Family family);
    //查
    Family findFamily(long family);
    //查询总人数
    int countAll(long familyId);

}
