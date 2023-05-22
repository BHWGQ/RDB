package com.example.rdb.controller;

import com.example.rdb.req.SysUserProjectReq;
import com.example.rdb.resp.Response;
import com.example.rdb.resp.ResponseCodeEnum;
import com.example.rdb.resp.ResponseUtil;
import com.example.rdb.resp.SysUserProjectResp;
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
    public Response<SysUserProjectResp> look1(@RequestBody SysUserProjectReq req) {
        SysUserProjectResp userProjectResp = sysUserProjectService.look(req);
        if (Objects.isNull(userProjectResp)) {
            return ResponseUtil.create(ResponseCodeEnum.PROJECT_FAIL, null);
        }
        return ResponseUtil.create(ResponseCodeEnum.OK, userProjectResp);
    }
}