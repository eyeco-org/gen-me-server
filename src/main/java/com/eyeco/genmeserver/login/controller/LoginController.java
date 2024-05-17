package com.eyeco.genmeserver.login.controller;

import com.eyeco.genmeserver.dto.ResponseDto;
import com.eyeco.genmeserver.dto.StartDto;
import com.eyeco.genmeserver.game.service.GameService;
import com.eyeco.genmeserver.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/start")
@RequiredArgsConstructor
public class LoginController {

    private final GameService gameService;

    private final LoginService loginService;

    private String message;

    @PostMapping()
    public ResponseEntity<ResponseDto<String>> startGame(@RequestBody StartDto startDto){
        if(loginService.checkUser(startDto)) return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.success("닉네임이 중복됩니다."));
        loginService.loginUser(startDto);
        if(startDto.getMaxCount() != 0){
            return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.success(gameService.createGame(startDto)));
        }
        else if(startDto.getInvitationCode() != null){
            return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.success(gameService.joinGame(startDto)));
        }
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.success("방을 생성하거나, 입장해야합니다."));

    }
}
