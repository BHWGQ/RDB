package com.example.rdb.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.rdb.entity.SysTeacherProjectEntity;
import com.example.rdb.req.SysTeacherProjectReq;
import com.example.rdb.resp.*;
import com.example.rdb.service.SysTeacherProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tea")
public class SysTeacherProjectController {
    @Autowired
    private SysTeacherProjectService sysTeacherProjectService;

    @PostMapping("/t")
    public Response<SysTeacherProjectAllResp> tea(@RequestBody SysTeacherProjectReq req) {
        SysTeacherProjectResp sysTeacherProjectResp = sysTeacherProjectService.teacher(req);
        SysTeacherProjectShenResp sysTeacherProjectShenResp = sysTeacherProjectService.teacher1(req);
        if ((Objects.isNull(sysTeacherProjectResp)) | (Objects.isNull(sysTeacherProjectShenResp))) {
            return ResponseUtil.create(ResponseCodeEnum.PROJECT_FAIL, null);
        }
        SysTeacherProjectAllResp sysTeacherProjectAllResp = new SysTeacherProjectAllResp();
        sysTeacherProjectAllResp.setSysTeacherProjectResp(sysTeacherProjectResp)
                .setSysTeacherProjectShenResp(sysTeacherProjectShenResp);
        return ResponseUtil.create(ResponseCodeEnum.OK, sysTeacherProjectAllResp);
    }

    @GetMapping("/selectAll")
    public Response<List<SysTeacherProjectEntity>> listResponse(@RequestParam Integer a) {
        List<SysTeacherProjectEntity> list = sysTeacherProjectService.selectAll(a);
        if (Objects.isNull(list)) {
            return ResponseUtil.create(ResponseCodeEnum.UPDATE_FAIL, null);
        }
        List<SysTeacherProjectEntity> list1 = list.stream()
                .map(entity -> BeanUtil.copyProperties(entity, SysTeacherProjectEntity.class)).collect(Collectors.toList());
        return ResponseUtil.create(ResponseCodeEnum.OK, list1);
    }

}
