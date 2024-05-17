package com.eyeco.genmeserver.dto;

import com.eyeco.genmeserver.entity.SetUpQuestion;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;

@Getter
public class InputDataDto {
    int gameId;
    String[] strArr;
    String nickname;
}
