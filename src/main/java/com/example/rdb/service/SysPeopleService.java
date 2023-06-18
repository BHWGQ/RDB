package com.example.rdb.service;

import com.example.rdb.entity.SysPeopleEntity;
import com.example.rdb.req.SysPeopleReq;
import com.example.rdb.req.SysPeopleUpdateReq;
import com.example.rdb.resp.SysPeopleInsertResp;
import com.example.rdb.resp.SysPeopleUpdateResp;

import java.util.List;

public interface SysPeopleService {

    List<SysPeopleEntity> selectAll(Integer a);

    SysPeopleInsertResp s1(SysPeopleReq req);

    List<SysPeopleEntity> delete(SysPeopleReq req);

    SysPeopleUpdateResp update(SysPeopleUpdateReq req);
}
