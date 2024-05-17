package com.eyeco.genmeserver.dto;

import lombok.*;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatCompletionDto {

    // 사용할 모델
    private String model;

    private List<ChatRequestDto> messages;

    @Builder
    public ChatCompletionDto(List<ChatRequestDto> messages) {
        this.model = "gpt-3.5-turbo";
        this.messages = messages;
    }

}