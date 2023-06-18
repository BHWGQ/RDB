package com.example.rdb.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.rdb.entity.SysUserProjectEntity;
import com.example.rdb.req.SysUserProjectReq;
import com.example.rdb.resp.*;
import com.example.rdb.service.SysUserProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class SysUserProjectController {

    @Autowired
    private SysUserProjectService sysUserProjectService;

    @PostMapping("/look")
    public Response<SysUserResp> look1(@RequestBody SysUserProjectReq req) {
        SysUserProjectResp userProjectResp = sysUserProjectService.look(req);
        SysUserProjectShenResp sysUserProjectShenResp = sysUserProjectService.took(req);
        if ((Objects.isNull(userProjectResp)) | (Objects.isNull(sysUserProjectShenResp))) {
            return ResponseUtil.create(ResponseCodeEnum.PROJECT_FAIL, null);
        }
        SysUserResp sysUserResp = new SysUserResp();
        sysUserResp.setSysUserProjectResp(userProjectResp)
                .setSysUserProjectShenResp(sysUserProjectShenResp);
        return ResponseUtil.create(ResponseCodeEnum.OK, sysUserResp);
    }

    @GetMapping("/selectAll")
    public Response<List<SysUserProjectEntity>> listResponse(@RequestParam Integer a) {
        List<SysUserProjectEntity> sysUserProjectEntities = sysUserProjectService.selectAll(a);
        if (Objects.isNull(sysUserProjectEntities)) {
            return ResponseUtil.create(ResponseCodeEnum.UPDATE_FAIL, null);
        }
        List<SysUserProjectEntity> respList = sysUserProjectEntities.stream()
                .map(entity -> BeanUtil.copyProperties(entity, SysUserProjectEntity.class)).collect(Collectors.toList());
        return ResponseUtil.create(ResponseCodeEnum.OK, respList);
    }
}
