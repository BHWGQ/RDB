package com.example.rdb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.rdb.entity.SysUserProjectEntity;
import com.example.rdb.entity.SysUserProjectShenEntity;
import com.example.rdb.mapper.SysUserProjectMapper;
import com.example.rdb.mapper.SysUserProjectShenMapper;
import com.example.rdb.req.SysUserProjectReq;
import com.example.rdb.resp.SysUserProjectResp;
import com.example.rdb.resp.SysUserProjectShenResp;
import com.example.rdb.service.SysUserProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class SysUserProjectImpl extends ServiceImpl<SysUserProjectMapper, SysUserProjectEntity> implements SysUserProjectService {
    @Resource
    private SysUserProjectMapper sysUserProjectMapper;
    @Resource
    private SysUserProjectShenMapper sysUserProjectShenMapper;

    @Override
    public SysUserProjectResp look(SysUserProjectReq req) {
        LambdaQueryWrapper<SysUserProjectEntity> queryWrapper = new QueryWrapper<SysUserProjectEntity>().lambda()
                .eq(SysUserProjectEntity::getProjectId, req.getProjectId())
                .eq(SysUserProjectEntity::getUserName, req.getUserName())
                .eq(SysUserProjectEntity::getProjectHid, req.getId());
        SysUserProjectEntity sysUserProjectEntity = sysUserProjectMapper.selectOne(queryWrapper);
        if (Objects.isNull(sysUserProjectEntity)) {
            return null;
        }
        return new SysUserProjectResp()
                .setProjectId(sysUserProjectEntity.getProjectId())
                .setProjectName(sysUserProjectEntity.getProjectName())
                .setUserName(sysUserProjectEntity.getUserName())
                .setId(sysUserProjectEntity.getProjectHid())
                .setSchoolName(sysUserProjectEntity.getSchoolName())
                .setProjectPm(sysUserProjectEntity.getProjectPm());
    }

    @Override
    public SysUserProjectShenResp took(SysUserProjectReq req) {
        LambdaQueryWrapper<SysUserProjectShenEntity> queryWrapper = new QueryWrapper<SysUserProjectShenEntity>().lambda()
                .eq(SysUserProjectShenEntity::getProjectId, req.getProjectId());
        SysUserProjectShenEntity sysUserProjectShenEntity = sysUserProjectShenMapper.selectOne(queryWrapper);
        if (Objects.isNull(sysUserProjectShenEntity)) {
            return null;
        }
        return new SysUserProjectShenResp()
                .setProjectOne(sysUserProjectShenEntity.getProjectOne())
                .setProjectTwo(sysUserProjectShenEntity.getProjectTwo());
    }

    @Override
    public List<SysUserProjectEntity> selectAll(Integer a) {
        return sysUserProjectMapper.selectList(null);
    }

}
