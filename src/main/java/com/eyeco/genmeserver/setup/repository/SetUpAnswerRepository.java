package com.eyeco.genmeserver.setup.repository;

import com.eyeco.genmeserver.entity.SetUpAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetUpAnswerRepository extends JpaRepository<SetUpAnswer,Integer> {
    SetUpAnswer findByNickname(String nickname);
}
