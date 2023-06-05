package com.example.rdb.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SysTeacherProjectResp {
    private String projectId;

    private String projectName;

    private String userName;

    private String projectTea;

    private String schoolName;

    private String projectPm;
}
