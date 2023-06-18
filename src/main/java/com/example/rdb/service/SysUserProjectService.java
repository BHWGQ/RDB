package com.example.rdb.service;

import com.example.rdb.entity.SysUserProjectEntity;
import com.example.rdb.req.SysUserProjectReq;
import com.example.rdb.resp.SysUserProjectResp;
import com.example.rdb.resp.SysUserProjectShenResp;

import java.util.List;

public interface SysUserProjectService {
    SysUserProjectResp look(SysUserProjectReq sysUserProjectReq);

    SysUserProjectShenResp took(SysUserProjectReq sysUserProjectReq);

    List<SysUserProjectEntity> selectAll(Integer a);
}
