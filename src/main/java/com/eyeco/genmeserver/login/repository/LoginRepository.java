package com.eyeco.genmeserver.login.repository;

import com.eyeco.genmeserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<User, Integer> {
    boolean existsByNickname(String nickname);
}
