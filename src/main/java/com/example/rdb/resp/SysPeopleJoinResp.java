package com.example.rdb.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SysPeopleJoinResp {
    private String peopleCha;

    private String peopleLian;

    private String peopleClass;

    private String peopleWhat;

    private String peopleBs;
}
