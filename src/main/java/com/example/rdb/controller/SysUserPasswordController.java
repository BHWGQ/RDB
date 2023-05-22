package com.example.rdb.controller;

import com.example.rdb.req.SysUserPasswordReq;
import com.example.rdb.resp.Response;
import com.example.rdb.resp.ResponseCodeEnum;
import com.example.rdb.resp.ResponseUtil;
import com.example.rdb.resp.SysUserPasswordResp;
import com.example.rdb.service.SysUserPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/user")
public class SysUserPasswordController {
    @Autowired
    private SysUserPasswordService sysUserPasswordService;

    @PostMapping("/updatepass")
    public Response<SysUserPasswordResp> updatePass1(@RequestBody SysUserPasswordReq req) {
        req.setPass(DigestUtils.md5DigestAsHex(req.getPass().getBytes()));
        req.setNewpass(DigestUtils.md5DigestAsHex(req.getNewpass().getBytes()));
        SysUserPasswordResp userPasswordResp = sysUserPasswordService.updatePass(req);
        if (Objects.isNull(userPasswordResp)) {
            return ResponseUtil.create(ResponseCodeEnum.UPDATE_FAIL, null);
        }
        return ResponseUtil.create(ResponseCodeEnum.OK, userPasswordResp);
    }
}
