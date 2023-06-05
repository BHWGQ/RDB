package com.example.rdb.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysTeacherProjectReq {
    private String projectId;
    private String projectName;
    private String userName;
    private String projectTea;
    private String schoolName;
}
