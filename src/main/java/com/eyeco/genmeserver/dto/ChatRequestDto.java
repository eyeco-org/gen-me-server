package com.eyeco.genmeserver.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRequestDto {

    private String role;

    private String content;

    @Builder
    public ChatRequestDto(String role, String content) {
        this.role = role;
        this.content = content;
    }
}