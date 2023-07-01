package com.example.rdb.controller;

import com.example.rdb.req.SysLoginSelectReq;
import com.example.rdb.resp.Response;
import com.example.rdb.resp.ResponseCodeEnum;
import com.example.rdb.resp.ResponseUtil;
import com.example.rdb.resp.SysLoginSelectResp;
import com.example.rdb.service.SysLoginSelectService;
import com.example.rdb.utils.CusAccessObjectUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/loginSelect")
public class SysLoginSelectController {
    @Resource
    private SysLoginSelectService service;

    @PostMapping("/insert")
    public Response<SysLoginSelectResp> loginSelectRespResponse(@RequestBody SysLoginSelectReq req, HttpServletRequest request) {
        String ip = CusAccessObjectUtil.getIpAddress(request);
        req.setIp(ip);
        SysLoginSelectResp sysLoginSelectResp = service.inter(req);
        return ResponseUtil.create(ResponseCodeEnum.OK, sysLoginSelectResp);
    }
}
