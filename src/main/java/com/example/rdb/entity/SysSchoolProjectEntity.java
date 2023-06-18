package com.example.rdb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("school_project")
public class SysSchoolProjectEntity {
    @TableField("project_id")
    private long projectId;

    @TableField("project_name")
    private String projectName;

    @TableField("project_pm")
    private String projectPm;

    @TableField("school_name")
    private String schoolName;

    @TableField("professional")
    private String professional;
}
