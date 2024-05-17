package com.eyeco.genmeserver.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class GameQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameQuestionId;

    private String nickname;

    private String userQuestion;

    private String generatedAnswer;

    public GameQuestion(String nickname, String userQuestion, String generatedAnswer) {
        this.nickname = nickname;
        this.userQuestion = userQuestion;
        this.generatedAnswer = generatedAnswer;
    }


}

