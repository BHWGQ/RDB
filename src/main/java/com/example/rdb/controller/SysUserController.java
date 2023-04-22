package com.example.rdb.controller;

import com.example.rdb.req.SysUserLoginReq;
import com.example.rdb.req.SysUserSaveReq;
import com.example.rdb.resp.*;
import com.example.rdb.service.SysUserService;
import com.example.rdb.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("/user_manager")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/register")
    public Response<SysUserRegisterResp> register(@RequestBody SysUserSaveReq req) {
        SysUserRegisterResp userRegisterResp = sysUserService.register(req);
        if (Objects.isNull(userRegisterResp)) {
            return ResponseUtil.create(ResponseCodeEnum.FAIL, null);
        }
        return ResponseUtil.create(ResponseCodeEnum.OK, userRegisterResp);
    }

    @PostMapping("/login")
    public Response<SysUserLoginResp> login(@RequestBody SysUserLoginReq req) {
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        SysUserLoginResp user = sysUserService.login(req);
        if (Objects.isNull(user)) {
            return ResponseUtil.create(ResponseCodeEnum.LOGIN_FAIL, null);
        }
        // TODO: 2023/4/18 创建 token 并返回给前端
        String token = JwtUtil.sign(new HashMap<String, Object>() {{
            put("id", user.getId());
        }});
        user.setToken(token);
        return ResponseUtil.create(ResponseCodeEnum.OK, user);
    }
}
