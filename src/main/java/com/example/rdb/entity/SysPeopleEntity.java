package com.example.rdb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("people_manage")
public class SysPeopleEntity {
    @TableField("people_cha")
    private String peopleCha;

    @TableField("people_lian")
    private String peopleLian;

    @TableField("people_team")
    private String peopleTeam;

    @TableField("people_what")
    private String peopleWhat;

    @TableField("people_look")
    private String peopleLook;

    @TableField("people_bs")
    private String peopleBs;
}
