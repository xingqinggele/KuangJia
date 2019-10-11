package com.zhhl.kuangjia.bean;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.util.List;

/**
 * Created by qgl on 2019/9/25 8:52.
 */
public class User extends SugarRecord {
    @Unique
    String name;
    String password;


    public User() {

    }

    public User(String name, String password) {

        this.name = name;
        this.password = password;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
