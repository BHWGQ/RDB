package com.example.rdb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.rdb.entity.SysUserEntity;
import com.example.rdb.mapper.SysUserMapper;
import com.example.rdb.req.SysUserLoginReq;
import com.example.rdb.req.SysUserSaveReq;
import com.example.rdb.resp.SysUserLoginResp;
import com.example.rdb.resp.SysUserRegisterResp;
import com.example.rdb.service.SysUserService;
import com.example.rdb.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Autowired
    private SnowFlake snowFlake;


    @Override
    public SysUserRegisterResp register(SysUserSaveReq req) {
        LambdaQueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<SysUserEntity>().lambda()
                .eq(SysUserEntity::getId, req.getId());
        SysUserEntity sysUserEntity = sysUserMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(sysUserEntity)) {
            SysUserEntity sysUserEntity1 = new SysUserEntity(req.getId(), req.getLoginName(), DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
            sysUserMapper.insert(sysUserEntity1);
            return new SysUserRegisterResp().setId(sysUserEntity1.getId());
        }
        return null;
    }

    @Override
    public SysUserLoginResp login(SysUserLoginReq req) {
        LambdaQueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<SysUserEntity>().lambda()
                .eq(SysUserEntity::getId, req.getId())
                .eq(SysUserEntity::getPassword, req.getPassword());
        SysUserEntity sysUserEntity = sysUserMapper.selectOne(queryWrapper);
        if (Objects.isNull(sysUserEntity)) {
            return null;
        }
        return new SysUserLoginResp()
                .setId(sysUserEntity.getId())
                .setLoginName(sysUserEntity.getLoginName());
    }

    @Override
    public List<SysUserEntity> selectAll(Integer a) {
        return sysUserMapper.selectList(null);
    }

    //查询loginName是否被注册
    public SysUserEntity selectByLoginName(String loginName) {
        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUserEntity::getLoginName, loginName);
        List<SysUserEntity> userEntityList = sysUserMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(userEntityList)) {
            return null;
        } else {
            return userEntityList.get(0);
        }
    }
}
