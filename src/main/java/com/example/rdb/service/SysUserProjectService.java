package com.example.rdb.service;

import com.example.rdb.req.SysUserProjectReq;
import com.example.rdb.resp.SysUserProjectResp;

public interface SysUserProjectService {
    SysUserProjectResp look(SysUserProjectReq sysUserProjectReq);
}
