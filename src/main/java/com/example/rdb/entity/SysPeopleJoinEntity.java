package com.example.rdb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("people_join")
public class SysPeopleJoinEntity {
    @TableField("people_cha")
    private String peopleCha;

    @TableField("people_lian")
    private String peopleLian;

    @TableField("people_class")
    private String peopleClass;

    @TableField("people_what")
    private String peopleWhat;

    @TableField("people_bs")
    private String peopleBs;
}
