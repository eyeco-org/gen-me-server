package com.eyeco.genmeserver.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetUpAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int setUpAnswerId;

    @JoinColumn(name = "questionId")
    private SetUpQuestion setUpQuestion;

    @JoinColumn(name = "nickname")
    @ManyToOne
    private User user;

    private String answerContent;

    protected SetUpAnswer() {

    }

    public SetUpAnswer(SetUpQuestion setUpQuestion, User user, String content) {
        this.setUpQuestion = setUpQuestion;
        this.user = user;
        this.answerContent = content;
    }


}
