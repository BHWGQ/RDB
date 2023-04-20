package com.example.rdb;

import org.springframework.util.DigestUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println(DigestUtils.md5DigestAsHex("20031028".getBytes()));
    }

}
