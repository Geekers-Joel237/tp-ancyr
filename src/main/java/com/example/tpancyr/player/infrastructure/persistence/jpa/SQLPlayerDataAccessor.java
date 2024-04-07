package com.example.tpancyr.player.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SQLPlayerDataAccessor extends JpaRepository<SQLPlayer, String> {
}
