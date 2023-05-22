package com.example.rdb.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserPasswordReq {
    private long id;
    private String loginName;
    private String pass;
    private String newpass;
}
