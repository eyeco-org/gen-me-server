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
    public ChatCompletionDto(String model, List<ChatRequestDto> messages) {
        this.model = model;
        this.messages = messages;
    }

}