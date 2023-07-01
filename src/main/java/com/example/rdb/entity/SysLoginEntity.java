package com.example.rdb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("loginlog")
public class SysLoginEntity {
    private Long id;
    private String loginName;
    private String ip;
    private String time;
}
