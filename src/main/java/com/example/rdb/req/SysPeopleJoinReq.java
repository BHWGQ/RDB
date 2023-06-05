package com.example.rdb.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPeopleJoinReq {

    private String peopleCha;

    private String peopleLian;

    private String peopleClass;

    private String peopleWhat;

    private String peopleBs;
}
