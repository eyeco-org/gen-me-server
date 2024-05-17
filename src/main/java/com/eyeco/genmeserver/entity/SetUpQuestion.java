package com.eyeco.genmeserver.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetUpQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int setUpQuestionId;

    @JoinColumn(name = "gameId")
    private Game game;

    @JoinColumn(name = "nickname")
    @ManyToOne
    private User user;

    private int setUpQuestionNum;

    private String questionContent;


    protected SetUpQuestion() {

    }

    public SetUpQuestion(Game game, User user, int questionNum, String content) {
        this.game = game;
        this.user = user;
        this.setUpQuestionNum = questionNum;
        this.questionContent = content;
    }


}
