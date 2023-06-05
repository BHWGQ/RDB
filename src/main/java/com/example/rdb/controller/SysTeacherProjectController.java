package com.example.rdb.controller;

import com.example.rdb.req.SysTeacherProjectReq;
import com.example.rdb.resp.*;
import com.example.rdb.service.SysTeacherProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

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

}
