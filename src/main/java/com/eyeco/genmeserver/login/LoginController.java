package com.eyeco.genmeserver.login;

import com.eyeco.genmeserver.dto.ResponseDto;
import com.eyeco.genmeserver.dto.StartDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/start")
public class LoginController {

    @PostMapping()
    public ResponseEntity<ResponseDto<String>> startGame(@RequestBody StartDto startDto){
        if(startDto.getMaxCount() != null){
            
        }
        else if(startDto.getInvitationCode() != null){

        }
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.success("방을 생성하거나, 입장해야합니다."));

    }
}
