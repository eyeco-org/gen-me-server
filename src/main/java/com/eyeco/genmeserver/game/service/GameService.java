package com.eyeco.genmeserver.game.service;

import com.eyeco.genmeserver.dto.StartDto;
import com.eyeco.genmeserver.entity.Game;
import com.eyeco.genmeserver.entity.Participant;
import com.eyeco.genmeserver.game.repository.GameRepository;
import com.eyeco.genmeserver.participant.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    private final ParticipantRepository participantRepository;

    public String createGame(StartDto startDto){
        Game game = StartDto.toGame(startDto);
        gameRepository.save(game);
        return "게임 생성에 성공했습니다.";
    }

    public String joinGame(StartDto startDto){
        Participant participant = StartDto.toParticipant(startDto);
        participantRepository.save(participant);
        return "게임 입장에 성공했습니다.";
    }
}
