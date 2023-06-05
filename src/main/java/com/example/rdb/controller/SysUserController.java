package com.example.rdb.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.rdb.entity.SysUserEntity;
import com.example.rdb.req.SysUserLoginReq;
import com.example.rdb.req.SysUserSaveReq;
import com.example.rdb.resp.*;
import com.example.rdb.service.SysUserService;
import com.example.rdb.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @GetMapping("/su")
    public Response<List<SysUserSelectResp>> userSelect(@RequestParam Integer a) {
        List<SysUserEntity> sysUserEntities = sysUserService.selectAll(a);
        if (Objects.isNull(sysUserEntities)) {
            return ResponseUtil.create(ResponseCodeEnum.UPDATE_FAIL, null);
        }
        List<SysUserSelectResp> selectList = sysUserEntities.stream()
                .map(entity -> BeanUtil.copyProperties(entity, SysUserSelectResp.class)).collect(Collectors.toList());
        return ResponseUtil.create(ResponseCodeEnum.OK, selectList);
    }

}
