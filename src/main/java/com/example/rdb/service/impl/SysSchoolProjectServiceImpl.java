package com.example.rdb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.rdb.entity.SysSchoolProjectEntity;
import com.example.rdb.mapper.SysSchoolProjectMapper;
import com.example.rdb.service.SysSchoolProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysSchoolProjectServiceImpl extends ServiceImpl<SysSchoolProjectMapper, SysSchoolProjectEntity> implements SysSchoolProjectService {
    @Resource
    private SysSchoolProjectMapper sysSchoolProjectMapper;

    @Override
    public List<SysSchoolProjectEntity> selectAll(Integer a) {
        return sysSchoolProjectMapper.selectList(null);
    }
}
