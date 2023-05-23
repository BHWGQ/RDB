package com.example.rdb.controller;

import com.example.rdb.req.SysUserProjectReq;
import com.example.rdb.resp.*;
import com.example.rdb.service.SysUserProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

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
}
