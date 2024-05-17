package com.eyeco.genmeserver.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameId;

    @JoinColumn(name = "nickname")
    private User user;

    private Integer memberCount;


    protected Game() {

    }

    public Game(User user, Integer memberCount) {
        this.user = user;
        this.memberCount = memberCount;
    }
}
