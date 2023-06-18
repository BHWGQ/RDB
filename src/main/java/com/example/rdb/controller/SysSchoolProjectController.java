package com.example.rdb.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.rdb.entity.SysSchoolProjectEntity;
import com.example.rdb.resp.Response;
import com.example.rdb.resp.ResponseCodeEnum;
import com.example.rdb.resp.ResponseUtil;
import com.example.rdb.service.SysSchoolProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ss")
public class SysSchoolProjectController {
    @Autowired
    private SysSchoolProjectService sysSchoolProjectService;

    @GetMapping("/selectAll")
    public Response<List<SysSchoolProjectEntity>> listResponse(@RequestParam Integer a) {
        List<SysSchoolProjectEntity> sysSchoolProjectEntities = sysSchoolProjectService.selectAll(a);
        if (Objects.isNull(sysSchoolProjectEntities)) {
            return ResponseUtil.create(ResponseCodeEnum.UPDATE_FAIL, null);
        }
        List<SysSchoolProjectEntity> sysSchoolProjectEntities1 = sysSchoolProjectEntities.stream()
                .map(entity -> BeanUtil.copyProperties(entity, SysSchoolProjectEntity.class)).collect(Collectors.toList());
        return ResponseUtil.create(ResponseCodeEnum.OK, sysSchoolProjectEntities1);
    }
}
