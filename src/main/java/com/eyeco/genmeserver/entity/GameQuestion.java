package com.eyeco.genmeserver.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameQuestionId;

    @JoinColumn(name = "nickname")
    @ManyToOne
    private User user;

    private String userQuestion;

    private String generatedAnswer;


    protected GameQuestion() {

    }

    public GameQuestion(User user, String userQuestion, String generatedAnswer) {
        this.user = user;
        this.userQuestion = userQuestion;
        this.generatedAnswer = generatedAnswer;
    }


}

