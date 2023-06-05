package com.example.rdb.service;

import com.example.rdb.entity.SysPeopleJoinEntity;
import com.example.rdb.req.SysPeopleJoinReq;
import com.example.rdb.resp.SysPeopleJoinInsertResp;

import java.util.List;

public interface SysPeopleJoinService {
    List<SysPeopleJoinEntity> selectAll1(Integer a);

    SysPeopleJoinInsertResp zr(SysPeopleJoinReq req);
}
