package com.eyeco.genmeserver.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int participantId;

    private String nickname;

    private int gameId;

    private int score;

    private int isReady;

    private int image;

}
