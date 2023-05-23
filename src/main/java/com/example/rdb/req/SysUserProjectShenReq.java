package com.example.rdb.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserProjectShenReq {
    private String projectId;

    private String projectName;

    private String userName;
}
