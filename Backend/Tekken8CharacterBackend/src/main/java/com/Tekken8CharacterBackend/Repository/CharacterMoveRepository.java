package com.Tekken8CharacterBackend.Repository;

import com.Tekken8CharacterBackend.Model.CharacterMove;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterMoveRepository extends JpaRepository<CharacterMove, Long> {
}
