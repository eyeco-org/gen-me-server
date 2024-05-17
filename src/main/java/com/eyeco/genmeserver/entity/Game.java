package com.eyeco.genmeserver.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameId;

    private String nickname;

    private int memberCount;

    public Game(String nickname, Integer memberCount) {
        this.nickname = nickname;
        this.memberCount = memberCount;
    }
}
