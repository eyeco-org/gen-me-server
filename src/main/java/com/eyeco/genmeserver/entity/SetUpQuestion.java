package com.eyeco.genmeserver.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SetUpQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int setUpQuestionId;

    private int gameId;

    private int setUpQuestionNum;

    private String questionContent;

    public SetUpQuestion(int gameId, int setUpQuestionNum, String questionContent){
        this.gameId = gameId;
        this.setUpQuestionNum = setUpQuestionNum;
        this.questionContent = questionContent;
    }

}
