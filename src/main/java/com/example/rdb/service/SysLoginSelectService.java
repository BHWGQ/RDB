package com.example.rdb.service;

import com.example.rdb.req.SysLoginSelectReq;
import com.example.rdb.resp.SysLoginSelectResp;

public interface SysLoginSelectService {

    SysLoginSelectResp inter(SysLoginSelectReq req);
}
