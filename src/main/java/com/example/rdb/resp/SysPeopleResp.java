package com.example.rdb.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SysPeopleResp {
    private String peopleCha;

    private String peopleLian;

    private String peopleTeam;

    private String peopleWhat;

    private String peopleLook;

    private String peopleBs;
}
