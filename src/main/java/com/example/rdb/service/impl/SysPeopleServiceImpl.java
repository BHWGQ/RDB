package com.example.rdb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.rdb.entity.SysPeopleEntity;
import com.example.rdb.mapper.SysPeopleMapper;
import com.example.rdb.req.SysPeopleReq;
import com.example.rdb.resp.SysPeopleInsertResp;
import com.example.rdb.service.SysPeopleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class SysPeopleServiceImpl extends ServiceImpl<SysPeopleMapper, SysPeopleEntity> implements SysPeopleService {
    @Resource
    private SysPeopleMapper sysPeopleMapper;

    @Override
    public List<SysPeopleEntity> selectAll(Integer a) {
        return sysPeopleMapper.selectList(null);
    }

    @Override
    public SysPeopleInsertResp s1(SysPeopleReq req) {
        LambdaQueryWrapper<SysPeopleEntity> queryWrapper = new QueryWrapper<SysPeopleEntity>().lambda()
                .eq(SysPeopleEntity::getPeopleCha, req.getPeopleCha())
                .eq(SysPeopleEntity::getPeopleLian, req.getPeopleLian())
                .eq(SysPeopleEntity::getPeopleTeam, req.getPeopleTeam())
                .eq(SysPeopleEntity::getPeopleWhat, req.getPeopleWhat())
                .eq(SysPeopleEntity::getPeopleLook, req.getPeopleLook())
                .eq(SysPeopleEntity::getPeopleBs, req.getPeopleBs());
        SysPeopleEntity sysPeopleEntity = sysPeopleMapper.selectOne(queryWrapper);
        if (Objects.isNull(sysPeopleEntity)) {
            SysPeopleEntity sysPeopleEntity1 = new SysPeopleEntity(req.getPeopleCha(), req.getPeopleLian(), req.getPeopleTeam(), req.getPeopleWhat(), req.getPeopleLook(), req.getPeopleBs());
            sysPeopleMapper.insert(sysPeopleEntity1);
            return new SysPeopleInsertResp()
                    .setPeopleCha(req.getPeopleCha());
        }
        return null;
    }
}
