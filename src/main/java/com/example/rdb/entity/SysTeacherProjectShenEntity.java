package com.example.rdb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("teacher_project_xiao")
public class SysTeacherProjectShenEntity {
    private String projectId;

    private String projectName;

    private String projectUser;

    private String projectOne;

    private String projectTwo;
}
