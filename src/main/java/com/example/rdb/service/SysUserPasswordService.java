package com.example.rdb.service;

import com.example.rdb.req.SysUserPasswordReq;
import com.example.rdb.resp.SysUserPasswordResp;

public interface SysUserPasswordService {
    SysUserPasswordResp updatePass(SysUserPasswordReq req);
}
