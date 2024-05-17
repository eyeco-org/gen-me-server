package com.eyeco.genmeserver.game.controller;

import com.eyeco.genmeserver.dto.InputDataDto;
import com.eyeco.genmeserver.dto.ResponseDto;
import com.eyeco.genmeserver.game.repository.GameRepository;
import com.eyeco.genmeserver.setup.repository.SetUpQuestionRepository;
import com.eyeco.genmeserver.setup.service.SetUpQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {
    private final SetUpQuestionService setUpQuestionService;

    private String message;

    @PostMapping()
    public ResponseEntity<ResponseDto<String>> inputData(InputDataDto inputDataDto){
        boolean flag = setUpQuestionService.existsByGameId(inputDataDto);
        ResponseDto<String> responseDto = ResponseDto.success();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

}
