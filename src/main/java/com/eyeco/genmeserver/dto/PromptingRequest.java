package com.eyeco.genmeserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class PromptingRequest {
    private String nickname;
    private String question;
}
