package com.example.rdb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.rdb.entity.SysPeopleJoinEntity;
import com.example.rdb.mapper.SysPeopleJoinMapper;
import com.example.rdb.req.SysPeopleJoinReq;
import com.example.rdb.resp.SysPeopleJoinInsertResp;
import com.example.rdb.service.SysPeopleJoinService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class SysPeopleJoinServiceImpl extends ServiceImpl<SysPeopleJoinMapper, SysPeopleJoinEntity> implements SysPeopleJoinService {
    @Resource
    private SysPeopleJoinMapper sysPeopleJoinMapper;

    @Override
    public List<SysPeopleJoinEntity> selectAll1(Integer a) {
        return sysPeopleJoinMapper.selectList(null);
    }

    @Override
    public SysPeopleJoinInsertResp zr(SysPeopleJoinReq req) {
        LambdaQueryWrapper<SysPeopleJoinEntity> queryWrapper = new QueryWrapper<SysPeopleJoinEntity>().lambda()
                .eq(SysPeopleJoinEntity::getPeopleBs, req.getPeopleBs())
                .eq(SysPeopleJoinEntity::getPeopleCha, req.getPeopleCha())
                .eq(SysPeopleJoinEntity::getPeopleClass, req.getPeopleClass())
                .eq(SysPeopleJoinEntity::getPeopleLian, req.getPeopleLian())
                .eq(SysPeopleJoinEntity::getPeopleWhat, req.getPeopleWhat());
        SysPeopleJoinEntity sysPeopleJoinEntity = sysPeopleJoinMapper.selectOne(queryWrapper);
        if (Objects.isNull(sysPeopleJoinEntity)) {
            SysPeopleJoinEntity sysPeopleJoinEntity1 = new SysPeopleJoinEntity(req.getPeopleCha(), req.getPeopleLian(), req.getPeopleClass(), req.getPeopleWhat(), req.getPeopleBs());
            sysPeopleJoinMapper.insert(sysPeopleJoinEntity1);
            return new SysPeopleJoinInsertResp().setPeopleCha(req.getPeopleCha());
        }
        return null;
    }
}
