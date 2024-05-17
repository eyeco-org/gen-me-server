package com.eyeco.genmeserver.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRequestDto {

    private String role;

    private String content;

    @Builder
    public ChatRequestDto(String content) {
        this.role = "user";
        this.content = content;
    }
}