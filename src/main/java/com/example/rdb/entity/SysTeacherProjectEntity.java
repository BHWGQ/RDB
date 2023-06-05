package com.example.rdb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("teacher_project")
public class SysTeacherProjectEntity {

    private String projectId;

    private String projectName;

    private String projectUser;

    @TableField("project_tuser")
    private String projectTea;

    private String schoolName;

    private String projectPm;

}
