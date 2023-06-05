package com.example.rdb.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.rdb.entity.SysPeopleEntity;
import com.example.rdb.req.SysPeopleReq;
import com.example.rdb.resp.*;
import com.example.rdb.service.SysPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cha")
public class SysPeopleContorller {
    @Autowired
    private SysPeopleService sysPeopleService;

    @GetMapping("/selectAll")
    public Response<List<SysPeopleResp>> listResponse(@RequestParam Integer a) {

        List<SysPeopleEntity> sysPeopleEntityList = sysPeopleService.selectAll(a);
        if (Objects.isNull(sysPeopleEntityList)) {
            return ResponseUtil.create(ResponseCodeEnum.UPDATE_FAIL, null);
        }
        List<SysPeopleResp> respList = sysPeopleEntityList.stream()
                .map(entity -> BeanUtil.copyProperties(entity, SysPeopleResp.class)).collect(Collectors.toList());
        return ResponseUtil.create(ResponseCodeEnum.OK, respList);
    }

    @PostMapping("/zdw")
    public Response<SysPeopleInsertResp> sysPeopleInsertRespResponse(@RequestBody SysPeopleReq req) {
        SysPeopleInsertResp sysPeopleInsertResp = sysPeopleService.s1(req);
        if (Objects.isNull(sysPeopleInsertResp)) {
            return ResponseUtil.create(ResponseCodeEnum.UPDATE_FAIL, null);
        }
        return ResponseUtil.create(ResponseCodeEnum.OK, sysPeopleInsertResp);
    }

}
