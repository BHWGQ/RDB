package com.example.rdb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_project_shen")
public class SysUserProjectShenEntity {
    @TableField("project_id")
    private String projectId;

    @TableField("project_name")
    private String projectName;

    @TableField("project_user")
    private String userName;

    @TableField("project_one")
    private String projectOne;

    @TableField("project_two")
    private String projectTwo;
}
