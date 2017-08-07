package com.tae.domain;

/**
 * Created by Taeyeon-Serenity on 2017/7/31.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 系统角色
 * */
public class Role {
    private Long rid;
    private String rname;

    //多对多 编写都是集合
    private Set<User> users=new HashSet<User>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}
