package com.example.rdb.req;

public class SysUserLoginReq {

    private long id;


    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SysUserLoginReq{" +
                "id=" + id +
                ", password='" + password + '\'' +
                '}';
    }
}
