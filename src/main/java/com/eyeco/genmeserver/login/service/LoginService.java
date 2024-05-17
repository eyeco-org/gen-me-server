package com.eyeco.genmeserver.login.service;

import com.eyeco.genmeserver.dto.StartDto;
import com.eyeco.genmeserver.entity.User;
import com.eyeco.genmeserver.login.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.init.UncategorizedScriptException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {
    private final LoginRepository loginRepository;

    public String loginUser(StartDto startDto){
        User user = StartDto.toUser(startDto);
        log.info("유저 : {}", loginRepository.save(user).toString());
        return "아이디 생성에 성공했습니다.";
    }

    public boolean checkUser(StartDto startDto){
        User user = StartDto.toUser(startDto);
        return loginRepository.existsByNickname(user.getNickname());
    }
}
