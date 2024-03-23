package com.Tekken8CharacterBackend.Repository;

import com.Tekken8CharacterBackend.Model.CharacterMove;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterMoveRepository extends JpaRepository<CharacterMove, Long> {
    List<CharacterMove> getAllByTekkenCharacterId(Long tekkenCharacterId);
}
