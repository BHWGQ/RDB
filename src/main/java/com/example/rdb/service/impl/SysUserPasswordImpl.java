package com.example.rdb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.rdb.entity.SysUserEntity;
import com.example.rdb.mapper.SysUserMapper;
import com.example.rdb.req.SysUserPasswordReq;
import com.example.rdb.resp.SysUserPasswordResp;
import com.example.rdb.service.SysUserPasswordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class SysUserPasswordImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserPasswordService {

    @Resource
    private SysUserMapper sysUserMapper;


    @Override
    public SysUserPasswordResp updatePass(SysUserPasswordReq req) {
        LambdaQueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<SysUserEntity>().lambda()
                .eq(SysUserEntity::getId, req.getId())
                .eq(SysUserEntity::getLoginName, req.getLoginName())
                .eq(SysUserEntity::getPassword, req.getPass());
        SysUserEntity sysUserEntity = sysUserMapper.selectOne(queryWrapper);
        if (Objects.isNull(sysUserEntity)) {
            return null;
        }
        LambdaUpdateWrapper<SysUserEntity> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(SysUserEntity::getId, req.getId())
                .eq(SysUserEntity::getLoginName, req.getLoginName())
                .set(SysUserEntity::getPassword, req.getNewpass());
        sysUserMapper.update(null, lambdaUpdateWrapper);
        return new SysUserPasswordResp()
                .setId(sysUserEntity.getId())
                .setLoginName(sysUserEntity.getLoginName());
    }
}
