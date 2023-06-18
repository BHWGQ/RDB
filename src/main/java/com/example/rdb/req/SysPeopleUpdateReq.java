package com.example.rdb.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPeopleUpdateReq {
    private String peopleCha;

    private String peopleLian;

    private String peopleTeam;

    private String peopleWhat;

    private String peopleLook;

    private String peopleBs;

    private String peopleNewWhat;

    private String peopleNewLook;
}
