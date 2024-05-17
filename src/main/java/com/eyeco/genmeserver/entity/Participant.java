package com.eyeco.genmeserver.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Participant {
    @Id
    @JoinColumn(name = "nickname")
    private User user;

    @JoinColumn(name = "gameId")
    private Game game;

    private Integer score;


    protected Participant() {

    }

    public Participant(User user, Game game, Integer score) {
        this.user = user;
        this.game = game;
        this.score = score;
    }

}
