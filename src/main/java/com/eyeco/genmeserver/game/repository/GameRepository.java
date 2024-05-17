package com.eyeco.genmeserver.game.repository;

import com.eyeco.genmeserver.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
