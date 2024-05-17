package com.eyeco.genmeserver.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SetUpAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int setUpAnswerId;

    private int questionId;

    private String nickname;

    @Column(length = 65535)
    private String answerContent;


    public SetUpAnswer(int questionId, String nickname, String answerContent) {
        this.questionId = questionId;
        this.nickname = nickname;
        this.answerContent = answerContent;
    }


}
