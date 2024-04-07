package com.example.tpancyr.player.infrastructure.persistence.jpa;

import com.example.tpancyr.player.domain.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SQLPlayerDataAccessor extends JpaRepository<Player, String> {
}
