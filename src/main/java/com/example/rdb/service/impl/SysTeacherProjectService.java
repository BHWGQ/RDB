package com.example.rdb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.rdb.entity.SysTeacherProjectEntity;
import com.example.rdb.entity.SysTeacherProjectShenEntity;
import com.example.rdb.mapper.SysTeacherProjectMapper;
import com.example.rdb.mapper.SysTeacherProjectShenMapper;
import com.example.rdb.req.SysTeacherProjectReq;
import com.example.rdb.resp.SysTeacherProjectResp;
import com.example.rdb.resp.SysTeacherProjectShenResp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class SysTeacherProjectService extends ServiceImpl<SysTeacherProjectMapper, SysTeacherProjectEntity> implements com.example.rdb.service.SysTeacherProjectService {
    @Resource
    private SysTeacherProjectMapper sysTeacherProjectMapper;
    @Resource
    private SysTeacherProjectShenMapper sysTeacherProjectShenMapper;

    @Override
    public SysTeacherProjectResp teacher(SysTeacherProjectReq sysTeacherProjectReq) {
        LambdaQueryWrapper<SysTeacherProjectEntity> queryWrapper = new QueryWrapper<SysTeacherProjectEntity>().lambda()
                .eq(SysTeacherProjectEntity::getProjectId, sysTeacherProjectReq.getProjectId())
                .eq(SysTeacherProjectEntity::getProjectTea, sysTeacherProjectReq.getProjectTea());
        SysTeacherProjectEntity sysTeacherProjectEntity = sysTeacherProjectMapper.selectOne(queryWrapper);
        if (Objects.isNull(sysTeacherProjectEntity)) {
            return null;
        }
        return new SysTeacherProjectResp()
                .setProjectId(sysTeacherProjectEntity.getProjectId())
                .setProjectPm(sysTeacherProjectEntity.getProjectPm())
                .setProjectName(sysTeacherProjectEntity.getProjectName())
                .setSchoolName(sysTeacherProjectEntity.getSchoolName())
                .setUserName(sysTeacherProjectEntity.getProjectUser())
                .setProjectTea(sysTeacherProjectEntity.getProjectTea());
    }

    @Override
    public SysTeacherProjectShenResp teacher1(SysTeacherProjectReq sysTeacherProjectReq) {
        LambdaQueryWrapper<SysTeacherProjectShenEntity> queryWrapper = new QueryWrapper<SysTeacherProjectShenEntity>().lambda()
                .eq(SysTeacherProjectShenEntity::getProjectId, sysTeacherProjectReq.getProjectId());
        SysTeacherProjectShenEntity sysTeacherProjectShenEntity = sysTeacherProjectShenMapper.selectOne(queryWrapper);
        if (Objects.isNull(sysTeacherProjectShenEntity)) {
            return null;
        }
        return new SysTeacherProjectShenResp()
                .setProjectOne(sysTeacherProjectShenEntity.getProjectOne())
                .setProjectTwo(sysTeacherProjectShenEntity.getProjectTwo());
    }
}
