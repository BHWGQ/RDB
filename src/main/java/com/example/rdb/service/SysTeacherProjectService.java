package com.example.rdb.service;

import com.example.rdb.entity.SysTeacherProjectEntity;
import com.example.rdb.req.SysTeacherProjectReq;
import com.example.rdb.resp.SysTeacherProjectResp;
import com.example.rdb.resp.SysTeacherProjectShenResp;

import java.util.List;

public interface SysTeacherProjectService {
    SysTeacherProjectResp teacher(SysTeacherProjectReq sysTeacherProjectReq);

    SysTeacherProjectShenResp teacher1(SysTeacherProjectReq sysTeacherProjectReq);

    List<SysTeacherProjectEntity> selectAll(Integer a);
}
