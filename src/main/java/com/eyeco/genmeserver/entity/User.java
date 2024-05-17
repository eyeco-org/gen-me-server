package com.eyeco.genmeserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    @Id
    private String nickname;
    private int isAdmin;
    private String name;


    protected User() {

    }

    public User(String nickname, int isAdmin, String name) {
        this.nickname = nickname;
        this.isAdmin = isAdmin;
        this.name = name;
    }


}
