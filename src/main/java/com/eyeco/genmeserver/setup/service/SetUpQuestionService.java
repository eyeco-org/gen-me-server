package com.eyeco.genmeserver.setup.service;

import com.eyeco.genmeserver.dto.InputDataDto;
import com.eyeco.genmeserver.entity.SetUpAnswer;
import com.eyeco.genmeserver.entity.SetUpQuestion;
import com.eyeco.genmeserver.setup.repository.SetUpAnswerRepository;
import com.eyeco.genmeserver.setup.repository.SetUpQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SetUpQuestionService {
    private final SetUpQuestionRepository setUpQuestionRepository;

    private final SetUpAnswerRepository setUpAnswerRepository;

    private String message;

    public String inputData(InputDataDto inputDataDto){
        if(setUpQuestionRepository.existsByGameId(inputDataDto.getGameId())){
            String[] questionArr = {"스택", "MBTI", "주요 활동지", "나를 소개해주세요", "취미와 관심사는요"};
            for(int i = 1; i < questionArr.length + 1; i++) {
                SetUpQuestion setUpQuestion = SetUpQuestion.builder()
                        .setUpQuestionNum(i)
                        .questionContent(questionArr[i - 1])
                        .build();
                setUpQuestionRepository.save(setUpQuestion);
            }
        }
        for(int i = 1; i < inputDataDto.getStrArr().length + 1; i++){
            SetUpAnswer setUpAnswer = SetUpAnswer.builder()
                            .nickname(inputDataDto.getNickname())
                                    .answerContent(inputDataDto.getStrArr()[i-1])
                                            .build();
            setUpAnswerRepository.save(setUpAnswer);
        }

        return "입력에 성공했습니다.";
    }
}
