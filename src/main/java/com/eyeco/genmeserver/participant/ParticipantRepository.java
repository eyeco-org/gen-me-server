package com.eyeco.genmeserver.participant;

import com.eyeco.genmeserver.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
}
