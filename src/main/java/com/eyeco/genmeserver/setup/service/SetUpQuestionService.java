package com.eyeco.genmeserver.setup.service;

import com.eyeco.genmeserver.dto.InputDataDto;
import com.eyeco.genmeserver.setup.repository.SetUpQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SetUpQuestionService {
    private final SetUpQuestionRepository setUpQuestionRepository;

    public boolean existsByGameId(InputDataDto inputDataDto){
        return setUpQuestionRepository.existsByGameId(inputDataDto.getGameId());
    }
}
