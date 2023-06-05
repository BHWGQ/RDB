package com.example.rdb.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.rdb.entity.SysPeopleJoinEntity;
import com.example.rdb.req.SysPeopleJoinReq;
import com.example.rdb.resp.*;
import com.example.rdb.service.SysPeopleJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/oo")
public class SysPeopleJoinController {
    @Autowired
    private SysPeopleJoinService sysPeopleJoinService;

    @GetMapping("/selectAll1")
    public Response<List<SysPeopleJoinResp>> listResponse(@RequestParam Integer a) {

        List<SysPeopleJoinEntity> sysPeopleJoinEntityList = sysPeopleJoinService.selectAll1(a);
        if (Objects.isNull(sysPeopleJoinEntityList)) {
            return ResponseUtil.create(ResponseCodeEnum.UPDATE_FAIL, null);
        }
        List<SysPeopleJoinResp> respList = sysPeopleJoinEntityList.stream()
                .map(entity -> BeanUtil.copyProperties(entity, SysPeopleJoinResp.class)).collect(Collectors.toList());
        return ResponseUtil.create(ResponseCodeEnum.OK, respList);
    }

    @PostMapping("/zdw")
    public Response<SysPeopleJoinInsertResp> sysPeopleJoinInsertResp(@RequestBody SysPeopleJoinReq req) {
        SysPeopleJoinInsertResp sysPeopleJoinInsertResp = sysPeopleJoinService.zr(req);
        if (Objects.isNull(sysPeopleJoinInsertResp)) {
            return ResponseUtil.create(ResponseCodeEnum.UPDATE_FAIL, null);
        }
        return ResponseUtil.create(ResponseCodeEnum.OK, sysPeopleJoinInsertResp);
    }
}
