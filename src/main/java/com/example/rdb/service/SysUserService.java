package com.example.rdb.service;

import com.example.rdb.entity.SysUserEntity;
import com.example.rdb.req.SysUserLoginReq;
import com.example.rdb.req.SysUserSaveReq;
import com.example.rdb.resp.SysUserLoginResp;
import com.example.rdb.resp.SysUserRegisterResp;

import java.util.List;

public interface SysUserService {
    SysUserRegisterResp register(SysUserSaveReq req);

    SysUserLoginResp login(SysUserLoginReq req);

    List<SysUserEntity> selectAll(Integer a);
}
