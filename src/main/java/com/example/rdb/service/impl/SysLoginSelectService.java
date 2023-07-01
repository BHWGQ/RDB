package com.example.rdb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.rdb.entity.SysLoginEntity;
import com.example.rdb.mapper.SysLoginSelectMapper;
import com.example.rdb.req.SysLoginSelectReq;
import com.example.rdb.resp.SysLoginSelectResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLoginSelectService extends ServiceImpl<SysLoginSelectMapper, SysLoginEntity> implements com.example.rdb.service.SysLoginSelectService {
    @Autowired
    private SysLoginSelectMapper sysLoginSelectMapper;

    @Override
    public SysLoginSelectResp inter(SysLoginSelectReq req) {
        SysLoginEntity sysLoginEntity = new SysLoginEntity(req.getId(), req.getLoginName(), req.getIp(), req.getTime());
        sysLoginSelectMapper.insert(sysLoginEntity);
        return new SysLoginSelectResp()
                .setExplain("记录成功");
    }
}
