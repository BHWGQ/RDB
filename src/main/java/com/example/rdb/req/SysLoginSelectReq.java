package com.example.rdb.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysLoginSelectReq {
    private Long id;
    private String loginName;
    private String ip;
    private String time;
}
