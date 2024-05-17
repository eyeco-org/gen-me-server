package com.eyeco.genmeserver.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SetUpQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int setUpQuestionId;

    private int gameId;

    private String nickname;

    private int setUpQuestionNum;

    private String questionContent;

}
