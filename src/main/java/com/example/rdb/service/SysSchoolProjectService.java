package com.example.rdb.service;

import com.example.rdb.entity.SysSchoolProjectEntity;

import java.util.List;

public interface SysSchoolProjectService {
    List<SysSchoolProjectEntity> selectAll(Integer a);
}
