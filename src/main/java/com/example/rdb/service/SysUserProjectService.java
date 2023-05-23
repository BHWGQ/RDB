package com.example.rdb.service;

import com.example.rdb.req.SysUserProjectReq;
import com.example.rdb.resp.SysUserProjectResp;
import com.example.rdb.resp.SysUserProjectShenResp;

public interface SysUserProjectService {
    SysUserProjectResp look(SysUserProjectReq sysUserProjectReq);

    SysUserProjectShenResp took(SysUserProjectReq sysUserProjectReq);
}
